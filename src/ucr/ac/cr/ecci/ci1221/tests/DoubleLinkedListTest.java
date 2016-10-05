package ucr.ac.cr.ecci.ci1221.tests;

import ucr.ac.cr.ecci.ci1221.util.algorithm.SearchAlgorithms;
import ucr.ac.cr.ecci.ci1221.util.algorithm.SortingAlgorithms;
import ucr.ac.cr.ecci.ci1221.util.collections.list.DoubleLinkedList;
import ucr.ac.cr.ecci.ci1221.util.collections.list.List;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by Alexa on 04/10/2016.
 */
public class DoubleLinkedListTest {
    public static void main(String args[]) {
        try {
            List list = new DoubleLinkedList();
            Random rnd = new Random();
            System.out.print("ARRAY LIST TEST:\n");
            System.out.println("The list should be empty: " + list.isEmpty() + " and the size should be 0: " + list.size());

            System.out.println("3 will be add to the list and 9 random other ints..");

            list.add(3);
            for (int i = 0; i < 9; ++i) {
                list.add(rnd.nextInt(100 + 1));
            }

            System.out.print("List: ");

            Iterator iterator = list.iterator();
            Object element;
            while (iterator.hasNext()) {
                element = iterator.next();
                System.out.print(element + " ");
            }

            System.out.println("\nGet of position 1 will be 3: " + list.get(1));

            list.add(4, 8);

            System.out.print("Adding 8 at 4rd position will move all elements and insert 8 at " +
                    "that place and size should be 11: " + list.size() + ". New list: ");


            iterator = list.iterator();
            while (iterator.hasNext()) {
                element = iterator.next();
                System.out.print(element + " ");
            }

            System.out.println("\nSet '89' at 4rd position will return an 8 and set 89 at that place: " + list.set(4, 89));

            System.out.println("Remove element at position 1 should return a 3: " + list.remove(1) +
                    " and list size should be 10: " + list.size());


            System.out.println("\n89 should be found by linear search: " + SearchAlgorithms.linearSearch(list, 89));
            System.out.println("111 should not be found by linear search: " + SearchAlgorithms.linearSearch(list, 111));

            System.out.println("List should be in order by insertion sort: ");
            SortingAlgorithms.insertionSort(list);

            iterator = list.iterator();
            while (iterator.hasNext()) {
                element = iterator.next();
                System.out.print(element + " ");
            }

            System.out.println("\n89 should be found by binary search: " + SearchAlgorithms.binarySearch(list, 89));
            System.out.println("111 should not be found by binary search: " + SearchAlgorithms.binarySearch(list, 111));

            System.out.print("\nList will be clear and should be empty: ");
            list.clear();
            System.out.print(list.isEmpty() + " and size should be 0: " + list.size() + "\n");
            System.out.print("Get element at position 2 should trow an exception: ");
            list.get(2);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Position does not exist.");
        } catch (NullPointerException n) {
            System.out.println("Can insert a null element");
        }
    }
}
