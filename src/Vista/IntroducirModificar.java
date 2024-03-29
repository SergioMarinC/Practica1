package Vista;

import javax.swing.*;

public class IntroducirModificar extends JFrame {

    private JPanel panel1;

    public IntroducirModificar(){
        setContentPane(panel1);
        setTitle("Introducir o Modificar");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300,200);
        setVisible(true);
    }
}
