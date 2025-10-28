package co.edu.uniquindio.poo.model;

public abstract class Jugador implements Atacable, Curable, Defendible {

    private String nombre;
    private int daño;
    private int vida;
    private int defensa;
    private UniVS ownedByUniVS;
    private Equipo equipo;
    private Batalla batalla;
    private Puntaje puntaje;
    private Dado dado;

    public Jugador(String nombre, int daño, int vida, int defensa, UniVS ownedByUniVS, Equipo equipo,
            Batalla batalla, Puntaje puntaje, Dado dado) {

        if(nombre.isBlank()&& daño<0 && vida<0 && defensa<0){
            throw new IllegalArgumentException("Los valores ingresados no son validos");
        }

        this.nombre = nombre;
        this.daño = daño;
        this.vida = vida;
        this.defensa = defensa;
        this.ownedByUniVS = ownedByUniVS;
        this.equipo = equipo;
        this.batalla = batalla;
        this.puntaje = puntaje;
        this.dado = dado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
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

    public Batalla getBatalla() {
        return batalla;
    }

    public void setBatalla(Batalla batalla) {
        this.batalla = batalla;
    }

    public Puntaje getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Puntaje puntaje) {
        this.puntaje = puntaje;
    }

    public Dado getDado() {
        return dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }

    @Override
    public String toString() {
        return "Jugador \n nombre " + nombre + "\n daño=" + daño + "\n vida=" + vida + "\n defensa=" + defensa;
    }

}
