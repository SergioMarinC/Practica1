package Vista;

import Controlador.ControladorEntrada;
import POJOs.Entrada;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IntroducirModificar extends JFrame {

    private final String[] nombreColumnas = {"Español", "Inglés", "Es Palabra" , "Sonido", "Fecha", "Ültimo test", "Aciertos"};
    private JPanel panel1;
    private JTable table1;
    private JButton anadirButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");


    public IntroducirModificar(){
        setContentPane(panel1);
        setTitle("Introducir o Modificar");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300,200);
        setVisible(true);

        //Tabla
        DefaultTableModel modelo = new DefaultTableModel();
        for (String e : nombreColumnas) {
            modelo.addColumn(e);
        }

        table1.setModel(modelo);

        cargarTablaEntradas();


        anadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioAgregarEntrada();
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = table1.getSelectedRow();
                if (filaSeleccionada != -1) {
                    mostrarFormularioModificarEntrada(filaSeleccionada);
                } else {
                    JOptionPane.showMessageDialog(IntroducirModificar.this, "Por favor, seleccione una entrada para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = table1.getSelectedRow();
                if (filaSeleccionada != -1) {
                    int opcion = JOptionPane.showConfirmDialog(IntroducirModificar.this, "¿Estás seguro de que deseas eliminar esta entrada?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                    if (opcion == JOptionPane.YES_OPTION) {
                        // Obtener la entrada seleccionada
                        Entrada entradaAEliminar = ControladorEntrada.obtenerEntradas().get(filaSeleccionada);
                        // Eliminar la entrada de la lista
                        ControladorEntrada.eliminarEntrada(entradaAEliminar);
                        // Actualizar la tabla
                        cargarTablaEntradas();
                    }
                } else {
                    JOptionPane.showMessageDialog(IntroducirModificar.this, "Por favor, seleccione una entrada para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void cargarTablaEntradas(){
        DefaultTableModel modelo = (DefaultTableModel) table1.getModel();
        modelo.setRowCount(0);

        for (Entrada entrada: ControladorEntrada.obtenerEntradas()) {
            Object[] fila = {
                    entrada.getEspanol(),
                    entrada.getIngles(),
                    entrada.isEsPalabra(),
                    entrada.getSonido(),
                    entrada.getFechaDeIntroduccion().format(formatter),
                    entrada.getUltimoTestRealizado() != null ? entrada.getUltimoTestRealizado().format(formatter) : "No realizado",
                    entrada.getNumeroDeAciertos()};
            modelo.addRow(fila);
        }
    }

    private void mostrarFormularioAgregarEntrada() {
        JDialog dialog = new JDialog(this, "Agregar Entrada", true);
        JPanel panel = new JPanel(new GridLayout(0, 2));

        JTextField espanolField = new JTextField();
        JTextField inglesField = new JTextField();
        JCheckBox esPalabraCheckbox = new JCheckBox();
        JTextField sonidoField = new JTextField();

        panel.add(new JLabel("Español:"));
        panel.add(espanolField);
        panel.add(new JLabel("Inglés:"));
        panel.add(inglesField);
        panel.add(new JLabel("Es Palabra:"));
        panel.add(esPalabraCheckbox);
        panel.add(new JLabel("Sonido:"));
        panel.add(sonidoField);

        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(e -> {
            // Obtener los datos ingresados por el usuario
            String espanol = espanolField.getText();
            String ingles = inglesField.getText();
            boolean esPalabra = esPalabraCheckbox.isSelected();
            String sonido = sonidoField.getText();
            // Crear una nueva entrada y agregarla a la lista
            Entrada nuevaEntrada = new Entrada(espanol, ingles, esPalabra, sonido, 0);
            ControladorEntrada.agregarEntrada(nuevaEntrada);
            // Actualizar la tabla
            cargarTablaEntradas();
            // Cerrar el diálogo
            dialog.dispose();
        });

        panel.add(addButton);

        dialog.add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void mostrarFormularioModificarEntrada(int filaSeleccionada) {
        // Obtener la entrada seleccionada en la tabla
        Entrada entradaSeleccionada = ControladorEntrada.obtenerEntradas().get(filaSeleccionada);

        // Crear un diálogo modal para el formulario de modificar entrada
        JDialog dialog = new JDialog(this, "Modificar Entrada", true);
        JPanel panel = new JPanel(new GridLayout(0, 2));

        JTextField espanolField = new JTextField(entradaSeleccionada.getEspanol());
        JTextField inglesField = new JTextField(entradaSeleccionada.getIngles());
        JCheckBox esPalabraCheckbox = new JCheckBox(String.valueOf(entradaSeleccionada.isEsPalabra()), entradaSeleccionada.isEsPalabra());
        JTextField sonidoField = new JTextField(entradaSeleccionada.getSonido());

        panel.add(new JLabel("Español:"));
        panel.add(espanolField);
        panel.add(new JLabel("Inglés:"));
        panel.add(inglesField);
        panel.add(new JLabel("Es Palabra:"));
        panel.add(esPalabraCheckbox);
        panel.add(new JLabel("Sonido:"));
        panel.add(sonidoField);

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(e -> {
            // Obtener los datos modificados por el usuario
            String espanol = espanolField.getText();
            String ingles = inglesField.getText();
            boolean esPalabra = esPalabraCheckbox.isSelected();
            String sonido = sonidoField.getText();

            // Actualizar la entrada seleccionada en la lista
            entradaSeleccionada.setEspanol(espanol);
            entradaSeleccionada.setIngles(ingles);
            entradaSeleccionada.setEsPalabra(esPalabra);
            entradaSeleccionada.setSonido(sonido);

            // Actualizar la tabla
            cargarTablaEntradas();

            // Cerrar el diálogo
            dialog.dispose();
        });

        panel.add(saveButton);

        dialog.add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
}
