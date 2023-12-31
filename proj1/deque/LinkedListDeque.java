package deque;

public class LinkedListDeque<T> implements Deque<T>
{
    public class ListNode
    {
        public T item;
        public ListNode next;
        public ListNode prev;

        public ListNode(T i, ListNode p, ListNode n)
        {
            item = i;
            next = n;
            prev = p;
        }
    }

    private ListNode senfront;
    private ListNode senlast;
    private int size;

    /**Adds an item of type T to the front of the deque. You can assume that item is never null.*/
    public LinkedListDeque()
    {
        senfront = new ListNode(null ,null,null);
        senlast = new ListNode(null,null,null);
        senfront.next = senlast;
        senlast.prev = senfront;
        size = 0;
    }

/*
    public LinkedListDeque(T n)
    {
        senfront = new ListNode(n,null,null);
        senlast = new ListNode(n,null,null);
        senfront.next = new ListNode(n,senfront,senlast);
    }
*/

    @Override
    public void addFirst(T item)
    {
        ListNode newNode = new ListNode(item,senfront,senfront.next);
        senfront.next.prev = newNode;
        senfront.next = newNode;
        size += 1;
    }

    @Override
    public void addLast(T item)
    {
        ListNode newNode = new ListNode(item, senlast.prev,senlast);
        senlast.prev.next = newNode;
        senlast.prev = newNode;
        size += 1;
    }

    @Override
    /**Prints the items in the deque from first to last, separated by a space. Once all the items have been printed, print out a new line.*/
    public boolean isEmpty()
    {
        if(senfront.next == senlast)
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
        ListNode p = senfront;
        while(p.next != null)
        {
            System.out.println(p.item + " ");
            p = p.next;
        }
        System.out.println("\n");
    }

    @Override
    public T removeFirst()
    {
        if(senfront.next != senlast)
        {
            ListNode delNode = senfront.next;
            senfront.next.next.prev = senfront;
            senfront.next = senfront.next.next;
            size -= 1;
            return delNode.item;
        }
        else
            return null;
    }

    @Override
    public T removeLast()
    {
        if(senfront.next != senlast)
        {
            ListNode delNode = senlast.prev;
            senlast.prev.prev.next = senlast;
            senlast.prev = senlast.prev.prev;
            size -= 1;
            return delNode.item;
        }
        else
            return null;
    }

    @Override
    public T get(int index)
    {
        if (size <= index || size == 0)
            return null;
        ListNode p = senfront.next;
        for (int i = 0; i < index; i++)
        {
            p = p.next;
        }
        return p.item;
    }


    private T getRecursive(ListNode N, int index)
    {
        if(index == 0)
            return N.item;
        else
            return getRecursive(N.next, index -1);
    }

    public T getRecursive(int index)
    {
        return getRecursive(senfront.next,index);
    }

    public Iterator<T> iterator()
    {
        return new LinkListDequeIterator();
    }

    @Override
    public boolean equals(Object o )
    {
        if(o == null)
            return false;
        if(o.getClass() != this.getClass())
            return false;
        LinkedListDeque<T> other = (LinkedListDeque<T>) o;
        if(other.size() != this.size())
            return false;
        for(int i = 0; i < size();i+=1)
        {
            if(other.get(i) == this.get(i))
                return false;
        }
        return true;
    }





    private class LinkListDequeIterator implements Iterator<T>
    {
        private int wizpos;

        public LinkListDequeIterator()
        {
            wizpos = 0;
        }

        @Override
        public boolean hasNext()
        {
            return wizpos < size();
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
