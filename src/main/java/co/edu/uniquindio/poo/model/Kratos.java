package co.edu.uniquindio.poo.model;

public class Kratos extends Jugador {

    private String cabezaMedusa;
    private int daño=60;
    private int defensa=70;

    public Kratos(String nombre, string id ,int vida, UniVS ownedByUniVS, Equipo equipo, Batalla batalla, Puntaje puntaje, Dado dado, String cabezaMedusa) {
        super(nombre, id, 60, vida, 70, ownedByUniVS, equipo, batalla, puntaje, dado);
        if (cabezaMedusa.isBlank()) {
            throw new IllegalArgumentException("La cabeza de medusa no puede estar vacia");
        }
        this.cabezaMedusa = cabezaMedusa;
    }

    public String getCabezaMedusa() {
        return cabezaMedusa;
    }

    public void setCabezaMedusa(String cabezaMedusa) {
        this.cabezaMedusa = cabezaMedusa;
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
        return "Kratos \n cabezaMedusa" + cabezaMedusa + "\n daño:" + daño + "\n defensa:" + defensa;
    }

    
    
}

