package ucr.ac.cr.ecci.ci1221.util.algorithm;

import ucr.ac.cr.ecci.ci1221.util.collections.list.List;

/**
 * Utilitary class that provides searching algorithms for looking for elements in lists.
 *
 * @TODO Complete code implementations and javadoc.
 *
 * @author Student name.
 */
public class SearchAlgorithms{

    public static <T extends Comparable<? super T>> T linearSearch(List<T> list, T key){
       if(!list.isEmpty()) {
           int index = 1;
           while (index <= list.size() && (char)list.get(index).compareTo(key) != 0){
               ++index;
           }
           if (index <= list.size()) {
               return key;
           }
           else {
               return null;
           }
       }
       else{
           return null;
       }
    }

    public static <T extends Comparable<? super T>> T binarySearch(List<T> list, T key){
        if(!list.isEmpty()) {
            return binarySearchRecursive(1, list.size(), list, key);
        }
        else {
            return null;
        }
    }

    private static <T extends Comparable<? super T>> T binarySearchRecursive(int inicio ,int fin, List<T> list, T key){
        int medio = (inicio + fin)/2;
        if(fin - inicio != 0) {
            if (key.compareTo(list.get(medio)) == 0)
                return key;
            else if (key.compareTo(list.get(medio)) < 0)
                return binarySearchRecursive(inicio, medio - 1, list, key);
            else {
                return binarySearchRecursive(medio + 1, fin, list, key);
            }
        }
        else
        {
            if (list.get(medio).compareTo(key) == 0)
                return key;
            else
                return null;
        }
    }
}