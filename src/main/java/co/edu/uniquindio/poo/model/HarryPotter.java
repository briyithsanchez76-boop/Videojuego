package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class HarryPotter extends Jugador {

    private String varita;
    private int daño = 40;
    private int defensa = 10;

    public HarryPotter(String nombre, String id, int vida, UniVS ownedByUniVS, Equipo equipo, Batalla batalla, LinkedList<Puntaje> listaPuntajes, Dado dado, String varita) {
        super(nombre, id, 40, vida, 10, ownedByUniVS, equipo, batalla, listaPuntajes, dado);
        if (varita == null || varita.isBlank()) {
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

    @Override
    public void atacar(Jugador enemigo) {
        System.out.println(nombre + " ataca con un hechizo!");
        int dañoFinal = this.daño - enemigo.getDefensa();
        if(dañoFinal < 0) dañoFinal = 0;
        enemigo.recibirDaño(dañoFinal);
        System.out.println(nombre + " causó " + dañoFinal + " de daño a " + enemigo.getNombre());
    }

    @Override
    public void defender() {
        System.out.println(nombre + " se defiende con Protego!");
        defensa += 15;
        if(defensa > 100) defensa = 100;
        System.out.println("La defensa de " + nombre + " aumentó a " + defensa);
    }

    @Override
    public void curar() {
        System.out.println(nombre + " usa Episkey para curarse!");
        vida += 20;
        if(vida > 100) vida = 100;
        System.out.println(nombre + " se ha curado. Vida actual: " + vida);
    }

    @Override
    public void recibirDaño(int dañoRecibido) {
        int dañoFinal = dañoRecibido - defensa;
        if(dañoFinal < 0) dañoFinal = 0;
        vida -= dañoFinal;
        if(vida < 0) vida = 0;
        System.out.println(nombre + " recibió " + dañoFinal + " de daño. Vida restante: " + vida);
    }
}