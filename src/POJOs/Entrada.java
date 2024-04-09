package POJOs;

import java.time.LocalDateTime;

public class Entrada {

    private String espanol;
    private String ingles;
    private boolean esPalabra;
    private String sonido;
    private LocalDateTime fechaDeIntroduccion;
    private LocalDateTime ultimoTestRealizado;
    private int numeroDeAciertos;

    public Entrada(String espanol, String ingles, boolean esPalabra, String sonido, int numeroDeAciertos) {
        this.espanol = espanol;
        this.ingles = ingles;
        this.esPalabra = esPalabra;
        this.sonido = sonido;
        this.fechaDeIntroduccion = LocalDateTime.now();
        this.ultimoTestRealizado = null;
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

    public LocalDateTime getFechaDeIntroduccion() {
        return fechaDeIntroduccion;
    }

    public void setFechaDeIntroduccion(LocalDateTime fechaDeIntroduccion) {
        this.fechaDeIntroduccion = fechaDeIntroduccion;
    }

    public LocalDateTime getUltimoTestRealizado() {
        return ultimoTestRealizado;
    }

    public void setUltimoTestRealizado(LocalDateTime ultimoTestRealizado) {
        this.ultimoTestRealizado = ultimoTestRealizado;
    }

    public int getNumeroDeAciertos() {
        return numeroDeAciertos;
    }

    public void setNumeroDeAciertos(int numeroDeAciertos) {
        this.numeroDeAciertos = numeroDeAciertos;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "espanol='" + espanol + '\'' +
                ", ingles='" + ingles + '\'' +
                ", esPalabra=" + esPalabra +
                ", sonido='" + sonido + '\'' +
                ", fechaDeIntroduccion=" + fechaDeIntroduccion +
                ", ultimoTestRealizado=" + ultimoTestRealizado +
                ", numeroDeAciertos=" + numeroDeAciertos +
                '}';
    }
}
