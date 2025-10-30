package co.edu.uniquindio.poo.model;

public class Puntaje{

    private int puntaje;
    private Jugador jugador;
    private UniVS ownedByUniVS;
    private Equipo equipo;

    public Puntaje(int puntaje, Jugador jugador, UniVS ownedByUniVS, Equipo equipo) {
        if(puntaje<0){
            throw new IllegalArgumentException(" los datos son invalidos");
        }
        this.puntaje = puntaje;
        this.jugador = jugador;
        this.ownedByUniVS = ownedByUniVS;
        this.equipo = equipo;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
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
    
    public void mostrarPuntaje() {
        System.out.println("   Tabla de Puntaje ");
        System.out.println("Puntaje: " + puntaje);
        System.out.println("Jugador: " + jugador.toString());
        System.out.println("Equipo: " + equipo.toString());
    }

    public void disminuirPuntaje(int puntos){
        puntaje = puntaje-puntos;
        if(puntaje<0){
            puntaje=0;
        }
    }
     public void aumentarPuntaje(int puntos){
        puntaje = puntaje+puntos;
        
    }
}