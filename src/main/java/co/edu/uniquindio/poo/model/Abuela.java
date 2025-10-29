package co.edu.uniquindio.poo.model;

import java.util.List;
public class Abuela extends Jugador {

    private String lentes;
    private int daño=100;
    private int defensa=2;

    public Abuela(String nombre,String id, int vida, UniVS ownedByUniVS, Equipo equipo, Batalla batalla, List<Puntaje> puntaje, Dado dado, String lentes) {
        super(nombre,id, 100, vida, 2, ownedByUniVS, equipo, batalla, puntaje, dado);
        if (lentes.isBlank()) {
            throw new IllegalArgumentException("Los lentes no pueden estar vacios");
        }
        this.lentes = lentes;
    }

    public String getLentes() {
        return lentes;
    }

    public void setLentes(String lentes) {
        this.lentes = lentes;
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
        return "Abuela \n lentes" + lentes + "\n daño:" + daño + "\n defensa:" + defensa;
    }
       
}
