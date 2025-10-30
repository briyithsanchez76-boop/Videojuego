package co.edu.uniquindio.poo.model;
import java.util.List;

public class Equipo {
    private String nombre;
    private List<Jugador> listaJugadores;
    private UniVS ownedByUniVS;
    private Batalla batalla;

    public Equipo(String nombre, List<Jugador> listaJugadores, UniVS ownedByUniVS, Batalla batalla) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
        this.listaJugadores = listaJugadores;
        this.ownedByUniVS = ownedByUniVS;
        this.batalla = batalla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public UniVS getOwnedByUniVS() {
        return ownedByUniVS;
    }

    public void setOwnedByUniVS(UniVS ownedByUniVS) {
        this.ownedByUniVS = ownedByUniVS;
    }

    public Batalla getBatalla() {
        return batalla;
    }

    public void setBatalla(Batalla batalla) {
        this.batalla = batalla;
    }

    public boolean tieneJugadoresVivos() {
        if (listaJugadores == null || listaJugadores.isEmpty()) {
            return false;
        }
        
        // Verifica si hay al menos un jugador con vida mayor a 0
        for (Jugador jugador : listaJugadores) {
            if (jugador.getVida() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Equipo: " + nombre;
    }
}