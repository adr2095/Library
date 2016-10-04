package ucr.ac.cr.ecci.ci1221.util.collections.list;

import java.util.Iterator;

/**
 * Doubly Linked pointer based implementation of the {@link List} model.
 *
 * @TODO Complete operators implementations, javadoc and any missing code.
 *
 * @param <E> the type of elements in the list.
 * @author Student Name
 */
public class DoubleLinkedList<E> implements List<E>  {
    private Node head;
    private Node tail;
    private int nElements = 0;
    /**
     * @TODO Add missing attributes and private methods and classes.
     */

    @Override
    public E get(int index) {
        if(!isEmpty() && index <= nElements) {
                Node node = head;
                int cont = 0;

                while (node.next() != null && cont != index - 1) {
                    node = node.next();
                    ++cont;
                }
                return node.getElement();
        }
        else {
            return null;
        }
    }

    @Override
    public E next(int index) {
        if(!isEmpty()) {
            Node node = head;
            int cont = 1;

            while (node != null && cont != index)
            {
                node = node.next();
                ++cont;
            }
            if(node != null) {
                return node.getElement();
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public E previous(int index) {
        if (!isEmpty())
        {
            Node node = head;
            int cont = 1;
            while (node.next() != null && cont != index)
            {
                node = node.next();
                ++cont;
            }

            if (node != head)
            {
                return node.prev().getElement();
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
        if (!isEmpty()) {
            Node node = head;
            int cont = 1;
            E oldElement;
            while (node.next() != null && cont != index) {
                node = node.next();
                ++cont;
            }
            oldElement = node.getElement();
            node.setElement(element);
            return oldElement;
        }else {
            return null;
        }
    }

    @Override
    public void add(int index, E element) {
        if (index <= nElements) {
            Node newNode = new Node(element);

            if(index != 1){
                Node tmp = head;
                int cont = 0;
                while(cont != index - 1 && tmp.next != null){
                    tmp = tmp.next;
                    ++cont;
                }
                newNode.next = tmp;
                newNode.prev = tmp.prev;
                tmp.prev.next = newNode;
                tmp.prev = newNode;
            }
            else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            ++nElements;
        }
        else{
            System.out.print("Invalid position");
        }
    }

    /*
    *  @Override
    public void add(int index, E element) {
        if (index <= nElements + 1) {
            Node newNode = new Node(element);

            if (!isEmpty() && index != 1) {
                Node node = head;
                int cont = 0;

                while (node.next() != null && cont != index - 1) {
                    node = node.next();
                    ++cont;
                }
                    newNode.setPrev(node.prev());
                    newNode.setNext(node);
                    node.prev().setNext(newNode);
                    node.setPrev(newNode);
            } else {
                if(head != null) {
                    newNode.setNext(head.next());
                    newNode.setPrev(head);
                }
                head = newNode;
            }
            ++nElements;
        }
        else{
            System.out.print("Invalid position");
        }
    }*/

    @Override
    public boolean add(E e) {
        Node node = new Node(e);
        if(!isEmpty()) {
            Node tmp = head;

            while (tmp.next() != null) {
                tmp = tmp.next();
            }

            tmp.setNext(node);
            node.setPrev(tmp);
        }
        else
        {
            head = node;
        }
        ++nElements;
        return false;
    }

    @Override
    public E remove(int index) {
        if(!isEmpty() && index <= nElements) {
            E oldElement;
            if (index != 1) {
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
            } else {
                oldElement = head.element;

                head.next.prev = null;
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
        return new DoubleLinkedListIterator();
    }

    @Override
    public void clear() {
        if(!isEmpty()) {
            if (nElements != 1) {
                Node node = head;

                while (node != null) {
                    node.clearElement();
                    node = node.next();
                    --nElements;
                }
            } else {
                head.clearElement();
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

        public void clearElement() {
            this.element = null;
        }

        public void setNext(Node node)
        {
            this.next = node;
        }

        public void setPrev(Node node)
        {
            this.prev = node;
        }

        public void setElement(E element)
        {
            this.element = element;
        }

        public Node next()
        {
            return this.next;
        }

        public Node prev()
        {
            return this.prev;
        }

        public E getElement()
        {
            return this.element;
        }
    }

    private class DoubleLinkedListIterator implements Iterator<E>{
        private Node currentNode = new Node(head);

        @Override
        public boolean hasNext() {
            if(!isEmpty()) {
                    return currentNode.next() != null;
            }
            else {
                return false;
            }
        }

        @Override
        public E next() {
            if(!isEmpty()) {
                currentNode = currentNode.next();
                return currentNode.getElement();
            }
            else {
                return  null;
            }
        }
    }
}