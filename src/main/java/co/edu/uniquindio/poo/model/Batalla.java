package co.edu.uniquindio.poo.model;
import java.util.List;

public class Batalla{
    
private int turno;
private List<Equipo> listaEquipos;
private UniVS ownedByUniVS;
private List<Jugador> listaJugadores;

public Batalla(int turno, List<Equipo> listaEquipos, UniVS ownedByUniVS, List<Jugador> listaJugadores) {
    if(turno<0){
       throw new illegalArgumentException("los datos no pueden ser negativos");
    }
    this.turno = turno;
    this.listaEquipos = listaEquipos;
    this.ownedByUniVS = ownedByUniVS;
    this.listaJugadores = listaJugadores;
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
    return "Batalla turno:" + turno ;
}

public void resultadoBatalla(){
    System.out.println(" la batalla ha terminado" );
    Equipo ganador=null;
    int equiposVivos=0;
     
    for (Equipo e:listaEquipos){
        if(e.tieneJugadoresVivos()){
            equiposVivos++;
            ganador=e;
        }
    }
    if(equiposVivos==0){
        System.out.println("Todos los equipos fueron eliminados. Empate");
    }else if(equiposVivos==1){
        System.out.println("El equipo ganador es: " + ganador.getNombre() );
    }else{
        System.out.println(" En los dos equipos existe jugadores vivos. Empate");
    }
}


}