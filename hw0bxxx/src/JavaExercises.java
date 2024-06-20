import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaExercises {

    /**
     * Returns an array [1, 2, 3, 4, 5, 6]
     */
    public static int[] makeDice() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        return arr;
    }

    /**
     * Returns the order depending on the customer.
     * If the customer is Ergun, return ["beyti", "pizza", "hamburger", "tea"].
     * If the customer is Erik, return ["sushi", "pasta", "avocado", "coffee"].
     * In any other case, return an empty String[] of size 3.
     */
    public static String[] takeOrder(String customer) {
        Map<String, String[]> map = new HashMap<String, String[]>();
        String[] order1 = {"beyti", "pizza", "hamburger", "tea"};
        String[] order2 = {"sushi", "pasta", "avocado", "coffee"};
        map.put("Ergun", order1);
        map.put("Erik", order2);
        if (map.containsKey(customer)) {
            return map.get(customer);
        }
        return new String[3];
    }

    /**
     * Returns the positive difference between the maximum element and minimum element of the given array.
     * Assumes array is nonempty.
     */
    public static int findMinMax(int[] array) {
        int min = array[0], max = array[0];
        for (int i : array) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        return max - min;
    }

    /**
     * Uses recursion to compute the hailstone sequence as a list of integers starting from an input number n.
     * Hailstone sequence is described as:
     * - Pick a positive integer n as the start
     * - If n is even, divide n by 2
     * - If n is odd, multiply n by 3 and add 1
     * - Continue this process until n is 1
     */
    public static List<Integer> hailstone(int n) {
        List<Integer>list=new ArrayList<>();
        return hailstoneHelper(n,list);
    }

    private static List<Integer> hailstoneHelper(int x, List<Integer> list) {
        if(x==1){
            list.add(1);
            return list;
        }else{
            if(x%2==0){
                list.add(x);
                x/=2;
                return hailstoneHelper(x,list);
            }else{
                list.add(x);
                x=x*3+1;
                return hailstoneHelper(x,list);
            }
        }
    }
}

