package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel panel1;
    private JButton introducirModificarButton;
    private JButton consultasButton;
    private JButton testButton;

    public Menu(){
        setContentPane(panel1);
        setTitle("Menu Diccionario");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,200);
        setVisible(true);

        introducirModificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new IntroducirModificar();
            }
        });
        consultasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Consultas();
            }
        });
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Test();
            }
        });
    }
}
