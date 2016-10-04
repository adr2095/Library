package ucr.ac.cr.ecci.ci1221.tests;

import ucr.ac.cr.ecci.ci1221.domain.Song;
import ucr.ac.cr.ecci.ci1221.util.algorithm.SearchAlgorithms;
import ucr.ac.cr.ecci.ci1221.util.algorithm.SortingAlgorithms;
import ucr.ac.cr.ecci.ci1221.util.collections.list.ArrayList;
import ucr.ac.cr.ecci.ci1221.util.collections.list.List;

import java.util.Iterator;

/**
 * An example of a test case. Each student has to write his own
 * in different classes, for each data structure and all operators and document them.
 */
public class Main {

    public static void main(String[] args) {
	   /* List<Song> list = new ArrayList<Song>();

        System.out.println("Size should be zero: " + list.size() + " and be empty: " + list.isEmpty());

        Song bohemianRhapsody = new Song("Bohemian Rhapsody", 367);

        list.add(new Song("The Show Must Go On", 262));
        list.add(bohemianRhapsody);
        list.add(new Song("Radio Ga Ga", 356));
        list.add(new Song("It's a Hard Life", 254));

        System.out.println("Size should be 4: " + list.size() + " and be empty false: " + list.isEmpty());

        //Song searchedSong = SearchAlgorithms.linearSearch(list, bohemianRhapsody);
        //System.out.println("The song retrieved should be the same: " + bohemianRhapsody.equals(searchedSong));

        list.remove(1);
        System.out.println("Size should be 3: " + list.size() + " and be empty false: " + list.isEmpty());

        Song song = list.get(1);
        System.out.println("The song retrieved should be Bohemian Rhapsody: " + bohemianRhapsody.equals(song));

        Iterator<Song> iterator = list.iterator();
        while(iterator.hasNext()){
            Song element = iterator.next();
            System.out.println("Song name: " + element.getTitle() + " \tDuration: " + element.getSeconds());
        }

       // SortingAlgorithms.bubbleSort(list);
        //System.out.println("The song retrieved should be It's a Hard Life: " + list.get(1).getTitle());
     list.clear();

        System.out.println("Size should be zero: " + list.size() + " and be empty: " + list.isEmpty());
*/

        System.out.println("TEST OF ARRAY LIST");

        List<char> list = new ArrayList<~>();

        System.out.print("The list should be empty: " + list.isEmpty() + " and size should be 0: " + list.size() + "\n");

        System.out.print("10 elements will be add..\n");

        for(char i = 'a'; i < 'k' ; i++)
        {
            list.add(i);
        }

        System.out.println("Size should be 10: " + list.size() + " and be empty false: " + list.isEmpty());

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
