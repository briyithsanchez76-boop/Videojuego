package co.edu.uniquindio.poo.model;

public class Dado {
    private int caras;
    private int valorDado;

    public Dado() {
        this.caras = 6;
        this.valorDado = lanzarDado();
    }

    public Dado(int caras) {
        if (caras <= 0) {
            throw new IllegalArgumentException("El número de caras debe ser mayor que cero");
        }
        this.caras = caras;
        this.valorDado = lanzarDado();
    }

    public int getCaras() {
        return caras;
    }

    public void setCaras(int caras) {
        if ( caras <= 0) {
            throw new IllegalArgumentException ( "el valor del dado no puede ser menor o igual a cero" );
        }
        this.caras = caras;
    }

    public int getValorDado() {
        return valorDado;
    }

    public void setValorDado(int valorDado) {
        if (valorDado <= 0 || valorDado > caras) {
            throw new IllegalArgumentException("El valor del dado debe estar entre 1 y " + caras);
        }
        this.valorDado = valorDado;
    }

    public int lanzarDado() {
        valorDado = (int) (Math.random() * caras) + 1;
        return valorDado;
    }
}
