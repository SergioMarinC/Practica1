package DAOs;

import POJOs.Entrada;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DaoEntrada {

    private ArrayList<Entrada> entradas = new ArrayList<>();

    public DaoEntrada() {
        entradas.add(new Entrada("Español1", "Inglés1", true, "Sonido1",0));
        entradas.add(new Entrada("Español2", "Inglés2", true, "Sonido2",0));
    }

    public ArrayList<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(ArrayList entradas) {
        this.entradas = entradas;
    }
}
