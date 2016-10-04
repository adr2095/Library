package ucr.ac.cr.ecci.ci1221.tests;

import ucr.ac.cr.ecci.ci1221.util.collections.queue.ArrayQueue;
import ucr.ac.cr.ecci.ci1221.util.collections.queue.LinkedListQueue;
import ucr.ac.cr.ecci.ci1221.util.collections.queue.CircularArrayQueue;

/**
 * Created by Alexa on 25/09/2016.
 */
public class QueueTest {
    public static void main( String args[]) {
        CircularArrayQueue queue = new CircularArrayQueue();
        System.out.print("Queue should be empty: " + queue.isEmpty());
        System.out.print("\n\n'a' t 'z' will be add to queue: ");
        for(char i = 'a'; i <= 'f'; ++i)
        {
            queue.enqueue(i);
        }
        queue.print();

        System.out.print("\n\nList size should be 26: " + queue.size());
        System.out.print("\n\nFirst element should be 'a': " + queue.peek() + "\n\n");

        System.out.print("Apply dequeue:\n" +
                "Element removed should be 'a': " + queue.dequeue() +
                "\nList size should be 25: " + queue.size() + "\nNew list: ");

        queue.print();

         /*






        System.out.print();
        System.out.print();
        System.out.print();*/
    }
}
