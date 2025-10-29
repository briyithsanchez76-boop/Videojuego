package co.edu.uniquindio.poo.model;

public class Dado {
    private int caras;
    private int valorDado;

    public Dado() {
        if (valorDado<=0) {
            throw new IllegalArgumentException("El valor del dado debe ser mayor que cero");
        }
        
        this.caras = 6;
        this.valorDado = lanzarDado();
    }

    public int getCaras() {
        return caras;
    }

    public void setCaras(int caras) {
        this.caras = caras;
    }

    public int getValorDado() {
        return valorDado;
    }

    public void setValorDado(int valorDado) {
        this.valorDado = valorDado;
    }

    public int lanzarDado() {
        return (int) (Math.random() * caras) + 1;
    }

}
