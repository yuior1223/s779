package deque;

public class ArrayDeque<T>
{
     private T[] items;
     private int size;
     /** start from T[front]*/
     private int front;
     /** last item is T[last]*/
     private int last;

     public ArrayDeque() {
         items = (T []) new Object [100];
         size = 0;
         front = 0;
     }

     /** resize item with cap*/
     private void resize (int cap)
     {
         T[] a = (T []) new Object [cap];
         if(last>front)
         {
             System.arraycopy(items, front, a, 0, size);
             items = a;
         }

         if(last < front)
         {
             int cont = items.length - front;
             System.arraycopy(items,front,a,0,cont);
             System.arraycopy(items,0,a,cont,size-cont);
             front = 0;
             last = size - 1;
         }
     }

     public void addFirst(T i)
     {
         while(size >= items.length)
             resize(size * 2);
         front = (front - 1 + items.length) % items.length;
         items[front] = i;
         size += 1;
     }

     public void addLast(T i)
     {
         while(size >= items.length)
         {
             resize(size *2);
         }

         last = (last + 1) % items.length;
         items[last] = i;
         size += 1;
     }

     public T removeFirst()
     {
         if(size == 0)
             return null;
         while(2 * size  <= items.length)
             resize(size / 2);
         T del = items[front];
         items[front] = null;
         front = (front + 1) % items.length;
         size -= 1;
         return del;
     }

     public T removeLast()
     {
         if(size == 0)
             return null;
         while(2 * size  <= items.length)
             resize(size / 2);
         T del = items[last];
         items[last] = null;
         front = (last - 1  + items.length) % items.length;
         size -= 1;
         return del;

     }

     public boolean isEmpty()
     {
         if(size == 0)
             return true;
         else
             return false;
     }

     public int size()
     {
         return size;
     }

     public void printDeque()
     {
         for(int i = 0;i<size;i++)
             System.out.println(items[(front + i) % items.length] + " ");
         System.out.println("\n");
     }

     public T get(int index)
     {
         return items[(front + index) % items.length];
     }

}
