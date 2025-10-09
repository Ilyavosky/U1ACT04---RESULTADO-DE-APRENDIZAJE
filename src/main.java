import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Leccion[] catalogo = new Leccion[]{
                new Leccion("Circulo de SOL", "Teoría", "Principiante"),
                new Leccion("Acordes Abiertos Mayores", "Acordes", "Principiante"),
                new Leccion("Escala de Blues", "Escalas", "Intermedio"),
                new Leccion("Acordes con Cejilla", "Acordes", "Intermedio"),
                new Leccion("Alternate Picking 101", "Técnica", "Intermedio"),
                new Leccion("Circulo de DO", "Teoría", "Principiante"),
                new Leccion("Power Chords", "Técnica", "Intermedio"),
                new Leccion("Sweep Picking", "Técnica", "Avanzado"),
                new Leccion("Modos Griegos", "Teoría", "Avanzado"),
                new Leccion("Tapping a dos manos", "Técnica", "Avanzado"),
                new Leccion("Arpegios de Séptima", "Acordes", "Avanzado")
        };

        System.out.println("Catalogo de Lecciones disponibles");
        System.out.println(Arrays.toString(catalogo));

        System.out.println("\n--------------------------------------------");

        System.out.println("\nLecciones filtradas en la categoría de principiantes");
        Leccion[] LeccionesPrincipiante = ArrayUtils.filter(catalogo, leccion -> leccion.getNivel().equals("Principiante"));
        System.out.println(Arrays.toString(LeccionesPrincipiante));

        System.out.println("\n--------------------------------------------");

        System.out.println("\nLecciones filtradas en la categoría de Intermedios");
        Leccion[] LeccionesIntermedio = ArrayUtils.filter(catalogo, leccion -> leccion.getNivel().equals("Intermedio"));
        System.out.println(Arrays.toString(LeccionesIntermedio));

        System.out.println("\n--------------------------------------------");

        System.out.println("\nLecciones filtradas en la categoría de Avanzados");
        Leccion[] LeccionesAvanzado = ArrayUtils.filter(catalogo, leccion -> leccion.getNivel().equals("Avanzado"));
        System.out.println(Arrays.toString(LeccionesAvanzado));

        System.out.println("\n--------------------------------------------");

        System.out.println("\n Primera lección de teoría");

        Leccion primeraDeTeoria = ArrayUtils.findFirst(catalogo, leccion -> leccion.getTema().equals("Teoría"));

        if (primeraDeTeoria != null) {
            System.out.println("Encontrada: " + primeraDeTeoria);
        } else {
            System.out.println("No se encontró ninguna lección de ese tema.");
        }

        System.out.println("\n--------------------------------------------");

        System.out.println("\nOrdenando el catálogo por título");

        ArrayUtils.sort(catalogo);

        System.out.println(Arrays.toString(catalogo));

    }
}
