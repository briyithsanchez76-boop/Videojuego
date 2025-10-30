package co.edu.uniquindio.poo.app;
import java.util.List;
import co.edu.uniquindio.poo.model.*;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static UniVS juego;

    public static void main(String[] args) {
        System.out.println("¡Bienvenido a UniVS!");
        inicializarJuego();
        menuPrincipal();
    }

    private static void inicializarJuego() {
        System.out.println("=== Inicializando UniVS ===");
        
        Dado dado = new Dado(6);
        juego = new UniVS(dado);
        
        // Crear equipos
        Equipo equipo1 = new Equipo("Héroes", 0, juego, null);
        Equipo equipo2 = new Equipo("Villanos", 0, juego, null);
        
        // Crear jugadores
        LinkedList<Puntaje> puntajes = new LinkedList<>();
        
        try {
            Kratos kratos = new Kratos("Kratos", "K1", 100, juego, equipo1, null, puntajes, dado, "Medusa", false);
            HarryPotter harry = new HarryPotter("Harry Potter", "H1", 100, juego, equipo1, null, puntajes, dado, "Varita de Fénix");
            ChapulinColorado chapulin = new ChapulinColorado("Chapulín Colorado", "C1", 100, juego, equipo2, null, puntajes, dado, "Antenas Rojas");
            Abuela abuela = new Abuela("Doña Florinda", "A1", 100, juego, equipo2, null, puntajes, dado, "Lentes de Oro");
            
            // Agregar jugadores a equipos
            equipo1.getListaJugadores().add(kratos);
            equipo1.getListaJugadores().add(harry);
            equipo2.getListaJugadores().add(chapulin);
            equipo2.getListaJugadores().add(abuela);
            
            // Agregar equipos al juego
            juego.getListaEquipos().add(equipo1);
            juego.getListaEquipos().add(equipo2);
            
            System.out.println("¡Juego inicializado con éxito!");
            System.out.println("Equipo 1: " + equipo1.getNombre() + " (" + equipo1.getListaJugadores().size() + " jugadores)");
            System.out.println("Equipo 2: " + equipo2.getNombre() + " (" + equipo2.getListaJugadores().size() + " jugadores)");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear personajes: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void menuPrincipal() {
        while (true) {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Ver personajes");
            System.out.println("2. Iniciar batalla");
            System.out.println("3. Ver puntajes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                int opcion = Integer.parseInt(scanner.nextLine().trim());
                
                switch (opcion) {
                    case 1:
                        juego.infoPersonajes();
                        break;
                    case 2:
                        iniciarBatalla();
                        break;
                    case 3:
                        mostrarPuntajes();
                        break;
                    case 4:
                        System.out.println("¡Gracias por jugar!");
                        return;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione un número entre 1 y 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }

    private static void iniciarBatalla() {
        System.out.println("\n=== Nueva Batalla ===");
        
        List<Equipo> equipos = juego.getListaEquipos();
        if (equipos.size() < 2) {
            System.out.println("Error: No hay suficientes equipos para iniciar una batalla.");
            return;
        }

        // Verificar que ambos equipos tengan jugadores vivos
        Equipo equipo1 = equipos.get(0);
        Equipo equipo2 = equipos.get(1);
        
        if (!equipo1.tieneJugadoresVivos() || !equipo2.tieneJugadoresVivos()) {
            System.out.println("Error: Ambos equipos deben tener jugadores vivos para iniciar una batalla.");
            return;
        }

        Batalla batalla = new Batalla(1, equipos, juego, null);
        String resultado = juego.crearBatalla(batalla);
        System.out.println(resultado);
        
        if (resultado.contains("exitosamente")) {
            System.out.println("\n¡Que comience la batalla!");
            System.out.println(juego.iniciarBatalla(batalla.getId()));
            
            System.out.println("\nResultado final:");
            batalla.resultadoBatalla();
            System.out.println(juego.ganadorBatalla(batalla.getId()));
        }
    }

    private static void mostrarPuntajes() {
        System.out.println("\n=== Historial de Batallas ===");
        List<Puntaje> puntajes = juego.getListaPuntajes();
        
        if (puntajes.isEmpty()) {
            System.out.println("No hay batallas registradas todavía.");
            return;
        }
        
        for (Puntaje puntaje : puntajes) {
            puntaje.mostrarPuntaje();
        }
    }
}
