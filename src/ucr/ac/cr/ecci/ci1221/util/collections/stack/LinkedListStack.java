package ucr.ac.cr.ecci.ci1221.util.collections.stack;

/**
 * Array based implementation of the {@link Stack} model.
 *
 * @TODO Complete operators implementations, javadoc and any missing code.
 *
 * @param <E> the type of elements in the stack.
 * @author Rodrigo A. Bartels
 */
public class LinkedListStack<E> implements Stack<E> {
    private Node head = null;
    private int N = 0;
    /**
     * @TODO Add missing attributes and private methods and classes.
     */

    @Override
    public void push(E element) {
        head = new Node(element, head);
        ++N;
    }

    @Override
    public E pop() {
        if(!isEmpty()) {
            E element = head.element;
            head = head.next;
            return element;
        }
        else{
            return null;
        }
    }

    @Override
    public E peek() {
        return head.element;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public void clear() {
        if(!isEmpty()) {
            Node node = head;

            while (node != null) {
                node = node.next;
            }
            N = 0;
        }
    }

    public void print()
    {
        if(!isEmpty()) {
            Node node = head;
            while (node != null) {
                System.out.print(node.element);
                node = node.next;
            }
        }
    }

    private class Node
    {
        Node next;
        E element;

        public Node(E element, Node next)
        {
            this.element = element;
            this.next = next;
        }
    }
}
