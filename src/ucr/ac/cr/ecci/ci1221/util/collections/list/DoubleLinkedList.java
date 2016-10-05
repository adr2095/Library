package ucr.ac.cr.ecci.ci1221.util.collections.list;

import java.util.Iterator;

/**
 * Doubly Linked pointer based implementation of the {@link List} model.
 *
 * @param <E> the type of elements in the list.
 * @author Alexa Duarte.
 */
public class DoubleLinkedList<E> implements List<E>  {
    private Node head;
    private Node tail;
    private int nElements = 0;

    @Override
    public E get(int index) {
        if(!isEmpty() && index <= nElements) {
                Node node = head;
                int cont = 0;

                while (node.next != null && cont != index - 1) {
                    node = node.next;
                    ++cont;
                }
                return node.element;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E next(int index) {
        if(!isEmpty()) {
            Node node = head;
            int cont = 1;

            while (node != null && cont != index)
            {
                node = node.next;
                ++cont;
            }
            if(node != null) {
                return node.element;
            }
            else
            {
                return null;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public E previous(int index) {
        if (!isEmpty()) {
            Node node = head;
            int cont = 1;
            while (node.next != null && cont != index)
            {
                node = node.next;
                ++cont;
            }

            if (node != head)
            {
                return node.prev.element;
            }
            else{
                return null;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public E set(int index, E element) {
        if (!isEmpty() && index <= index) {
            if(element != null ) {
                Node node = head;
                int cont = 1;
                E oldElement;
                while (node.next != null && cont != index) {
                    node = node.next;
                    ++cont;
                }
                oldElement = node.element;
                node.element = element;
                return oldElement;
            }
            else{
                throw new NullPointerException();
            }
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(int index, E element) {
        if (index <= nElements && !isEmpty()) {
            if (element != null) {
                Node newNode = new Node(element);

                if (index != 1) {
                    Node tmp = head;
                    int cont = 0;
                    while (cont != index - 1 && tmp.next != null) {
                        tmp = tmp.next;
                        ++cont;
                    }
                    newNode.next = tmp;
                    newNode.prev = tmp.prev;
                    tmp.prev.next = newNode;
                    tmp.prev = newNode;
                } else {
                    newNode.next = head;
                    head.prev = newNode;
                    head = newNode;
                }
                ++nElements;
            } else {
                throw new NullPointerException();
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean add(E e) {
        if(e != null) {
            Node node = new Node(e);
            if (!isEmpty()) {
                tail.next = node;
                node.prev = tail;
                tail = node;
            } else {
                head = node;
                tail = node;
            }
            ++nElements;
            return true;
        }else
        {
            throw new NullPointerException();
        }
    }

    @Override
    public E remove(int index) {
        if(!isEmpty() && index <= nElements) {
            E oldElement;
            if (index != 1 && index != nElements) {
                Node tmp = head;
                int cont = 0;

                while (cont != index - 1 && tmp.next != null) {
                    tmp = tmp.next;
                    ++cont;
                }

                oldElement = tmp.element;

                tmp.prev.next = tmp.next;
                if(tmp.next != null) {
                    tmp.next.prev = tmp.prev;
                }
            } else if (index == 1){
                oldElement = head.element;

                head.next.prev = null;
                head = head.next;
            }
            else {
                oldElement = tail.element;
                tail.prev.next = null;
                tail = tail.prev;
            }
            --nElements;
            return oldElement;
        }
        else {
            throw new IndexOutOfBoundsException();
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
        return new DoubleLinkedListIterator();
    }

    @Override
    public void clear() {
        if(!isEmpty()) {
            if (nElements != 1) {
                Node node = head;

                while (node != null) {
                    node.element = null;
                    node = node.next;
                    --nElements;
                }
            } else {
                head.element = null;
                --nElements;
            }

        }
    }

    private class Node{
        private E element;
        private Node next;
        private Node prev;

        public Node(E element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }

        public Node(Node node)
        {
            this.next = node;
        }
    }

    private class DoubleLinkedListIterator implements Iterator<E>{
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