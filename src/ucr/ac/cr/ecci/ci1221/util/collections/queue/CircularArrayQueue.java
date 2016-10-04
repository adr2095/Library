package ucr.ac.cr.ecci.ci1221.util.collections.queue;

/**
 * Circular array based implementation of the {@link Queue} model.
 *
 * @TODO Complete operators implementations, javadoc and any missing code.
 *
 * @param <E> the type of elements in the queue.
 * @author Student Name
 */
public class CircularArrayQueue<E> implements Queue<E> {
    E[] array = (E[]) new Object[10];
    int read = 0;
    int write = 0;

    int N = 0;
    @Override
    public void enqueue(E element) {
        if(N != 0 && write%N != read){
                array[write] = element;
        }
        else
        {
            array[write] = element;
        }
        ++N;
        ++write;
    }



    @Override
    public E dequeue() {
        if (!isEmpty()) {
            E element = array[read];
            for(int i = 0; i < N; ++i)
            {
                array[i]=array[i+1];
            }
            --N;
            ++read;
            return element;
        }
        else {
            return null;
        }
    }

    @Override
    public E peek() {
        if (!isEmpty()) {
            E element = array[read];
            return element;
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
        return write == read;
    }

    @Override
    public void clear() {
        for(int i = 0; i<N; ++i)
        {
            array[i] = null;
        }
        read =0;
        write = 0;
    }

    public void print()
    {
        for(int i = 0; i < N; ++i)
        {
            System.out.print(array[i] + " ");
        }
    }
}
