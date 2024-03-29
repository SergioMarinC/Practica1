package Modelo;

import java.util.Date;

public class Entrada {

    private String espanol;
    private String ingles;
    private boolean esPalabra;
    private String sonido;
    private Date fechaDeIntroduccion;
    private Date ultimoTestRealizado;
    private int numeroDeAciertos;

    public Entrada(String espanol, String ingles, boolean esPalabra, String sonido, Date fechaDeIntroduccion, Date ultimoTestRealizado, int numeroDeAciertos) {
        this.espanol = espanol;
        this.ingles = ingles;
        this.esPalabra = esPalabra;
        this.sonido = sonido;
        this.fechaDeIntroduccion = fechaDeIntroduccion;
        this.ultimoTestRealizado = ultimoTestRealizado;
        this.numeroDeAciertos = numeroDeAciertos;
    }

    public String getEspanol() {
        return espanol;
    }

    public void setEspanol(String espanol) {
        this.espanol = espanol;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public boolean isEsPalabra() {
        return esPalabra;
    }

    public void setEsPalabra(boolean esPalabra) {
        this.esPalabra = esPalabra;
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    public Date getFechaDeIntroduccion() {
        return fechaDeIntroduccion;
    }

    public void setFechaDeIntroduccion(Date fechaDeIntroduccion) {
        this.fechaDeIntroduccion = fechaDeIntroduccion;
    }

    public Date getUltimoTestRealizado() {
        return ultimoTestRealizado;
    }

    public void setUltimoTestRealizado(Date ultimoTestRealizado) {
        this.ultimoTestRealizado = ultimoTestRealizado;
    }

    public int getNumeroDeAciertos() {
        return numeroDeAciertos;
    }

    public void setNumeroDeAciertos(int numeroDeAciertos) {
        this.numeroDeAciertos = numeroDeAciertos;
    }
}
