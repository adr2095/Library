package ucr.ac.cr.ecci.ci1221.util.collections.queue;

/**
 * Linked based implementation of the {@link Queue} model.
 *
 * @TODO Complete operators implementations, javadoc and any missing code.
 *
 * @param <E> the type of elements in the queue.
 * @author Student Name
 */
public class LinkedListQueue<E> implements Queue<E> {
    private Node head = null;
    private int nElements = 0;
    /**
     * @TODO Add missing attributes and private methods and classes.
     */

    @Override
    public void enqueue(E element) {
        if(!isEmpty())
        {
            Node node = head;

            while (node.next() != null)
            {
                node = node.next();
            }

            node.setNext(new Node(element));
        }
        else
        {
            head = new Node(element);
        }
        ++nElements;
    }

    @Override
    public E dequeue() {
        if (!isEmpty()) {
            E oldElement = head.getElement();
            head = head.next();
            --nElements;
            return oldElement;
        }
        else {
            return null;
        }
    }

    @Override
    public E peek() {
        if(!isEmpty())
        {
            return head.getElement();
        }
        else {
            return null;
        }
    }

    @Override
    public int size() {
        return nElements;
    }

    @Override
    public boolean isEmpty() {
        return nElements == 0;
    }

    @Override
    public void clear() {
        if(!isEmpty())
        {
            Node node = head;

            while(node != null)
            {
                node.setElement(null);
                --nElements;
            }
        }
    }

    public void print(){
        Node node = head;
        while(node != null)
        {
            System.out.print(node.getElement()+ " ");
            node = node.next();
        }
    }
    private class Node{
        private E element;
        private Node next;

        public Node(E element)
        {
            this.element = element;
            this.next = next;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public Node next() {
            return this.next;
        }

        public void setElement(E element)
        {
            this.element = element;
        }
        public E getElement()
        {
            return this.element;
        }
    }
}
