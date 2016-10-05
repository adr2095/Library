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
    private Node head = null;
    public Node tail = null;
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
            throw new IndexOutOfBoundsException();
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
        if(!isEmpty() && index <= nElements) {
            if (element != null) {
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
            else
            {
                throw new NullPointerException();
            }
        }
        else
            throw new IndexOutOfBoundsException();
    }

    @Override
    public void add(int index, E element) {
        if (!isEmpty() && index <= nElements) {
            if (element != null) {
                Node newNode = new Node(element);
                if (index != 1) {
                    Node tmp = head;
                    int cont = 0;
                    while (cont != (index - 1) - 1 && tmp.next != null) {
                        tmp = tmp.next;
                        ++cont;
                    }
                    newNode.next = tmp.next;
                    tmp.next = newNode;

                } else {
                    newNode.next = head;
                    head = newNode;
                }
                ++nElements;
            }
            else {
                throw new NullPointerException();
            }
        }else {
             throw new IndexOutOfBoundsException("Position" + index + "does not exist.");
        }
    }

    @Override
    public boolean add(E e) {
        if(e != null) {
            Node newNode = new Node(e);
            if (!isEmpty()) {
                tail.next = newNode;
                tail = newNode;
                ++nElements;
                return true;
            } else {
                head = newNode;
                tail = newNode;
                ++nElements;
                return true;
            }
        }
        else {
            throw new NullPointerException();
        }
    }

    @Override
    public E remove(int index) {
        if(!isEmpty() && index <= nElements) {
            E oldElement;

            if (index != 1 && index != nElements) {
                Node node = head;
                int cont = 0;

                while (node.next != null && (index - 1) - 1 != cont) {
                    node = node.next;
                    ++cont;
                }
                oldElement = node.next.element;
                node.next = node.next.next;
            } else if(index == 1) {
                oldElement = head.element;
                head = head.next;
            }
            else {
                Node node = head;
                int cont = 0;

                while (node.next != null && nElements - 2 != cont) {
                    node = node.next;
                    ++cont;
                }
                oldElement = node.next.element;
                node.next = null;
                tail = node;
            }
            --nElements;
            return oldElement;
        } else {
            throw new IndexOutOfBoundsException("Position" + index + "does not exist.");
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