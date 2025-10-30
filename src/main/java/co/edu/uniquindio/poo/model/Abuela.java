package co.edu.uniquindio.poo.model;

import java.util.List;
public class Abuela extends Jugador implements Lanzable {

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

       public void defender(){
        System.out.println(" La abuela " + nombre + " se defendió con la chancla voladora ");
       
       defensa = defensa + 10;
       if (defensa>100){
        defensa=100;
       }
       System.out.println(" La defensa de la abuela " + nombre + " ahora es de: " + defensa);
}

    public void atacar(Jugador enemigo){
        int daño1=daño - enemigo.getDefensa();
        enemigo.recibirDaño(daño1);
        System.out.println(nombre + " atacó a " + enemigo.getNombre() + " causando " + daño1 + " de daño ");
    }

    public void recibirDaño(int dañoRecibido){
        int daño= dañoRecibido - defensa;
        if (daño<0){
            daño=0;
        }
        vida=vida-dañoRecibido;
        if(vida<0){
            vida=0;
        }

        System.out.println(nombre + " recibió " + daño + " de daño. \n la vida restante del jugador es: " + vida );
    }

    public void curar (){
        vida+=10;
        System.out.println(nombre + " la abuela se curó y ahora tiene " + vida + " de vida");
    }

    public void lanzar (){
        System.out.println( " La abuela " + nombre + " lanzó su chancla voladora ");
    }

}