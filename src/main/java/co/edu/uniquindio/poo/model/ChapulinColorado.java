package co.edu.uniquindio.poo.model;


public class ChapulinColorado extends Jugador {

    private String antenitasDeVinil;

    public ChapulinColorado(String nombre, String antenitasDeVinil, int daño, int defensa, int vida) {
        if (nombre == null || nombre.isEmpty() ||
            antenitasDeVinil == null || antenitasDeVinil.isEmpty() ||
            daño < 0 || defensa < 0 || vida <= 0) {
            throw new IllegalArgumentException("Datos inválidos para crear Chapulín Colorado");
        }

        this.nombre = nombre;
        this.antennitasDeVinil = antenitasDeVinil;
        this.daño = daño;
        this.defensa = defensa;
        this.vida = vida;
    }

   
    public String getAntennitasDeVinil() {
        return antenitasDeVinil;
    }

     public void setAntenitasDeVinil(String antenitasDeVinil) {
        this.antenitasDeVinil = antenitasDeVinil;
    }

    
    @Override
    public void atacar() {
        
    }

    @Override
    public void defender() {
        
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

   


   
}














