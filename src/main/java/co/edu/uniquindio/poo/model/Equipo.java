package co.edu.uniquindio.poo.model;

import java.util.List;

public class Equipo {
    private String nombre;
    private int puntajeTotal;
    private UniVS ownedByUniVS;
    private List<Jugador> listaJugadores=new LinkedList<Jugador>();
    private Batalla batalla;

    public Equipo(String nombre, int puntajeTotal, UniVS ownedByUniVS, Batalla batalla) {
        if (nombre.isBlank() || puntajeTotal < 0) {
            throw new IllegalArgumentException("Los datos no pueden ser nulos o negativos");
            
        }
        this.nombre = nombre;
        this.puntajeTotal = 0;
        this.ownedByUniVS = ownedByUniVS;
        this.batalla = batalla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public UniVS getOwnedByUniVS() {
        return ownedByUniVS;
    }

    public void setOwnedByUniVS(UniVS ownedByUniVS) {
        this.ownedByUniVS = ownedByUniVS;
    }

    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public Batalla getBatalla() {
        return batalla;
    }

    public void setBatalla(Batalla batalla) {
        this.batalla = batalla;
    }    

}
