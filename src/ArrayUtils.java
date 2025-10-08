import java.util.ArrayList;
import java.util.function.Predicate;

public class ArrayUtils {
    public static <T> T[] filter(T[] array, Predicate<T> predicate){
        filter(array, predicate);
        if (array.length == 0 || array[0] == null){
            return array;
        }else {
            ArrayList<T> aprovo = new ArrayList<>();
            aprovo.add(array[0]);
        }

        return filter(array,  predicate);
    }
}
