package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class HarryPotter extends Jugador{

    private String varita;
    private int daño= 40;
    private int defensa= 10;

    public HarryPotter(String nombre, String id, int daño, int vida, int defensa, UniVS ownedByUniVS, Equipo equipo, Batalla batalla, LinkedList<Puntaje> listaPuntajes, Dado dado) {
        super(nombre, id, 40, vida, 10, ownedByUniVS, equipo, batalla, listaPuntajes, dado);

        if (varita.isBlank()) {
            throw new IllegalArgumentException("La varita no puede estar vacía");
        }
        this.varita = varita;
    }

    public String getVarita() {
        return varita;
    }

    public void setVarita(String varita) {
        this.varita = varita;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    public String toString() {
        return "Harry Potter \n varita=" + varita + "\n daño=" + daño + "\n defensa=" + defensa;
    }

}