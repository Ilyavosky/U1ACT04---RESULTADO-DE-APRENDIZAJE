import java.util.ArrayList;
import java.util.function.Predicate;

public class ArrayUtils {
    public static <T> T[] filter(T[] array, Predicate<T> predicate) {
        if (array == null || array.length == 0) {
            return array;
        }
        ArrayList<T> resultado = new ArrayList<>();
        for(T elemento :array){
            if (predicate.test(elemento) == true) {
                resultado.add(elemento);
            }
        }
        return resultado.toArray((T[]) new Object[resultado.size()]);
    }
}
