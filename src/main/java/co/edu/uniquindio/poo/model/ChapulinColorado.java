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
    public String toString() {
        return super.toString();
    }

    public void atacar(Jugador enemigo) {
        System.out.println("¡No contaban con mi astucia!");
        // El Chapulín usa su chipote chillón
        int dañoBase = this.daño;
        // Bonus de daño por sus antenitas de vinil
        int dañoExtra = 5;
        int dañoTotal = dañoBase + dañoExtra - enemigo.getDefensa();
        
        if (dañoTotal < 0) {
            dañoTotal = 0;
        }
        
        enemigo.recibirDaño(dañoTotal);
        System.out.println(nombre + " golpeó con su Chipote Chillón a " + enemigo.getNombre() + " causando " + dañoTotal + " de daño");
    }

    public void defender() {
        System.out.println("Síganme los buenos");
        // El Chapulín usa sus habilidades para defenderse
        int defensaExtra = 8;
        this.defensa += defensaExtra;
        
        if (this.defensa > 100) {
            this.defensa = 100;
        }
        
        System.out.println(nombre + " usó sus Antenitas de Vinil para detectar el peligro");
        System.out.println("La defensa de " + nombre + " aumentó a " + this.defensa);
    }

    public void curar() {
        System.out.println("Todos mis movimientos están fríamente calculados");
        // El Chapulín usa sus pastillas de chiquitolina para recuperarse
        int curacion = 15;
        this.vida += curacion;
        
        if (this.vida > 100) {
            this.vida = 100;
        }
        
        System.out.println(nombre + " tomó una pastilla de chiquitolina para recuperarse");
        System.out.println("La vida de " + nombre + " aumentó a " + this.vida);
    }
}