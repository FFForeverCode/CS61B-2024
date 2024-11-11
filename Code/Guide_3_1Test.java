import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Guide_3_1Test {

    @Test
    void equal_Array() {
        int []a={1,2};
        int[]b={1,2};
        assertArrayEquals(a,b);
        int[]input1={1,2,3,4};
        int[]input2={1,2,3,4};
        int[]input3={1,2,3,5};
        int[]input4={1,2,3,6};
        int[]input5={1,2,3,7};
        boolean expected1=true,
                expected2=false,
                expected3=false,
                expected4=false,
                expected5=false;
        boolean actual1=Guide_3_1.Equal_Array(input1,input2);
        boolean actual2=Guide_3_1.Equal_Array(input1,input3);
        boolean actual3=Guide_3_1.Equal_Array(input1,input4);
        boolean actual4=Guide_3_1.Equal_Array(input1,input5);
        boolean actual5=Guide_3_1.Equal_Array(input1,input5);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertEquals(expected5, actual5);


    }
}