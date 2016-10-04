package ucr.ac.cr.ecci.ci1221.util.collections.stack;

/**
 * Array based implementation of the {@link Stack} model.
 *
 * @TODO Complete operators implementations, javadoc and any missing code.
 *
 * @param <E> the type of elements in the stack.
 * @author Rodrigo A. Bartels
 */
public class InvertedArrayStack<E> implements Stack<E> {
    private E[] array = (E[]) new Object[10];
    private int N = 0;
    /**
     * @TODO Add missing attributes and private methods and classes.
     */

    @Override
    public void push(E element) {
        if(!isEmpty()) {
            if (N <= array.length) {
                for (int i = N - 1; i >= 0; --i) {
                    array[i + 1] = array[i];
                }
            } else {
                resizeArray();
            }
        }

        ++N;
        array[0] = element;
    }

    private void resizeArray()
    {
        E[] newArray = (E[]) new Object[array.length + 10];
        for(int i = 1; i < N; ++i)
        {
            newArray[i] = array[i-1];
        }
        array = newArray;
    }
    @Override
    public E pop() {
        if(!isEmpty()) {
            E element = array[0];

            for (int i = 0; i < N; ++i) {
                array[i] = array[i + 1];
            }
            --N;
            return element;
        }
        else {
            return null;
        }

    }

    @Override
    public E peek() {
        if(!isEmpty()) {
            return array[0];
        }
        else {
            return null;
        }
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
        for(int i = 0; i < N; ++i)
        {
            array[i] = null;
        }
        N = 0;
    }

    public void print() {
        for (int i = 0; i < N; ++i) {
            System.out.print(array[i] + " ");
        }
    }
}