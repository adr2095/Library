package ucr.ac.cr.ecci.ci1221.util.collections.list;

import java.util.Iterator;

/**
 * Array based implementation of the {@link List} model.
 *
 * @param <E> the type of elements in the list.
 * @author Alexa Duarte
 */
public class ArrayList<E> implements List<E> {
    private E[] array;
    private int nElements = 0;

    public ArrayList() {
        array = (E[]) new Object[10];
    }

    @Override
    public E get(int index) {
        if (index <= array.length) {
            return array[index - 1];
        } else {
            throw new IndexOutOfBoundsException("Position" + index + "does not exist.");
        }
    }

    @Override
    public E next(int index) {
        if (index < nElements && index < array.length) {
            return array[index];
        } else {
            return null;
        }
    }

    @Override
    public E previous(int index) {
        if (index - 1 >= 1 && index <= nElements) {
            return array[index - 1];
        } else {
            return null;
        }
    }

    @Override
    public E set(int index, E element) {
        if(element != null) {
            if (index <= nElements) {
                E prevElement = array[index - 1];

                if (index <= array.length) {
                    array[index - 1] = element;
                }
                return prevElement;
            } else {
                throw new IndexOutOfBoundsException("Position" + index + "does not exist.");
            }
        }
        else {
            throw new NullPointerException("Can insert a null element");
        }
    }

    @Override
    public void add(int index, E element) {
        if(element != null) {
            if (index <= nElements) {
                if (nElements < array.length) {
                    if (array[index - 1] != null) {
                        for (int i = nElements; i > index - 1; --i) {
                            array[i] = array[i - 1];
                        }
                    }
                } else {
                    resizeArray(index);
                }
                array[index - 1] = element;
                ++nElements;
            } else {
                throw new IndexOutOfBoundsException("Position" + index + "does not exist.");
            }
        }
        else {
          throw new NullPointerException("Can insert a null element");
        }
    }

    /**
     * Resize the array.
     * @param index the index of element to be add.
     */
    void resizeArray(int index) {
        E[] newArray = (E[]) new Object[array.length + 10];
        int i = 0;
        int j = i;
        while (i < nElements) {
            if (i != index - 1) {
                newArray[j] = array[i];
            } else {
                j = j + 1;
                newArray[j] = array[i];
            }
            ++i;
            ++j;
        }
        array = newArray;
    }

    @Override
    public boolean add(E e) {
        if(e != null) {
            if (nElements >= array.length) {
                resizeArray(nElements + 1);
            }
            array[nElements] = e;
            ++nElements;
            return true;
        }
        else {
            throw new NullPointerException("Can insert a null element");
        }
    }

    @Override
    public E remove(int index) {
        if (!isEmpty()) {
            int position = index - 1;
            E oldElement = array[position];

            while (index < nElements) {
                array[position] = array[index];
                position = index;
                ++index;
            }
            array[position] = null;
            --nElements;
            return oldElement;
        }
        else {
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
    public void clear() {
        array = null;
        nElements = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E>{
        private int currentPosition = -1;

        public boolean hasNext() {
            return nElements > 11 && currentPosition < nElements - 1;
        }

        public E next() {
            if (nElements > 0) {
                return array[++currentPosition];
            }
            else {
                return null;
            }
        }
    }
}
