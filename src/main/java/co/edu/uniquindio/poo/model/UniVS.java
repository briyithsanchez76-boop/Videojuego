package co.edu.uniquindio.poo.model;

public class UniVS {

    private Puntaje listaPuntajes;
    private Batalla listaBatallas;
    private Jugador listaJugadores;
    private Equipo listaEquipos;
    private Dado listaDados;

    public UniVS(Puntaje listaPuntajes, Batalla listaBatallas, Jugador listaJugadores, Equipo listaEquipos,
            Dado listaDados) {
        this.listaPuntajes = listaPuntajes;
        this.listaBatallas = listaBatallas;
        this.listaJugadores = listaJugadores;
        this.listaEquipos = listaEquipos;
        this.listaDados = listaDados;
    }

    public Puntaje getListaPuntajes() {
        return listaPuntajes;
    }

    public void setListaPuntajes(Puntaje listaPuntajes) {
        this.listaPuntajes = listaPuntajes;
    }

    public Batalla getListaBatallas() {
        return listaBatallas;
    }

    public void setListaBatallas(Batalla listaBatallas) {
        this.listaBatallas = listaBatallas;
    }

    public Jugador getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(Jugador listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public Equipo getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(Equipo listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public Dado getListaDados() {
        return listaDados;
    }

    public void setListaDados(Dado listaDados) {
        this.listaDados = listaDados;
    }

}
