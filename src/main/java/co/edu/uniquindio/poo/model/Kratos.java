package co.edu.uniquindio.poo.model;
import java.util.List;

public class Kratos extends Jugador {

    private String cabezaMedusa;
    private boolean modoFuria;
    private int daño=60;
    private int defensa=70;

    public Kratos(String nombre, String id ,int vida, UniVS ownedByUniVS, Equipo equipo, Batalla batalla, List<Puntaje> puntaje, Dado dado, String cabezaMedusa, boolean modoFuria) {
        super(nombre, id, 60, vida, 70, ownedByUniVS, equipo, batalla, puntaje, dado);
        if (cabezaMedusa.isBlank()) {
            throw new IllegalArgumentException("La cabeza de medusa no puede estar vacia");
        }
        this.cabezaMedusa = cabezaMedusa;
        this.modoFuria=modoFuria;
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

     public boolean isModoFuria() {
         return modoFuria;
     }

     public void setModoFuria(boolean modoFuria) {
         this.modoFuria = modoFuria;
     }

    @Override
    public String toString() {
        return "Kratos \n cabezaMedusa" + cabezaMedusa + "\n daño:" + daño + "\n defensa:" + defensa;
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

    public void activarFuria(){
        if(!modoFuria){
            modoFuria=true;
            daño+=20;
            defensa+=10;
            System.out.println(nombre + " Kratos está en modo furia su ataque y defensa aumentarán temporalmente");
        }
    }

    // Métodos adicionales implementando las interfaces
    public void atacar(Jugador enemigo){
        System.out.println(nombre + " ataca con las Espadas del Caos!");
        int dañoTotal = daño;
        if(modoFuria) {
            dañoTotal += 15;
            System.out.println("¡El modo furia aumenta el daño!");
        }
        int dañoFinal = dañoTotal - enemigo.getDefensa();
        if(dañoFinal < 0) dañoFinal = 0;
        enemigo.recibirDaño(dañoFinal);
        System.out.println(nombre + " causó " + dañoFinal + " de daño a " + enemigo.getNombre());
    }

    public void defender(){
        System.out.println(nombre + " se defiende con el Escudo del Guardián!");
        int defensaExtra = 15;
        if(modoFuria) {
            defensaExtra += 5;
            System.out.println("¡El modo furia aumenta la defensa!");
        }
        defensa += defensaExtra;
        if(defensa > 100) defensa = 100;
        System.out.println("La defensa de " + nombre + " aumentó a " + defensa);
    }

    public void curar(){
        System.out.println(nombre + " se está curando");
        int curacionBase = 15;
        if(modoFuria) {
            curacionBase += 10;
            System.out.println("El modo furia aumenta la curación");
        }
        vida += curacionBase;
        if(vida > 100) vida = 100;
        System.out.println(nombre + " se ha curado. Vida actual: " + vida);
    }
}