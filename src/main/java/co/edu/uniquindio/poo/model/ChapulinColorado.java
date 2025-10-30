package co.edu.uniquindio.poo.model;

import java.util.List;

public class ChapulinColorado extends Jugador {

    private String antenitasDeVinil;
    private int daño = 35;
    private int defensa = 20;

    public ChapulinColorado(String nombre, String id, int vida, UniVS ownedByUniVS, Equipo equipo, Batalla batalla, List<Puntaje> puntaje, Dado dado, String antenitasDeVinil) {
        super(nombre, id, 35, vida, 20, ownedByUniVS, equipo, batalla, puntaje, dado);
        if (antenitasDeVinil == null || antenitasDeVinil.isBlank()) {
            throw new IllegalArgumentException("Las antenitas de vinil no pueden estar vacías");
        }
        this.antenitasDeVinil = antenitasDeVinil;
    }

    public String getAntenitasDeVinil() {
        return antenitasDeVinil;
    }

    public void setAntenitasDeVinil(String antenitasDeVinil) {
        this.antenitasDeVinil = antenitasDeVinil;
    }

    @Override
    public void atacar(Jugador enemigo) {
        System.out.println("¡" + nombre + " ataca con su Chipote Chillón!");
        int dañoFinal = this.daño - enemigo.getDefensa();
        if(dañoFinal < 0) dañoFinal = 0;
        enemigo.recibirDaño(dañoFinal);
        System.out.println(nombre + " causó " + dañoFinal + " de daño a " + enemigo.getNombre());
    }

    @Override
    public void defender() {
        System.out.println("¡Síganme los buenos! " + nombre + " se defiende con su astucia");
        defensa += 12;
        if(defensa > 100) defensa = 100;
        System.out.println("La defensa de " + nombre + " aumentó a " + defensa);
    }

    @Override
    public void curar() {
        System.out.println(nombre + " toma una pastilla de chiquitolina para recuperarse");
        vida += 15;
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

    @Override
    public String toString() {
        return "Chapulín Colorado \n antenitas=" + antenitasDeVinil + "\n daño=" + daño + "\n defensa=" + defensa;
    }
}














