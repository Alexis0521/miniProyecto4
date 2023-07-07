package Vista;

import Controlador.EmpleadoControlador;
import Modelo.Empleado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EmpleadoGUI extends JFrame {

    private EmpleadoControlador empleadoControlador;
    private DefaultTableModel empleadoTableModel;
    private JTable empleadoTable;

    private JLabel lblIdentificacion;
    private JTextField txtIdentificacion;
    private JLabel lblNombres;
    private JTextField txtNombres;
    private JLabel lblApellidos;
    private JTextField txtApellidos;
    private JLabel lblDireccion;
    private JTextField txtDireccion;
    private JLabel lblEPS;
    private JTextField txtEPS;
    private JLabel lblFondoPension;
    private JTextField txtFondoPension;
    private JLabel lblFechaNacimiento;
    private JTextField txtFechaNacimiento;
    private JLabel lblFechaIngreso;
    private JTextField txtFechaIngreso;
    private JLabel lblFechaRetiro;
    private JTextField txtFechaRetiro;
    private JLabel lblTipoTrabajador;
    private JRadioButton rbSocio;
    private JRadioButton rbNoSocio;
    private JLabel lblTipoSalario;
    private JRadioButton rbAcumulado;
    private JRadioButton rbFijo;
    private JLabel lblNumeroCuenta;
    private JTextField txtNumeroCuenta;
    private JButton btnAgregar;
    private JButton btnAbrirLiquidacion;
    //private JButton btnEliminar;

    public EmpleadoGUI() {
        empleadoControlador = new EmpleadoControlador();

        lblIdentificacion = new JLabel("Identificación:");
        txtIdentificacion = new JTextField(10);
        lblNombres = new JLabel("Nombres:");
        txtNombres = new JTextField(20);
        lblApellidos = new JLabel("Apellidos:");
        txtApellidos = new JTextField(20);
        lblDireccion = new JLabel("Dirección:");
        txtDireccion = new JTextField(50);
        lblEPS = new JLabel("EPS:");
        txtEPS = new JTextField(10);
        lblFondoPension = new JLabel("Fondo de Pensión:");
        txtFondoPension = new JTextField(10);
        lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        txtFechaNacimiento = new JTextField(10);
        lblFechaIngreso = new JLabel("Fecha de Ingreso:");
        txtFechaIngreso = new JTextField(10);
        lblFechaRetiro = new JLabel("Fecha de Retiro:");
        txtFechaRetiro = new JTextField(10);
        lblTipoTrabajador = new JLabel("Tipo de Trabajador:");
        rbSocio = new JRadioButton("Socio");
        rbNoSocio = new JRadioButton("No Socio");
        lblTipoSalario = new JLabel("Tipo de Salario:");
        rbAcumulado = new JRadioButton("Acumulado");
        rbFijo = new JRadioButton("Fijo");
        lblNumeroCuenta = new JLabel("Número de Cuenta Bancaria:");
        txtNumeroCuenta = new JTextField(20);
        btnAgregar = new JButton("Agregar");
        btnAbrirLiquidacion = new JButton("Abrir Liquidación");
        //btnEliminar = new JButton("Eliminar");
        empleadoTableModel = new DefaultTableModel();
        empleadoTableModel.addColumn("Identificación");
        empleadoTableModel.addColumn("Apellidos");
        empleadoTableModel.addColumn("Nombres");
        empleadoTableModel.addColumn("Direccion");
        empleadoTableModel.addColumn("EPS");
        empleadoTableModel.addColumn("Fondo Pension");
        empleadoTableModel.addColumn("Fecha Nacimiento");
        empleadoTableModel.addColumn("Fecha Ingreso");
        empleadoTableModel.addColumn("Fecha Retiro");
        empleadoTableModel.addColumn("Tipo Trabajador");
        empleadoTableModel.addColumn("Tipo Salario");
        empleadoTableModel.addColumn("Numero Cuenta");
        cargarDatos();

        empleadoTable = new JTable(empleadoTableModel);
        JScrollPane tableScrollPane = new JScrollPane(empleadoTable);
        this.getContentPane().add(tableScrollPane, BorderLayout.CENTER);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEmpleado();
            }
        });

        /*btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCuadroEliminarEmpleado();
            }
        });*/

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                guardarDatos();
            }
        });

        btnAbrirLiquidacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirLiquidacionNominaGUI();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(14, 2));
        panel.add(lblIdentificacion);
        panel.add(txtIdentificacion);
        panel.add(lblNombres);
        panel.add(txtNombres);
        panel.add(lblApellidos);
        panel.add(txtApellidos);
        panel.add(lblDireccion);
        panel.add(txtDireccion);
        panel.add(lblEPS);
        panel.add(txtEPS);
        panel.add(lblFondoPension);
        panel.add(txtFondoPension);
        panel.add(lblFechaNacimiento);
        panel.add(txtFechaNacimiento);
        panel.add(lblFechaIngreso);
        panel.add(txtFechaIngreso);
        panel.add(lblFechaRetiro);
        panel.add(txtFechaRetiro);
        panel.add(lblTipoTrabajador);
        panel.add(rbSocio);
        panel.add(rbNoSocio);
        panel.add(lblTipoSalario);
        panel.add(rbAcumulado);
        panel.add(rbFijo);
        panel.add(lblNumeroCuenta);
        panel.add(txtNumeroCuenta);
        panel.add(btnAgregar);
        panel.add(btnAbrirLiquidacion);
        //panel.add(btnEliminar);

        ButtonGroup tipoTrabajadorGroup = new ButtonGroup();
        tipoTrabajadorGroup.add(rbSocio);
        tipoTrabajadorGroup.add(rbNoSocio);

        ButtonGroup tipoSalarioGroup = new ButtonGroup();
        tipoSalarioGroup.add(rbAcumulado);
        tipoSalarioGroup.add(rbFijo);

        this.getContentPane().add(panel, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void agregarEmpleado() {
        String identificacion = txtIdentificacion.getText();
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        String direccion = txtDireccion.getText();
        String eps = txtEPS.getText();
        String fondoPension = txtFondoPension.getText();
        Date fechaNacimiento = obtenerFecha(txtFechaNacimiento.getText());
        Date fechaIngreso = obtenerFecha(txtFechaIngreso.getText());
        Date fechaRetiro = obtenerFecha(txtFechaRetiro.getText());
        String tipoTrabajador = obtenerTipoTrabajador();
        String tipoSalario = obtenerTipoSalario();
        String numeroCuenta = txtNumeroCuenta.getText();

        Empleado empleado = new Empleado(identificacion, apellidos, nombres, direccion, eps, fondoPension, fechaNacimiento, fechaIngreso, fechaRetiro, tipoTrabajador, tipoSalario, numeroCuenta);
        empleadoControlador.agregarEmpleado(empleado);

        empleadoTableModel.addRow(new Object[]{empleado.getIdentificacion(), empleado.getNombres(), empleado.getApellidos(), empleado.getDireccion(), empleado.getEpsCodigo(), empleado.getFppCodigo(), empleado.getFechaNacimiento(), empleado.getFechaIngreso(), empleado.getFechaRetiro(), empleado.getTipoTrabajador(), empleado.getTipoSalario(), empleado.getNumeroCuentaBancaria()});

        JOptionPane.showMessageDialog(this, "Empleado agregado correctamente");
    }

    private Date obtenerFecha(String fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void mostrarCuadroEliminarEmpleado() {
        String identificacion = JOptionPane.showInputDialog(this, "Ingrese la identificación del empleado a eliminar:", "Eliminar Empleado", JOptionPane.PLAIN_MESSAGE);
        if (identificacion != null && !identificacion.isEmpty()) {
            eliminarEmpleado(identificacion);
        }
    }

    private void eliminarEmpleado(String identificacion) {
        Empleado empleado = empleadoControlador.buscarEmpleado(identificacion);
        if (empleado != null) {
            empleadoControlador.eliminarEmpleado(identificacion);

            empleadoTableModel.removeRow(obtenerIndiceFila(identificacion));
            JOptionPane.showMessageDialog(this, "Empleado eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ningún empleado con la identificación proporcionada", "Eliminar Empleado - Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int obtenerIndiceFila(String identificacion) {
        for (int i = 0; i < empleadoTableModel.getRowCount(); i++) {
            String identificacionEmpleado = (String) empleadoTableModel.getValueAt(i, 0);
            if (identificacionEmpleado.equals(identificacion)) {
                return i;
            }
        }
        return -1;
    }

    private String obtenerTipoTrabajador() {
        if (rbSocio.isSelected()) {
            return "Socio";
        } else if (rbNoSocio.isSelected()) {
            return "No Socio";
        } else {
            return "";
        }
    }

    private String obtenerTipoSalario() {
        if (rbAcumulado.isSelected()) {
            return "Acumulado";
        } else if (rbFijo.isSelected()) {
            return "Fijo";
        } else {
            return "";
        }
    }

    private void cargarDatos() {
        List<Empleado> empleados = ArchivoEmpleado.cargarEmpleados();
        for (Empleado empleado : empleados) {
            empleadoTableModel.addRow(new Object[]{
                empleado.getIdentificacion(),
                empleado.getNombres(),
                empleado.getApellidos(),
                empleado.getDireccion(),
                empleado.getEpsCodigo(),
                empleado.getFppCodigo(),
                empleado.getFechaNacimiento(),
                empleado.getFechaIngreso(),
                empleado.getFechaRetiro(),
                empleado.getTipoTrabajador(),
                empleado.getTipoSalario(),
                empleado.getNumeroCuentaBancaria()
            });
        }
    }

    private void guardarDatos() {
        List<Empleado> empleados = new ArrayList<>();
        int rowCount = empleadoTableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String identificacion = (String) empleadoTableModel.getValueAt(i, 0);
            String nombres = (String) empleadoTableModel.getValueAt(i, 1);
            String apellidos = (String) empleadoTableModel.getValueAt(i, 2);
            String direccion = (String) empleadoTableModel.getValueAt(i, 3);
            String eps = (String) empleadoTableModel.getValueAt(i, 4);
            String fondoPension = (String) empleadoTableModel.getValueAt(i, 5);
            Date fechaNacimiento = (Date) empleadoTableModel.getValueAt(i, 6);
            Date fechaIngreso = (Date) empleadoTableModel.getValueAt(i, 7);
            Date fechaRetiro = (Date) empleadoTableModel.getValueAt(i, 8);
            String tipoTrabajador = (String) empleadoTableModel.getValueAt(i, 9);
            String tipoSalario = (String) empleadoTableModel.getValueAt(i, 10);
            String numeroCuenta = (String) empleadoTableModel.getValueAt(i, 11);

            Empleado empleado = new Empleado(identificacion, apellidos, nombres, direccion, eps, fondoPension, fechaNacimiento, fechaIngreso, fechaRetiro, tipoTrabajador, tipoSalario, numeroCuenta);
            empleados.add(empleado);
        }
        ArchivoEmpleado.guardarEmpleados(empleados);
    }

    private void abrirLiquidacionNominaGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LiquidacionNominaGUI();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmpleadoGUI();
            }
        });
    }
}
