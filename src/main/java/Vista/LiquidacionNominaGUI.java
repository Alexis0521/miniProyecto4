package Vista;

import Controlador.LiquidacionNominaControlador;
import Modelo.ConceptoDevengo;
import Modelo.ConceptoDeduccion;
import Modelo.Empleado;
import Modelo.LiquidacionNomina;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LiquidacionNominaGUI extends JFrame {

    private LiquidacionNominaControlador liquidacionNominaControlador;
    private List<LiquidacionNomina> liquidaciones;

    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblEmpleado;
    private JTextField txtEmpleado;
    private JButton btnAgregar;
    private JButton btnBuscar;
    private JTable tablaLiquidacion;
    private JScrollPane scrollPane;

    public LiquidacionNominaGUI() {
        liquidacionNominaControlador = new LiquidacionNominaControlador();
        liquidaciones = new ArrayList<>();

        lblId = new JLabel("ID:");
        txtId = new JTextField(10);
        lblEmpleado = new JLabel("Empleado:");
        txtEmpleado = new JTextField(20);
        btnAgregar = new JButton("Agregar");
        btnBuscar = new JButton("Buscar");
        tablaLiquidacion = new JTable();
        scrollPane = new JScrollPane(tablaLiquidacion);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                guardarLiquidaciones();
            }
        });

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLiquidacionNomina();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarLiquidacionNomina();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(lblId);
        panel.add(txtId);
        panel.add(lblEmpleado);
        panel.add(txtEmpleado);
        panel.add(btnAgregar);
        panel.add(btnBuscar);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.NORTH);
        this.getContentPane().add(scrollPane, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    

    private void agregarLiquidacionNomina() {
        int id = Integer.parseInt(txtId.getText());
        Date fecha = new Date();
        Empleado empleado = new Empleado(txtEmpleado.getText(), "", "", "", "", "", null, null, null, "", "", "");

        // Obtener los conceptos de devengo
        List<ConceptoDevengo> devengos = obtenerConceptosDevengo();

        // Obtener los conceptos de deducción
        List<ConceptoDeduccion> deducciones = obtenerConceptosDeduccion();

        // Calcular las deducciones automáticas (salud y fondo de pensión) si la sumatoria de devengos que hacen base es inferior al salario mínimo vigente
        double sumatoriaDevengosBase = calcularSumatoriaDevengosBase(devengos);
        double salarioMinimo = obtenerSalarioMinimoVigente();

        if (sumatoriaDevengosBase < salarioMinimo) {
            double deduccionSalud = sumatoriaDevengosBase * 0.04;
            double deduccionFondoPension = sumatoriaDevengosBase * 0.04;

            ConceptoDeduccion deduccionSaludAutomatica = new ConceptoDeduccion("DED_SALUD", "Deducción Salud (Automática)", deduccionSalud);
            ConceptoDeduccion deduccionFondoPensionAutomatica = new ConceptoDeduccion("DED_FONDO_PENSION", "Deducción Fondo de Pensión (Automática)", deduccionFondoPension);

            deducciones.add(deduccionSaludAutomatica);
            deducciones.add(deduccionFondoPensionAutomatica);
        }

        // Calcular las prestaciones sociales
        double cesantias = sumatoriaDevengosBase * 0.0833;
        double interesCesantias = sumatoriaDevengosBase * 0.01;
        double primas = sumatoriaDevengosBase * 0.0833;
        double vacaciones = sumatoriaDevengosBase * 0.0417;

        ConceptoDevengo cesantiasDevengo = new ConceptoDevengo("DEV_CESANTIAS", "Cesantías", true, cesantias);
        ConceptoDevengo interesCesantiasDevengo = new ConceptoDevengo("DEV_INTERES_CESANTIAS", "Interés de Cesantías", true, interesCesantias);
        ConceptoDevengo primasDevengo = new ConceptoDevengo("DEV_PRIMAS", "Primas", true, primas);
        ConceptoDevengo vacacionesDevengo = new ConceptoDevengo("DEV_VACACIONES", "Vacaciones", true, vacaciones);

        devengos.add(cesantiasDevengo);
        devengos.add(interesCesantiasDevengo);
        devengos.add(primasDevengo);
        devengos.add(vacacionesDevengo);

        // Agregar los conceptos de devengo y deducción a la liquidación de nómina a través del controlador
        liquidacionNominaControlador.agregarLiquidacionNomina(id, fecha, empleado, devengos, deducciones);

        // Actualizar la lista de liquidaciones
        actualizarListaLiquidaciones();

        // Guardar la liquidación de nómina en el archivo de texto
        guardarLiquidaciones();

        actualizarTablaLiquidacion();
    }

    private void guardarLiquidaciones() {
        try (PrintWriter writer = new PrintWriter("liquidaciones.txt")) {
            List<LiquidacionNomina> liquidaciones = liquidacionNominaControlador.obtenerTodasLasLiquidacionesNomina();
            for (LiquidacionNomina liquidacion : liquidaciones) {
                writer.println(liquidacion.getId() + ";"
                        + new SimpleDateFormat("dd/MM/yyyy").format(liquidacion.getFecha()) + ";"
                        + liquidacion.getEmpleado().getIdentificacion());

                // Guardar los conceptos de devengo
                List<ConceptoDevengo> devengos = liquidacion.getDevengos();
                writer.println(devengos.size());
                for (ConceptoDevengo devengo : devengos) {
                    writer.println(devengo.getCodigo() + ","
                            + devengo.getNombre() + ","
                            + devengo.isHacenBase() + ","
                            + devengo.getValor());
                }

                // Guardar los conceptos de deducción
                List<ConceptoDeduccion> deducciones = liquidacion.getDeducciones();
                writer.println(deducciones.size());
                for (ConceptoDeduccion deduccion : deducciones) {
                    writer.println(deduccion.getCodigo() + ","
                            + deduccion.getNombre() + ","
                            + deduccion.getValor());
                }

                writer.println(); // Línea en blanco entre las liquidaciones
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void actualizarListaLiquidaciones() {
        liquidaciones.clear(); // Limpiar la lista existente

        List<LiquidacionNomina> nuevasLiquidaciones = liquidacionNominaControlador.obtenerTodasLasLiquidacionesNomina();
        liquidaciones.addAll(nuevasLiquidaciones); // Agregar las nuevas liquidaciones a la lista existente
    }

    private List<ConceptoDevengo> obtenerConceptosDevengo() {
        List<ConceptoDevengo> devengos = new ArrayList<>();

        // Lógica para obtener los conceptos de devengo, por ejemplo, mediante cuadros de diálogo
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea agregar conceptos de devengo?", "Conceptos de Devengo", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            String codigo = JOptionPane.showInputDialog(this, "Ingrese el código del concepto de devengo:");
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del concepto de devengo:");
            double valor = Double.parseDouble(JOptionPane.showInputDialog(this, "Ingrese el valor del concepto de devengo:"));

            ConceptoDevengo devengo = new ConceptoDevengo(codigo, nombre, true, valor);
            devengos.add(devengo);
        }

        return devengos;
    }

    private List<ConceptoDeduccion> obtenerConceptosDeduccion() {
        List<ConceptoDeduccion> deducciones = new ArrayList<>();

        // Lógica para obtener los conceptos de deducción, por ejemplo, mediante cuadros de diálogo
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea agregar conceptos de deducción?", "Conceptos de Deducción", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            String codigo = JOptionPane.showInputDialog(this, "Ingrese el código del concepto de deducción:");
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del concepto de deducción:");
            double valor = Double.parseDouble(JOptionPane.showInputDialog(this, "Ingrese el valor del concepto de deducción:"));

            ConceptoDeduccion deduccion = new ConceptoDeduccion(codigo, nombre, valor);
            deducciones.add(deduccion);
        }

        return deducciones;
    }

    private double calcularSumatoriaDevengosBase(List<ConceptoDevengo> devengos) {
        double sumatoria = 0.0;

        for (ConceptoDevengo devengo : devengos) {
            if (devengo.isHacenBase()) {
                sumatoria += devengo.getValor();
            }
        }

        return sumatoria;
    }

    private double obtenerSalarioMinimoVigente() {
        // Lógica para obtener el salario mínimo vigente, por ejemplo, desde una base de datos o archivo de configuración
        return 1300606.0;
    }

    private void buscarLiquidacionNomina() {
        int id = Integer.parseInt(txtId.getText());

        LiquidacionNomina liquidacionNomina = liquidacionNominaControlador.buscarLiquidacionNomina(id);

        if (liquidacionNomina != null) {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Campo");
            model.addColumn("Valor");

            model.addRow(new Object[]{"ID", liquidacionNomina.getId()});
            model.addRow(new Object[]{"Fecha", new SimpleDateFormat("dd/MM/yyyy").format(liquidacionNomina.getFecha())});
            model.addRow(new Object[]{"Empleado", liquidacionNomina.getEmpleado().getIdentificacion()});

            // Mostrar valores automáticos, devengos que hacen base y deducciones
            for (ConceptoDevengo devengo : liquidacionNomina.getDevengos()) {
                if (devengo.isHacenBase()) {
                    model.addRow(new Object[]{devengo.getNombre(), devengo.getValor()});
                }
            }

            for (ConceptoDeduccion deduccion : liquidacionNomina.getDeducciones()) {
                model.addRow(new Object[]{deduccion.getNombre(), deduccion.getValor()});
            }

            // Mostrar valores específicos de las prestaciones sociales
            model.addRow(new Object[]{"Cesantías", liquidacionNomina.getCesantias()});
            model.addRow(new Object[]{"Interés de Cesantías", liquidacionNomina.getInteresCesantias()});
            model.addRow(new Object[]{"Primas", liquidacionNomina.getPrimas()});
            model.addRow(new Object[]{"Vacaciones", liquidacionNomina.getVacaciones()});

            tablaLiquidacion.setModel(model);
        } else {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mensaje");
            model.addRow(new Object[]{"Liquidación de nómina no encontrada"});

            tablaLiquidacion.setModel(model);
        }
    }

    private void actualizarTablaLiquidacion() {
        List<LiquidacionNomina> liquidaciones = liquidacionNominaControlador.obtenerTodasLasLiquidacionesNomina();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Fecha");
        model.addColumn("Empleado");

        for (LiquidacionNomina liquidacion : liquidaciones) {
            model.addRow(new Object[]{liquidacion.getId(), new SimpleDateFormat("dd/MM/yyyy").format(liquidacion.getFecha()), liquidacion.getEmpleado().getIdentificacion()});
        }

        tablaLiquidacion.setModel(model);
    }
}
