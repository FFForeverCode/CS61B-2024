import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AListTest {

    @Test
    public void resize() {
        AList<Integer>arr=new AList<>();
        extracted(arr);
        int expected=7;
        int actual = arr.size();
        assertEquals(expected,actual);
    }

    @Test
    public void REFACTOR() {
        AList<Integer>arr=new AList<>();
        extracted(arr);

        double actual=arr.REFACTOR();
        double expected= (double) arr.size() /arr.length();
        assertEquals(expected, actual);
        extracted1(arr);
        double actual2=arr.REFACTOR();
        double expected2= (double) arr.size() /arr.length();
        assertEquals(expected2, actual2);

    }
    @Test
    public void addLast() {
        AList<Integer>arr1=new AList<>();
        arr1.addLast(20);
        int actual=arr1.getLast();
        int expected=20;
        assertEquals(expected, actual);

    }

    @Test
    public void getLast() {
        AList<Integer>arr1=new AList<>();
        arr1.addLast(20);
        arr1.addLast(40);
        int actual=arr1.getLast();
        int expected=40;
        assertEquals(expected, actual);

    }

    @org.junit.jupiter.api.Test
    void size() {
        AList<Integer>arr1=new AList<>();
        extracted(arr1);
        int actual=arr1.size();
        int expected=7;
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void removeLast() {
        AList<Integer>arr1=new AList<>();
        extracted(arr1);
        int actual=arr1.removeLast();
        int expected=30;
        assertEquals(expected,actual);


    }
    @Test
    public void Travelarr(){
        AList<Integer>arr1=new AList<>();
        extracted(arr1);
        String expected="10 10 10 10 10 10 30";
        System.out.println("expected:"+expected);
        System.out.print("actual  :");
        arr1.Travelarr();
    }
    public static void extracted(AList<Integer> arr) {
        arr.addLast(10);
        arr.addLast(10);
        arr.addLast(10);
        arr.addLast(10);
        arr.addLast(10);
        arr.addLast(10);
        arr.addLast(30);
    }
    public static void extracted1(AList<Integer> arr) {
        arr.addLast(10);
        arr.addLast(10);
        arr.addLast(10);
        arr.addLast(10);
        arr.addLast(10);
        arr.addLast(10);
        arr.addLast(10);
        arr.addLast(10);
        arr.addLast(10);
        arr.addLast(10);
        arr.addLast(30);

    }
}
