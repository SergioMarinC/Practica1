package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class IntroducirModificar extends JFrame {

    private final String[] nombreColumnas = {"Español", "Inglés", "Palabra o expresión" , "Última modificación", "Ultimo test", "Aciertos"};
    private JPanel panel1;
    private JTable table1;
    private JButton anadirButton;
    private JButton modificarButton;
    private JButton eliminarButton;


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


    }

    private cargarTablaEntradas()
}
