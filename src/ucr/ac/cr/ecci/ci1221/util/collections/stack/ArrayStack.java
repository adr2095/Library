package ucr.ac.cr.ecci.ci1221.util.collections.stack;

/**
 * Array based implementation of the {@link Stack} model.
 *
 * @TODO Complete operators implementations, javadoc and any missing code.
 *
 * @param <E> the type of elements in the stack.
 * @author Rodrigo A. Bartels
 */
public class ArrayStack<E> implements Stack<E>{
    private int size = 10;
    private E[] array = (E[]) new Object[size];
    private int N = 0;
    /**
     * @TODO Add missing attributes and private methods and classes.
     */

    @Override
    public void push(E element) {
        if(N < array.length) {
            array[N] = element;

        }
        else{
            resizeArray();
        }
        ++N;
    }

    private void resizeArray()
    {
        size =+10;
        E[] newArray = (E[]) new Object[size];

        for(int i = 0; i< N; ++i) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public E pop() {
        if(!isEmpty()) {
            E element = array[N-1];
            array[N-1] = null;
            --N;
            return element;
        }
        else{
            return null;
        }
    }

    @Override
    public E peek() {
        if(!isEmpty()) {
            return array[N - 1];
        }
        else{
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

    public void print()
    {
        for(int i = 0; i < N; ++i)
        {
            System.out.print(array[i]+ " ");
        }
    }
}
