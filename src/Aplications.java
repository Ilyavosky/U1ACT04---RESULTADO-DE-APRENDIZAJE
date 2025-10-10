import models.Leccion;
import models.Post;
import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Scanner;

public class Aplications {
    private Leccion[] catalogo;
    private Post[] posts;
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

        this.posts = new Post[]{
                new Post("¿Cómo mejorar velocidad?", "Necesito tips para tocar más rápido", "Técnica", 101, 25),
                new Post("Recomendaciones de guitarras", "¿Qué guitarra comprar?", "Equipo", 102, 40),
                new Post("Mi progreso después de 6 meses", "¡Ya toco mi primera canción!", "Logros", 103, 65),
                new Post("Dolor en los dedos", "¿Es normal que duelan?", "Salud", 104, 18),
                new Post("Teoría musical necesaria", "¿Debo aprender teoría?", "Teoría", 105, 30),
                new Post("Ejercicios de cejilla", "Rutina para mejorar cejilla", "Técnica", 106, 22),
                new Post("Mejor método para acordes", "Tips para aprender acordes", "Acordes", 107, 35)
        };
    }

    public void iniciar() {
        int eleccion = -1;

        do {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            eleccion = sc.nextInt();
            sc.nextLine();

            switch (eleccion) {
                case 1:
                    System.out.println("\nCatálogo Completo de Lecciones:");
                    System.out.println(Arrays.toString(catalogo));
                    break;
                case 2:
                    filtrarLeccionesPorNivel();
                    break;
                case 3:
                    System.out.println("\nOrdenando Catálogo de Lecciones por Título:");
                    ArrayUtils.sort(catalogo);
                    System.out.println(Arrays.toString(catalogo));
                    break;
                case 4:
                    buscarLeccionPorId();
                    break;
                case 5:
                    buscarLeccionPorClasificacion();
                    break;
                case 6:
                    buscarLeccionPorTexto();
                    break;
                case 7:
                    System.out.println("\nCatálogo Completo de Posts:");
                    System.out.println(Arrays.toString(posts));
                    break;
                case 8:
                    filtrarPostsPorCategoria();
                    break;
                case 9:
                    System.out.println("\nOrdenando Posts por Título:");
                    ArrayUtils.sort(posts);
                    System.out.println(Arrays.toString(posts));
                    break;
                case 10:
                    buscarPostPorId();
                    break;
                case 11:
                    buscarPostPorTexto();
                    break;
                case 0:
                    System.out.println("\n¡Esperamos que regreses a aprender pronto!");
                    break;
                default:
                    System.out.println("\nOpción no válida. Inténtalo de nuevo.");
                    break;
            }
            System.out.println("\n--------------------------------------------");

        } while (eleccion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n===== MENÚ DE GUITARSHARE =====");
        System.out.println("--- LECCIONES ---");
        System.out.println("1: Ver catálogo completo de Lecciones");
        System.out.println("2: Filtrar lecciones por Nivel");
        System.out.println("3: Ordenar lecciones por Título");
        System.out.println("4: Buscar lección por ID");
        System.out.println("5: Buscar lección por Clasificación (P, I, A)");
        System.out.println("6: Buscar lección por texto (interfaz Filtrable)");
        System.out.println("\n--- POSTS DEL FORO ---");
        System.out.println("7: Ver catálogo completo de Posts");
        System.out.println("8: Filtrar posts por Categoría");
        System.out.println("9: Ordenar posts por Título");
        System.out.println("10: Buscar post por ID");
        System.out.println("11: Buscar post por texto (interfaz Filtrable)");
        System.out.println("\n0: Salir");
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

    private void buscarLeccionPorId() {
        System.out.print("Escribe el ID de la lección a buscar: ");
        Integer idBuscado = sc.nextInt();
        sc.nextLine();

        Leccion leccionEncontrada = ArrayUtils.findFirst(catalogo, leccion -> leccion.getId().equals(idBuscado));

        System.out.println("\nResultado de la Búsqueda por ID");
        if (leccionEncontrada != null) {
            System.out.println("Lección encontrada: " + leccionEncontrada);
        } else {
            System.out.println("No se encontró ninguna lección con el ID " + idBuscado + ".");
        }
    }

    private void buscarLeccionPorClasificacion() {
        System.out.print("Escribe la clasificación a buscar (P, I, A): ");
        char clasificacionBuscada = sc.nextLine().toUpperCase().charAt(0);

        Leccion leccionEncontrada = ArrayUtils.findFirst(catalogo, leccion -> leccion.getClasificacion().equals(clasificacionBuscada));

        System.out.println("\nResultado de la Búsqueda por Clasificación");
        if (leccionEncontrada != null) {
            System.out.println("Primera lección encontrada: " + leccionEncontrada);
        } else {
            System.out.println("No se encontró ninguna lección con la clasificación '" + clasificacionBuscada + "'.");
        }
    }

    private void buscarLeccionPorTexto() {
        System.out.print("Escribe el texto a buscar en lecciones: ");
        String textoBuscado = sc.nextLine();

        Leccion[] leccionesEncontradas = ArrayUtils.filtrarPorCriterio(catalogo, textoBuscado);

        System.out.println("\nResultado de la Búsqueda por Texto (interfaz Filtrable)");
        if (leccionesEncontradas.length > 0) {
            System.out.println(Arrays.toString(leccionesEncontradas));
        } else {
            System.out.println("No se encontraron lecciones que contengan '" + textoBuscado + "'.");
        }
    }

    private void filtrarPostsPorCategoria() {
        System.out.print("Escribe la categoría a filtrar (Técnica, Teoría, Equipo, etc.): ");
        String categoriaBuscada = sc.nextLine();

        Post[] postsFiltrados = ArrayUtils.filter(posts, post -> post.getCategoria().equalsIgnoreCase(categoriaBuscada));

        System.out.println("\nResultado del Filtro");
        if (postsFiltrados.length > 0) {
            System.out.println(Arrays.toString(postsFiltrados));
        } else {
            System.out.println("No se encontraron posts para la categoría '" + categoriaBuscada + "'.");
        }
    }

    private void buscarPostPorId() {
        System.out.print("Escribe el ID del post a buscar: ");
        Integer idBuscado = sc.nextInt();
        sc.nextLine();

        Post postEncontrado = ArrayUtils.findFirst(posts, post -> post.getId().equals(idBuscado));

        System.out.println("\nResultado de la Búsqueda por ID");
        if (postEncontrado != null) {
            System.out.println("Post encontrado: " + postEncontrado);
        } else {
            System.out.println("No se encontró ningún post con el ID " + idBuscado + ".");
        }
    }

    private void buscarPostPorTexto() {
        System.out.print("Escribe el texto a buscar en posts: ");
        String textoBuscado = sc.nextLine();

        Post[] postsEncontrados = ArrayUtils.filtrarPorCriterio(posts, textoBuscado);

        System.out.println("\nResultado de la Búsqueda por Texto (interfaz Filtrable)");
        if (postsEncontrados.length > 0) {
            System.out.println(Arrays.toString(postsEncontrados));
        } else {
            System.out.println("No se encontraron posts que contengan '" + textoBuscado + "'.");
        }
    }
}