package deque;


public class MaxArrayDeque<T> extends ArrayDeque<T>
{

    private Comparator<T> nc;

    public MaxArrayDeque(Comparator<T> c)
    {
        super();
        nc = c;
    }

    public T max()
    {
        T maxT = get(0);
        for(int i = 0; i < size(); i++)
        {
            T t = get(i);
            if(nc.compare(t,maxT)>0)
                maxT = t;

        }
        return maxT;
    }

    public T max(Comparator<T> c)
    {
        T maxT = get(0);
        for(int i = 0; i < size(); i++)
        {
            T t = get(i);
            if(c.compare(t,maxT)>0)
                maxT = t;

        }
        return maxT;
    }

    public class NameComparator implements Comparator<Integer>
    {
        @Override
        public int compare(Integer o1, Integer o2)
        {
            return o1-o2;
        }
    }






}
