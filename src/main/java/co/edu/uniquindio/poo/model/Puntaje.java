package co.edu.uniquindio.poo.model;

public class Puntaje{

    private String puntaje;
    private Jugador jugador;
    private UniVS ownedByUniVS;
    private Equipo equipo;

    public Puntaje(String puntaje, Jugador jugador, UniVS ownedByUniVS, Equipo equipo) {
        if(puntaje.isBlank()){
            throw new IllegalArgumentException(" los datos son invalidos")
        }
        this.puntaje = puntaje;
        this.jugador = jugador;
        this.ownedByUniVS = ownedByUniVS;
        this.equipo = equipo;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public UniVS getOwnedByUniVS() {
        return ownedByUniVS;
    }

    public void setOwnedByUniVS(UniVS ownedByUniVS) {
        this.ownedByUniVS = ownedByUniVS;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Puntaje puntaje" + puntaje ;
    }
    

    
}