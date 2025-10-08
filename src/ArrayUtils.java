import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class ArrayUtils {
    public static <T> T[] filter(T[] array, Predicate<T> predicate) {
        if (array == null || array.length == 0) {
            return array;
        }
        ArrayList<T> resultado = new ArrayList<>();
        for(T elemento :array){
            if (predicate.test(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado.toArray(Arrays.copyOf(array, 0));
    }

    public static <T> T findFirst(T[] array, Predicate<T> predicate) {
        if (array == null || array.length == 0) {
            return null;
        }
        for(T elemento :array){
            if (predicate.test(elemento)) {
                return elemento;
            }
        }
        return null;
    }


}
