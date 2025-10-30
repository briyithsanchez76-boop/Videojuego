package co.edu.uniquindio.poo.model;

public class Puntaje{

    private String equipo1;
    private String equipo2;
    private String resultado;
    private UniVS ownedByUniVS;

    public Puntaje(String equipo1, String equipo2, String resultado) {
        if(equipo1 == null || equipo1.isBlank() || 
           equipo2 == null || equipo2.isBlank() || 
           resultado == null || resultado.isBlank()){
            throw new IllegalArgumentException("Los datos son inválidos");
        }
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.resultado = resultado;
    }

    public UniVS getOwnedByUniVS() {
        return ownedByUniVS;
    }

    public void setOwnedByUniVS(UniVS ownedByUniVS) {
        this.ownedByUniVS = ownedByUniVS;
    }

    @Override
    public String toString() {
        return equipo1 + " vs " + equipo2 + ": " + resultado;
    }
    
    public void mostrarPuntaje() {
        System.out.println("=== Resultado de Batalla ===");
        System.out.println(equipo1 + " vs " + equipo2);
        System.out.println("Resultado: " + resultado);
        System.out.println("========================");
    }

    public String getEquipo1() {
        return equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public String getResultado() {
        return resultado;
    }
}