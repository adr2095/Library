package ucr.ac.cr.ecci.ci1221.util.collections.queue;

/**
 * Array based implementation of the {@link Queue} model.
 *
 * @TODO Complete operators implementations, javadoc and any missing code.
 *
 * @param <E> the type of elements in the queue.
 * @author Student Name
 */
public class ArrayQueue<E> implements Queue<E> {
    private E [] array;
    private int size = 10;
    private int N = 0;

    /**
     * @TODO Add missing attributes and private methods and classes.
     */

    public ArrayQueue()
    {
        array = (E[]) new Object[size];
    }

    @Override
    public void enqueue(E element) {
            if(N >= array.length) {
                resizeArray();
            }
            array[N] = element;
            ++N;
    }

    public void print()
    {
        for(int i = 0; i < N; ++i)
        {
            System.out.print(array[i] + " ");
        }
    }

    private void resizeArray()
    {
        size = size +10;
        E[] newArray = (E[]) new  Object[size];

        for(int i = 0; i < N; ++i)
        {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public E dequeue() {
        if(!isEmpty()) {
            E oldElement = array[0];
            for (int i = 0; i < N; ++i) {
                array[i] = array[i + 1];
            }
            --N;
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
        for(int i = 0; i<N; ++i){
            array[i] = null;
        }
    }
}
