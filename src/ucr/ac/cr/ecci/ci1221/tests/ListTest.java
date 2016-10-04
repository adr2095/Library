package ucr.ac.cr.ecci.ci1221.tests;

        import ucr.ac.cr.ecci.ci1221.domain.Song;
        import ucr.ac.cr.ecci.ci1221.util.algorithm.SortingAlgorithms;
        import ucr.ac.cr.ecci.ci1221.util.collections.list.ArrayList;
        import ucr.ac.cr.ecci.ci1221.util.collections.list.DoubleLinkedList;
        import ucr.ac.cr.ecci.ci1221.util.collections.list.LinkedList;
        import java.util.Iterator;
        import ucr.ac.cr.ecci.ci1221.util.algorithm.SearchAlgorithms;

/**
 * Created by Alexa on 24/09/2016.
 */
public class ListTest {
    public static void main(String args[]) {
        ArrayList list = new ArrayList();
        System.out.print("Test of list:\n");
        System.out.print("The list should be empty: " + list.isEmpty() + "\n");
        System.out.print("The size should be 0: " + list.size() + "\n");

        System.out.print("Add 'b' at position 3 will be null: ");
        list.add(3, 'b');
        System.out.print(list.get(3) + "\n");

        System.out.print("'a', 'b', 'g', 'x', 'd', 'm', 'g', 'h', 'l', 'i' will be placed " +
                "by order of entry: ");
        list.add('a');
        list.add('b');
        list.add('g');
        list.add('x');
        list.add('d');
        list.add('m');
        list.add('g');
        list.add('h');
        list.add('l');
        list.add('i');

        Iterator iterator = list.iterator();

        while(iterator.hasNext()){
            char element = (char) iterator.next();
            System.out.print(element + " ");
        }

        System.out.print("\nAdding 'Z' at 4rd position will move all elements and insert 'Z' at that place: ");
        list.add(4, 'Z');

        iterator = list.iterator();

        while(iterator.hasNext()){
            char element = (char) iterator.next();
            System.out.print(element + " ");
        }

        System.out.print("\nSet 'O' at 11th position will return 'i' and set 'O' at that place: Element replace (");
        System.out.print(list.set(11, 'O') + ") List: ");
        iterator = list.iterator();

        while(iterator.hasNext()){
            char element = (char) iterator.next();
            System.out.print(element + " ");
        }

        System.out.print("\nWill remove element at position 1  and 4 from list. ");
        System.out.print("\nPosition 1: " + list.remove(1) + " New list: ");
        iterator = list.iterator();

        while(iterator.hasNext()){
            char element = (char) iterator.next();
            System.out.print(element + " ");
        }
        System.out.print("\nPosition 4: " + list.remove(4) + " New list: ");
        iterator = list.iterator();

        while(iterator.hasNext()){
            char element = (char) iterator.next();
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.println("'O' should be found: " + SearchAlgorithms.linearSearch(list, 'O'));
        System.out.println("'Y' should not be found: " + SearchAlgorithms.linearSearch(list, 'Y'));

        SortingAlgorithms.bubbleSort(list);

        iterator = list.iterator();
        while(iterator.hasNext()){
            char element = (char) iterator.next();
            System.out.print(element + " ");
        }

        /*System.out.println("'O' should be found: " + SearchAlgorithms.binarySearch(list, 'O'));
        System.out.println("'Y' should not be found: " + SearchAlgorithms.binarySearch(list, 'Y'));*/

        System.out.print("\nList will be clear and will be empty and size 0: ");
        list.clear();
        System.out.print("It's empty?: " + list.isEmpty() + " Size: " + list.size() + "\n");
    }
}
