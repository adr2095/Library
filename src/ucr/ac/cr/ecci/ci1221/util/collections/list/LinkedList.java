package ucr.ac.cr.ecci.ci1221.util.collections.list;

import java.util.Iterator;

/**
 * Linked pointer based implementation of the {@link List} model.
 *
 * @TODO Complete operators implementations, javadoc and any missing code.
 *
 * @param <E> the type of elements in the list.
 * @author Student Name
 */
public class LinkedList<E> implements List<E> {
    private Node head;
    private int nElements = 0;

    public LinkedList() {
        this.head = null;
    }

    /**
     * @TODO Add missing attributes and private methods and classes.
     */

    @Override
    public E get(int index) {
        if(!isEmpty() && index <= nElements) {
            if(index - 1 != 0)
            {
                Node node = head;
                int cont = 0;

                while (node.next != null && cont != index - 1) {
                    node = node.next;
                    ++cont;
                }
                return node.element;
            }
            else
            {
                return head.element;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public E next(int index) {
        if (index <= nElements && !(isEmpty())) {
            Node node = head;
            int cont = 0;

            while (node.next != null && cont != index - 1) {
                node = node.next;
                ++cont;
            }
            return node.element;
        } else {
            return null;
        }
    }

    @Override
    public E previous(int index) {
        if (index <= nElements && !(isEmpty())) {
            Node node = head;
            int cont = 1;

            while (node.next != null && cont != index - 1) {
                node = node.next;
                ++cont;
            }
            return node.element;
        } else {
            return null;
        }
    }

    @Override
    public E set(int index, E element) {

        Node node = head;
        int cont = 0;
        E oldElement = null;

        while (node.next != null && cont != index - 1) {
            node = node.next;
            ++cont;
        }

        if (node != null) {
            oldElement = node.element;
            node.element = (element);
        }

        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        if (index <= nElements) {
            Node newNode = new Node(element);
         if(index != 1)
         {
             Node tmp = head;
             int cont = 0;
             while(cont != (index - 1) - 1 && tmp.next != null){
                 tmp = tmp.next;
                 ++cont;
             }
             newNode.next = tmp.next;
             tmp.next = newNode;

         }
         else {
             newNode.next = head;
             head = newNode;
         }
            ++nElements;
        }
    }

    @Override
    public boolean add(E e) {
        Node newNode = new Node(e);
        if(!isEmpty()) {
            Node node = head;

            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
            ++nElements;
            return true;
        }
        else
        {
            head = newNode;
            ++nElements;
            return true;
        }
    }

    @Override
    public E remove(int index) {
        if(!isEmpty() && index <= nElements) {
            E oldElement;

            if(index - 1 != 0 ) {
                Node node = head;
                int cont = 0;

                while (node.next != null && (index - 1) - 1 != cont) {
                    node = node.next;
                    ++cont;
                }
                oldElement = node.next.element;
                node.next = node.next.next;
            }
            else {
                oldElement = head.element;
                head = head.next;
            }
            --nElements;
            return oldElement;
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
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            if(nElements != 1) {
                Node node = head;

                while (node != null) {
                    node.element = null;
                    node = node.next;
                }
            }else{
                head.element = null;
            }
            nElements = 0;
        }
    }

    private class Node{
        private E element;
        private Node next;

        public Node( E element)
        {
            this.element = element;
            this.next = null;
        }
        public Node(Node node)
        {
            this.next = node;
        }
    }

    private class LinkedListIterator implements Iterator<E>
    {
        private Node currentNode = new Node(head);

        @Override
        public boolean hasNext() {
            if(!isEmpty()) {
                return currentNode.next != null;
            }
            else {
                return false;
            }
        }

        @Override
        public E next() {
            if(!isEmpty()) {
                currentNode = currentNode.next;
                return currentNode.element;
            }
            else {
                return  null;
            }
        }
    }
}