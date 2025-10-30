package co.edu.uniquindio.poo.model;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.LinkedList;


public class UniVS {

    private LinkedList<Puntaje> listaPuntajes;
    private LinkedList<Batalla> listaBatallas;
    private LinkedList<Jugador> listaJugadores;
    private LinkedList<Equipo> listaEquipos;
    private Dado dado;

    public UniVS(Dado dado) {
        this.listaPuntajes = new LinkedList<>();
        this.listaBatallas = new LinkedList<>();
        this.listaJugadores = new LinkedList<>();
        this.listaEquipos = new LinkedList<>();
        this.dado = dado;
    }

    public LinkedList<Puntaje> getListaPuntajes() {
        return listaPuntajes;
    }

    public void setListaPuntajes(LinkedList<Puntaje> listaPuntajes) {
        this.listaPuntajes = listaPuntajes;
    }

    public LinkedList<Batalla> getListaBatallas() {
        return listaBatallas;
    }

    public void setListaBatallas(LinkedList<Batalla> listaBatallas) {
        this.listaBatallas = listaBatallas;
    }

    public LinkedList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(LinkedList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public LinkedList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(LinkedList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public Dado getDado() {
        return dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
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

     /**
      * metodo para crear una batalla en UniVS
      */

      public String crearBatalla(Batalla nuevaBatalla){
        String mensaje=" ";
        Optional <Batalla> batallaExistente=buscarBatalla(nuevaBatalla.getId());
        if(batallaExistente.isPresent()){
            mensaje="batalla con id" + nuevaBatalla.getId() +"ya existe";
        }else{
        listaBatallas.add(nuevaBatalla);
        mensaje="batalla con id" + nuevaBatalla.getId() + "ha iniciado exitosamente";
    }
        return mensaje;
      }

        /**
         * metodo para buscar una batalla en UniVS
         */
    
         public Optional<Batalla> buscarBatalla(String id){
            return listaBatallas.stream().filter(batalla -> batalla.getId().equals(id)).findFirst();
         }


         /**
          * metodo para crear el dado en UniVS
          */
         public String crearDado(){
            String mensaje=" ";
            if(dado==null){
                dado=new Dado();
                mensaje="Dado creado exitosamente";
            }else{
                mensaje="Ya existe un dado en UniVS";
            }
            return mensaje;
         }


    //metodo para iniciar una batalla
    public String iniciarBatalla(String idBatalla){

        String mensaje=" ";
        batalla.crearBatalla(idBatalla);
        LinkedList<Equipo> equiposBatalla = batalla.getEquipos();
        if (equiposBatalla == null || equiposBatalla.size() < 2) {
            String mensaje = "La batalla debe tener al menos 2 equipos para iniciarse.";
            System.out.println(mensaje);
            return mensaje;
        }

        Equipo atacante = equiposBatalla.get(0);
        Equipo defensor = equiposBatalla.get(1);

        List<String> salida = new java.util.ArrayList<>();

        String line = "Batalla con id: " + idBatalla + " iniciada.";
        System.out.println(line);
        salida.add(line);

        line = "Atacará el equipo: " + atacante.getNombre();
        System.out.println(line);
        salida.add(line);

        line = "Defenderá el equipo: " + defensor.getNombre();
        System.out.println(line);
        salida.add(line);

        // Lanzamiento de dados por el equipo atacante
        dado.crearDado();
        int valorDado = 0;
        valorDado = dado.lanzarDado();
        line = "El equipo " + atacante.getNombre() + " lanza los dados y obtiene: " + valorDado;
        System.out.println(line);
        salida.add(line);

        // Cada jugador atacante realiza un ataque sobre un jugador vivo del equipo defensor
        for (Jugador jugadorAtacante : atacante.getJugadores()) {
            // listar objetivos vivos del defensor
            List<Jugador> objetivosVivos = defensor.getJugadores().stream()
                .filter(j -> j.getVida() > 0)
                .collect(Collectors.toList());

            if (objetivosVivos.isEmpty()) {
                line = "Todos los jugadores del equipo " + defensor.getNombre() + " están fuera de combate.";
                System.out.println(line);
                salida.add(line);
                break;
            }

            // elegir objetivo aleatorio entre los vivos
            int idx = (int)(Math.random() * objetivosVivos.size());
            Jugador objetivo = objetivosVivos.get(idx);

            // calcular daño: aquí usamos el valor del dado (ajusta si quieres usar ataque del jugador)
            int danio = jugadorAtacante.atacar();

            // actualizar vida del objetivo
            int vidaAntes = objetivo.getVida();
            int vidaDespues = Math.max(0, vidaAntes - danio);
            objetivo.setVida(vidaDespues);

            line = "Jugador " + jugadorAtacante.getNombre()
                   + " ataca a " + objetivo.getNombre()
                   + " causando " + danio + " puntos. Vida: " + vidaAntes + " -> " + vidaDespues;
            System.out.println(line);
            salida.add(line);
        }


        line = "Estado final de los jugadores del equipo " + defensor.getNombre() + ":";
        System.out.println(line);
        salida.add(line);
        for (Jugador j : defensor.getJugadores()) {
            line = "- " + j.getNombre() + ": vida=" + j.getVida();
            System.out.println(line);
            salida.add(line);
        }

        return String.join("\n", salida);
    }

    /**
     * Define el puntaje final entre dos equipos.
     * Si gana equipo1 devuelve "1-0", si gana equipo2 devuelve "0-1".
     */
    
    public String definirPuntajeFinal(Equipo equipo1, Equipo equipo2) {
        if (equipo1 == null || equipo2 == null) {
            String mensaje = "Equipos inválidos para definir puntaje.";
            System.out.println(mensaje);
            return mensaje;
        }

        long vivos1 = equipo1.getJugadores().stream().filter(j -> j.getVida() > 0).count();
        long vivos2 = equipo2.getJugadores().stream().filter(j -> j.getVida() > 0).count();

        String resultado;
        if (vivos1 > 0 && vivos1 > vivos2) {
            resultado = "1-0";
        } else if (vivos2 > 0 && vivos2 > vivos1) {
            resultado = "0-1";
        }

        System.out.println("Puntaje final: " + resultado);
        listaPuntajes.add(new Puntaje(equipo1.getNombre(), equipo2.getNombre(), resultado));
        return resultado;
    }

    public String ganadorBatalla(String idBatalla){
        String mensaje=" ";
        String puntaje = definirPuntajeFinal(atacante, defensor);
        if(puntaje.equals("1-0")){
            mensaje="El equipo " + atacante.getNombre() + " ha ganado la batalla.";
        }else if(puntaje.equals("0-1")){
            mensaje="El equipo " + defensor.getNombre() + " ha ganado la batalla.";
        }
        return mensaje;
    }

    public String infoPersonajes(){
        if (listaJugadores == null || listaJugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
            return "";
        }

        for (Jugador jugador : listaJugadores) {
            System.out.println(
                "ID: " + jugador.getId()
                + ", Nombre: " + jugador.getNombre()
                + ", Vida: " + jugador.getVida()
                + ", Ataque: " + jugador.getAtaque()
            );
        }
        return "";
    }
}