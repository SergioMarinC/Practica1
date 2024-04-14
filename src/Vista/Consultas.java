package Vista;

import Controlador.ControladorEntrada;
import POJOs.Entrada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Consultas extends JFrame {

    private JPanel panel1;
    private JButton orden_aciertos;
    private JButton ingles_espanol;
    private JButton palabra_expresion;
    private JTextField textoBusqueda;
    private JButton buscarButton;
    private JPanel JPanelBotonera;
    private JPanel JPanelBusqueda;
    private JPanel JPanelConsulta;

    public Consultas(){
        setContentPane(panel1);
        setTitle("Consultas");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300,200);
        setVisible(true);

        JPanelConsulta.setLayout(new GridLayout(ControladorEntrada.obtenerEntradas().size(),3));

        for (Entrada entrada : ControladorEntrada.obtenerEntradas()){
            JLabel labelEspanol = new JLabel(entrada.getEspanol());
            JLabel labelIngles = new JLabel(entrada.getIngles());
            JButton boton = new JButton("Sonido");

            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });

            JPanelConsulta.add(labelEspanol);
            JPanelConsulta.add(labelIngles);
            JPanelConsulta.add(boton);
        }
    }
}
