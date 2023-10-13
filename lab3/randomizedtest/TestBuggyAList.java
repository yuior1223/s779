package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    AListNoResizing<Integer> L = new AListNoResizing<>();
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> LC = new BuggyAList<>();
        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                LC.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizec = LC.size();
                System.out.println("size: " + size);
            } else if (operationNumber == 2 && L.size() > 0){
                // last
                int lastVal = L.getLast();
                int lastValc = LC.getLast();
                System.out.println("last: " + lastVal);
            } else if (operationNumber == 3 && L.size() > 0){
                int remove = L.removeLast();
                int removec = L.removeLast();
                System.out.println("remove(" + remove + ")");
            }
        }

    }

    // YOUR TESTS HERE
}
