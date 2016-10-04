package ucr.ac.cr.ecci.ci1221.tests;

import ucr.ac.cr.ecci.ci1221.util.collections.stack.ArrayStack;
import ucr.ac.cr.ecci.ci1221.util.collections.stack.InvertedArrayStack;
import ucr.ac.cr.ecci.ci1221.util.collections.stack.LinkedListStack;

/**
 * Created by Alexa on 25/09/2016.
 */
public class StackTest {
    public static void main(String args[])
    {
        LinkedListStack stack= new LinkedListStack();
        System.out.print("Size should be 0: " + stack.size() + " and should be empty: " + stack.isEmpty());
        System.out.print("\n'a', 'b', 'c', 'd', 'e', 'f' and 'g' will be push.\n");

        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');
        stack.push('e');
        stack.push('f');
        stack.push('g');

        stack.print();
        System.out.print("Size should be 7: " + stack.size());

        System.out.print("\nElement peeked should be 'g': " + stack.peek());

        System.out.print("\nElement poped should be 'g': " + stack.pop() +" and size should be 6: " + stack.size());

        stack.clear();
        System.out.print("\nThe list will be clear and should be empty: " + stack.isEmpty() + " and size should be 0: " + stack.size());




    }
}
