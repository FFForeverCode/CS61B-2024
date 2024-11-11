import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortTest {

    @Test
    public void sort() {
        int[]input={1,23,4,53,5,3,432,523,10};
        int[]expected={1,3,4,5,10,23,53,432,523};
        Sort.sort(input);
        assertArrayEquals(expected,input);

    }


    @Test
    public void swap() {
        int[] input={1,23,4,53,5,3,432,523,10};
        int a=1;
        int b=2;
        Sort.Swap(input,a,b);
        int[]expected={1,4,23,53,5,3,432,523,10};
        assertArrayEquals(expected,input);
    }

    @Test
    @DisplayName("Find the index of the smallest element")
    public void findSmallest() {
        int[]input={1,4,25,5,3,2,532,23,32,5};
        int actual_Index=Sort.findSmallest(input,0);
        int expected_Index =0;
        assertEquals(actual_Index, expected_Index);

    }

    @Test
    public void sort_recursive() {
        int[]input={1,2,3,23,42,9,4};
        int[]expected={1,2,3,4,9,23,42};
        Sort.sort_recursive(input,0);
        assertArrayEquals(expected,input);
    }
}