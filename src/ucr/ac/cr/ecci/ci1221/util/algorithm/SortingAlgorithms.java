package ucr.ac.cr.ecci.ci1221.util.algorithm;

import ucr.ac.cr.ecci.ci1221.util.collections.list.List;

/**
 * Utilitary class that provides sorting algorithms for sorting elements in lists.
 *
 * @TODO Complete code implementations and javadoc.
 *
 * @author Alexa Duarte.
 */
public class SortingAlgorithms {

    public static <T extends Comparable<? super T>> void bubbleSort(List<T> list) {
        boolean swap = true;

        while (swap) {
            swap = false;
            for (int i = 1; i <= list.size(); ++i) {
                if ((i + 1) <= list.size() && list.get(i + 1).compareTo(list.get(i)) < 0) {
                    swap(list, i, i + 1);
                    swap = true;
                }
            }
        }
    }

    public static <T extends Comparable<? super T>> void insertionSort(List<T> list) {
        int ordered = 1;
        int j = 1;
        for (int i = 2; i <= list.size(); ++i) {
            while (j <= ordered && list.get(i).compareTo(list.get(j)) > 0) {
                ++j;
            }
            if (i != j) {
                list.add(j, list.get(i));
                list.remove(i + 1);
            }
            ++ordered;
            j = 1;
        }
    }

    public static <T extends Comparable<? super T>> void selectionSort(List<T> list) {
        int smallest;
        int ordered = 0;
        for (int j = 1; j <= list.size(); ++j) {
            smallest = j;

            for (int i = j + 1; i <= list.size(); ++i) {
                if (list.get(smallest).compareTo(list.get(i)) > 0) {
                    smallest = i;
                }
            }

            swap(list, ++ordered, smallest);
        }
    }

    public static <T extends Comparable<? super T>> void quickSort(List<T> list) {
        if (!list.isEmpty())
            quickSortRecursive(list, 1, list.size());
    }

    public static <T extends Comparable<? super T>> void quickSortRecursive(List<T> list, int begin, int end) {
        int pivot = end;
        int i = begin;
        int j = end;

        while (j > i) {
            if (list.get(i).compareTo(list.get(pivot)) < 0 || list.get(j).compareTo(list.get(pivot)) >= 0) {
                if (list.get(i).compareTo(list.get(pivot)) < 0) {
                    ++i;
                }
                if (list.get(j).compareTo(list.get(pivot)) >= 0) {
                    --j;
                }
            } else {
                swap(list, i, j);
                ++i;
                --j;
            }
        }
        if(list.get(i).compareTo(list.get(pivot)) >= 0){
            swap(list, pivot, i);
        }

        if(begin < i-1)
            quickSortRecursive(list, 1, i - 1);
        if(end > i+1 )
            quickSortRecursive(list, i + 1, end);
    }

    public static void swap(List list, int i, int j){
        Object element = list.get(i);
        list.set(i, list.get(j));
        list.set(j, element);
    }

    public static <T extends Comparable<? super T>> void mergeSort(List<T> list){

    }

    public static <T extends Comparable<? super T>> void mergeSortRecursive(List<T> list) {

    }
}

