package co.edu.uniquindio.poo.model;
import java.util.List;

public class Kratos extends Jugador {

    private String cabezaMedusa;
    private boolean modoFuria;
    private int daño=60;
    private int defensa=70;

    public Kratos(String nombre, string id ,int vida, UniVS ownedByUniVS, Equipo equipo, Batalla batalla, List<Puntaje> puntaje, Dado dado, String cabezaMedusa, boolean modoFuria) {
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

    public void defender(){
        System.out.println(nombre + " levantó su espada para defenderse del ataque ");
        defensa+=15;

        if(defensa>120){
            defensa=120;
        }

        System.out.println("la defensa de " + nombre + " ahora es " + defensa);

    }

     public void curar (int cantidad){
        int curacion= cantidad;
        if(modoFuria){
            curacion+=10;
            System.out.print(nombre + " está en modo furia para sanar más rápido ");
        }
        vida+=curacion;
        if (vida> 100){
            vida=100;
        }
        System.out.println(nombre + " Kratos se curó y ahora tiene " + vida + " de vida");
    }

    public void activarFuria(){
        if(!modoFuria){
            modoFuria=true;
            daño+=20;
            defensa+=10;
            System.out.println(nombre + " Kratos está en modo furia su ataque y defensa aumentarán temporalmente");
        }
    }

    
}

