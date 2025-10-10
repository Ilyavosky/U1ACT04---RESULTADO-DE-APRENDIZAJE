package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class ArrayUtils {

    public static <T> T[] filter(T[] array, Predicate<T> predicate) {
        if (array == null || array.length == 0) {
            return array;
        }
        ArrayList<T> resultado = new ArrayList<>();
        for(T elemento : array){
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
        for(T elemento : array){
            if (predicate.test(elemento)) {
                return elemento;
            }
        }
        return null;
    }

    public static <T extends Comparable<T>> void sort(T[] array){
        if (array == null || array.length < 2){
            return;
        }
        Arrays.sort(array);
    }

    public static <T extends Filtrable> T[] filtrarPorCriterio(T[] array, String criterio) {
        if (array == null || array.length == 0) {
            return array;
        }
        ArrayList<T> resultado = new ArrayList<>();
        for(T elemento : array){
            if (elemento.cumpleFiltro(criterio)) {
                resultado.add(elemento);
            }
        }
        return resultado.toArray(Arrays.copyOf(array, 0));
    }
}