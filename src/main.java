import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Leccion[] catalogo = new Leccion[]{
                new Leccion("Circulo de DO", "Teoría", "Principiante"),
                new Leccion("Circulo de RE", "Teoría", "Principiante"),
                new Leccion("Circulo de MI", "Teoría", "Principiante"),
                new Leccion("Circulo de FA", "Teoría", "Principiante"),
                new Leccion("Circulo de SOL", "Teoría", "Principiante")
        };

        System.out.println("Catalogo de Lecciones disponibles");
        System.out.println(Arrays.toString(catalogo));

    }
}
