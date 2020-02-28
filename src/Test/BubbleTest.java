package Test;

import static org.junit.jupiter.api.Assertions.*;

import Main.BubbleSortRecursive;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class BubbleTest {
    public List<Integer> testList = new ArrayList<>();
    public List<Integer> finalList = new ArrayList<>();

    @Test
    public void testSort() {
        testList.add(31);
        testList.add(991);
        testList.add(551);
        testList.add(11);
        testList.add(3);
        testList.add(99);
        testList.add(55);
        testList.add(1);
        System.out.println(testList);
        finalList = BubbleSortRecursive.checkPairs(testList);

        for (int i = 0; i < finalList.size() - 1; i++) {
            assertTrue(finalList.get(i) <= finalList.get(i+1));
        }
    }

}