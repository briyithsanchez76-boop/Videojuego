package co.edu.uniquindio.poo.model;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Batalla{
    
private String id;
private int turno;
private List<Equipo> listaEquipos;
private UniVS ownedByUniVS;
private List<Jugador> listaJugadores;

public Batalla(int turno, List<Equipo> listaEquipos, UniVS ownedByUniVS, List<Jugador> listaJugadores) {
    if(turno<0){
       throw new IllegalArgumentException("los datos no pueden ser negativos");
    }
    this.id = "B" + System.currentTimeMillis();
    this.turno = turno;
    this.listaEquipos = listaEquipos != null ? listaEquipos : new LinkedList<>();
    this.ownedByUniVS = ownedByUniVS;
    this.listaJugadores = listaJugadores != null ? listaJugadores : new LinkedList<>();
}

public int getTurno() {
    return turno;
}

public void setTurno(int turno) {
    this.turno = turno;
}

public List<Equipo> getListaEquipos() {
    return listaEquipos;
}

public void setListaEquipos(List<Equipo> listaEquipos) {
    this.listaEquipos = listaEquipos;
}

public UniVS getOwnedByUniVS() {
    return ownedByUniVS;
}

public void setOwnedByUniVS(UniVS ownedByUniVS) {
    this.ownedByUniVS = ownedByUniVS;
}

public List<Jugador> getListaJugadores() {
    return listaJugadores;
}

public void setListaJugadores(List<Jugador> listaJugadores) {
    this.listaJugadores = listaJugadores;
}

    @Override
    public String toString() {
        return "Batalla #" + id + " (Turno " + turno + ")";
    }

    public String getId() {
        return id;
    }public void resultadoBatalla(){
    System.out.println("¡La batalla ha terminado!");
    List<Equipo> equiposVivos = listaEquipos.stream()
        .filter(e -> e.tieneJugadoresVivos())
        .collect(Collectors.toList());

    String resultado;
    if(equiposVivos.isEmpty()) {
        resultado = "Todos los equipos fueron eliminados. ¡Empate!";
    } else if(equiposVivos.size() == 1) {
        Equipo equipoGanador = equiposVivos.get(0);
        resultado = "¡El equipo ganador es: " + equipoGanador.getNombre() + "!";
        if(ownedByUniVS != null) {
            // Actualizar puntajes en UniVS
            Equipo perdedor = listaEquipos.stream()
                .filter(e -> !equiposVivos.contains(e))
                .findFirst()
                .orElse(null);
            if(perdedor != null) {
                ownedByUniVS.getListaPuntajes().add(
                    new Puntaje(equipoGanador.getNombre(), perdedor.getNombre(), "1-0")
                );
            }
        }
    } else {
        resultado = "¡Ambos equipos tienen jugadores vivos! ¡Empate!";
    }
    System.out.println(resultado);
}


}