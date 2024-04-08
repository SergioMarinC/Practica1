package Controlador;

import DAOs.DaoEntrada;
import POJOs.Entrada;

import java.util.ArrayList;

public class ControladorEntrada {

    private static DaoEntrada daoEntrada = new DaoEntrada();

    public static ArrayList<Entrada> obtenerEntradas(){
        return daoEntrada.getEntradas();
    }

    public static void agregarEntrada(Entrada nuevaEntrada){
        ArrayList<Entrada> entradas = daoEntrada.getEntradas();
        entradas.add(nuevaEntrada);
        daoEntrada.setEntradas(entradas);
    }
}
