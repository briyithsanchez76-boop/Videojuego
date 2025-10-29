package co.edu.uniquindio.poo.model;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


public class UniVS {

    private List<Puntaje> listaPuntajes;
    private List<Batalla> listaBatallas;
    private List<Jugador> listaJugadores;
    private List<Equipo> listaEquipos;
    private List<Dado> listaDados;

        public UniVS( List<Puntaje> listaPuntajes, List<Batalla> listaBatallas, List<Jugador> listaJugadores, List<Equipo> listaEquipos, List<Dado> listaDados) {
            this.listaPuntajes = listaPuntajes;
            this.listaBatallas = listaBatallas;
            this.listaJugadores = listaJugadores;
            this.listaEquipos = listaEquipos;
            this.listaDados = listaDados;
        }
    
     public List<Puntaje> getListaPuntajes() {
            return listaPuntajes;
        }

        public void setListaPuntajes(List<Puntaje> listaPuntajes) {
            this.listaPuntajes = listaPuntajes;
        }

        public List<Batalla> getListaBatallas() {
            return listaBatallas;
        }

        public void setListaBatallas(List<Batalla> listaBatallas) {
            this.listaBatallas = listaBatallas;
        }

        public List<Jugador> getListaJugadores() {
            return listaJugadores;
        }

        public void setListaJugadores(List<Jugador> listaJugadores) {
            this.listaJugadores = listaJugadores;
        }

        public List<Equipo> getListaEquipos() {
            return listaEquipos;
        }

        public void setListaEquipos(List<Equipo> listaEquipos) {
            this.listaEquipos = listaEquipos;
        }

        public List<Dado> getListaDados() {
            return listaDados;
        }

        public void setListaDados(List<Dado> listaDados) {
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
