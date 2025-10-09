import models.Leccion;
import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Scanner;

public class Aplications {
    private Leccion[] catalogo;
    private Scanner sc;

    public Aplications() {
        this.sc = new Scanner(System.in);
        this.catalogo = new Leccion[]{
                new Leccion("Circulo de SOL", "Teoría", "Principiante", 1, 'P'),
                new Leccion("Acordes Abiertos Mayores", "Acordes", "Principiante", 2, 'P'),
                new Leccion("Escala de Blues", "Escalas", "Intermedio", 3, 'I'),
                new Leccion("Acordes con Cejilla", "Acordes", "Intermedio", 4, 'I'),
                new Leccion("Alternate Picking 101", "Técnica", "Intermedio", 5, 'I'),
                new Leccion("Circulo de DO", "Teoría", "Principiante", 6, 'P'),
                new Leccion("Power Chords", "Técnica", "Intermedio", 7, 'I'),
                new Leccion("Sweep Picking", "Técnica", "Avanzado", 8, 'A'),
                new Leccion("Modos Griegos", "Teoría", "Avanzado", 9, 'A'),
                new Leccion("Tapping a dos manos", "Técnica", "Avanzado", 10, 'A'),
                new Leccion("Arpegios de Séptima", "Acordes", "Avanzado", 11, 'A')
        };
    }

    public void iniciar() {
        int eleccion = -1;

        do {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            eleccion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer del scanner

            switch (eleccion) {
                case 1:
                    System.out.println("\nCatálogo Completo:");
                    System.out.println(Arrays.toString(catalogo));
                    break;
                case 2:
                    filtrarLeccionesPorNivel();
                    break;
                case 3:
                    System.out.println("\nOrdenando Catálogo por Título:");
                    ArrayUtils.sort(catalogo);
                    System.out.println(Arrays.toString(catalogo));
                    break;
                case 4:
                    buscarLeccionPorId(); // Nueva opción
                    break;
                case 5:
                    buscarLeccionPorClasificacion(); // Nueva opción
                    break;
                case 0:
                    System.out.println("\n!Esperamos que regreses a aprender pronto¡");
                    break;
                default:
                    System.out.println("\nOpción no válida. Inténtalo de nuevo.");
                    break;
            }
            System.out.println("\n--------------------------------------------");

        } while (eleccion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\nMENÚ DE LECCIONES DE GUITARSHARE ");
        System.out.println("1: Ver el catálogo completo de las Lecciones");
        System.out.println("2: Filtrar lecciones por Nivel");
        System.out.println("3: Ordenar el catálogo por Título");
        System.out.println("4: Buscar lección por ID (11)");
        System.out.println("5: Buscar lección por Clasificación (P, I, A)");
        System.out.println("0: Salir");
    }

    private void filtrarLeccionesPorNivel() {
        System.out.print("Escribe el nivel a filtrar (Principiante, Intermedio, Avanzado): ");
        String nivelBuscado = sc.nextLine();

        Leccion[] leccionesFiltradas = ArrayUtils.filter(catalogo, leccion -> leccion.getNivel().equalsIgnoreCase(nivelBuscado));

        System.out.println("\nResultado del Filtro");
        if (leccionesFiltradas.length > 0) {
            System.out.println(Arrays.toString(leccionesFiltradas));
        } else {
            System.out.println("No se encontraron lecciones para el nivel '" + nivelBuscado + "'.");
        }
    }

    // --- NUEVO MÉTODO PARA BUSCAR POR ID ---
    private void buscarLeccionPorId() {
        System.out.print("Escribe el ID de la lección a buscar: ");
        Integer idBuscado = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        // Reutilizamos findFirst con una nueva condición (lambda)
        Leccion leccionEncontrada = ArrayUtils.findFirst(catalogo, leccion -> leccion.getId().equals(idBuscado));

        System.out.println("\nResultado de la Búsqueda por ID");
        if (leccionEncontrada != null) {
            System.out.println("Lección encontrada: " + leccionEncontrada);
        } else {
            System.out.println("No se encontró ninguna lección con el ID " + idBuscado + ".");
        }
    }

    // --- NUEVO MÉTODO PARA BUSCAR POR CLASIFICACIÓN ---
    private void buscarLeccionPorClasificacion() {
        System.out.print("Escribe la clasificación a buscar (P, I, A): ");
        char clasificacionBuscada = sc.nextLine().toUpperCase().charAt(0);

        // Reutilizamos findFirst de nuevo, ahora para buscar por Character
        Leccion leccionEncontrada = ArrayUtils.findFirst(catalogo, leccion -> leccion.getClasificacion().equals(clasificacionBuscada));

        System.out.println("\nResultado de la Búsqueda por Clasificación");
        if (leccionEncontrada != null) {
            System.out.println("Primera lección encontrada: " + leccionEncontrada);
        } else {
            System.out.println("No se encontró ninguna lección con la clasificación '" + clasificacionBuscada + "'.");
        }
    }
}