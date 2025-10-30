package co.edu.uniquindio.poo.model;

import java.util.Optional;
import java.util.List;
public abstract class Jugador implements Atacable, Curable, Defendible {

    protected String nombre;
    protected String id;
    protected int daño;
    protected int vida;
    protected int defensa;
    private UniVS ownedByUniVS;
    private Equipo equipo;
    private Batalla batalla;
    private List<Puntaje> listaPuntajes;
    private Dado dado;

    public Jugador(String nombre, String id, int daño, int vida, int defensa, UniVS ownedByUniVS, Equipo equipo, Batalla batalla, List<Puntaje> listaPuntajes, Dado dado) {

        if(nombre.isBlank()&& id.isBlank() && daño<0 && vida<0 && defensa<0){
            throw new IllegalArgumentException("Los valores ingresados no son validos");
        }

        this.nombre = nombre;
        this.id = id;
        this.daño = daño;
        this.vida = vida;
        this.defensa = defensa;
        this.ownedByUniVS = ownedByUniVS;
        this.equipo = equipo;
        this.batalla = batalla;
        this.listaPuntajes = listaPuntajes;
        this.dado = dado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Puntaje> getListaPuntajes() {
        return listaPuntajes;
    }

    public void setPuntaje(List<Puntaje> puntaje) {
        this.listaPuntajes = puntaje;
    }

    public Dado getDado() {
        return dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }

    public int getAtaque() {
        return daño;
    }

    @Override
    public String toString() {
        return "Jugador \n nombre " + nombre + " id: "+ id + "\n daño=" + daño + "\n vida=" + vida + "\n defensa=" + defensa;
    }

    public int atacar() {
        int valorDado = dado.lanzarDado();
        return daño + valorDado;
    }

    public abstract void recibirDaño(int daño);
}
  