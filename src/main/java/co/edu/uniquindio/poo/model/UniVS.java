package co.edu.uniquindio.poo.model;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


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

    
     /**
     * metodo para agregar un jugador a UniVS
     */

     public String agregarJugador(Jugador nuevoJugador){
        String mensaje=" ";
        Optional <Jugador> jugadorExistente=buscarJugador(nuevoJugador.getId());
        if(jugadorExistente.isPresent()){
            mensaje="jugador con id" + nuevoJugador.getId() +"ya existe";

     }else{
        listaJugadores.add(nuevoJugador);
        mensaje="jugador con id" + nuevoJugador.getId()+ "fue agregado exitosamente";
     }
        return mensaje;
        }

    /**
     * metodo para buscar un jugador en UniVS
     */

     public Optional buscarJugador(String id){
        return listaJugadores.stream().filter(jugador -> Jugador.getId().equals(id)).findFirst();
     }

    /**
     * metodo para eliminar un jugador en UniVS
     */

     public String eliminarJugador(String id){
        String mensaje=" ";
        Optional<Jugador> jugadorExistente=buscarJugador(id);
        if(jugadorExistente.isPresent()){
            listaJugadores.remove(jugadorExistente.get());
            mensaje="Client with id:" + id + "was removed successfully";
        }else{
            mensaje="Client with id:" + id + "doesn't exist";
        }
        return mensaje;
     }

}
