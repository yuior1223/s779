package deque;

public class ArrayDeque<T> implements Deque<T>
{
     private T[] items;
     private int size;
     /** start from T[front]*/
     private int front;
     /** last item is T[last]*/
     private int last;

     public ArrayDeque() {
         items = (T []) new Object [4];
         size = 0;
         front = 0;
         last =0 ;
     }

     /** resize item with cap*/
     private void resize (int cap)
     {
         T[] a = (T []) new Object [cap];
         if(last >= front)
         {
             System.arraycopy(items, front, a, 0, size);
             items = a;
             front = 0;
             last = size - 1;
         }

         if(last < front)
         {
             int cont = items.length - front;
             System.arraycopy(items,front,a,0,cont);
             System.arraycopy(items,0,a,cont,size-cont);
             front = 0;
             last = size - 1;
         }
         items = a;
     }

    @Override
     public void addFirst(T i)
     {
         if(size == 0)
         {
             items[0] = i;

         }
         else
         {
             while (size >= items.length) resize(size * 2);
             front = (front - 1 + items.length) % items.length;
             items[front] = i;
         }
         size += 1;
     }

    @Override
     public void addLast(T i)
     {
         if(size == 0)
         {
             items[0] = i;

         }
         else
         {
             while (size >= items.length)
             {
                 resize(size * 2);
             }
             last = (last + 1) % items.length;
             items[last] = i;
         }
         size += 1;
     }

    @Override
     public T removeFirst()
     {
         if(size == 0)
             return null;
         while(2 * size  <= items.length)
             resize(items.length / 2);
         T del = items[front];
         items[front] = null;
         front = (front + 1) % items.length;
         size -= 1;
         return del;
     }

    @Override
     public T removeLast()
     {
         if(size == 0)
             return null;
         while(2 * size  <= items.length)
             resize(items.length / 2);
         T del = items[last];
         items[last] = null;
         last = (last - 1  + items.length) % items.length;
         size -= 1;
         return del;

     }

    @Override
     public boolean isEmpty()
     {
         if(size == 0)
             return true;
         else
             return false;
     }

    @Override
     public int size()
     {
         return size;
     }

    @Override
     public void printDeque()
     {
         for(int i = 0;i<size;i++)
             System.out.print(items[(front + i) % items.length] + " ");
         System.out.println("\n");
     }

    @Override
     public T get(int index)
     {
         return items[(front + index) % items.length];
     }

     public Iterator<T> iterator()
     {
         return new ArrayDequeIterator();

     }


    @Override
    public boolean equals(Object o )
    {
        if(o == null)
            return false;
        if(o.getClass() != this.getClass())
            return false;
        ArrayDeque<T> other = (ArrayDeque<T>)  o;
        if(other.size() != this.size())
            return false;
        for(int i = 0; i < size();i+=1)
        {
            if(other.get(i) == this.get(i))
                return false;
        }
        return true;
    }
     private class ArrayDequeIterator implements Iterator<T>
     {
         private int wizpos;

         public ArrayDequeIterator()
         {
             wizpos = 0;
         }
         @Override
         public boolean hasNext()
         {
             return wizpos < size;
         }

         @Override
         public T next()
         {
             T returnItem = get(wizpos);
             wizpos += 1;
             return returnItem;
         }
     }

}
