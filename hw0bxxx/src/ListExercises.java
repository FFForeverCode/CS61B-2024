import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int sum=0;
        for (Integer i : L) {
            sum+=i;
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> even=new ArrayList<Integer>();
        for (Integer i : L) {
            if(i%2==0){
                even.add(i);
            }
        }
        return even;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        HashMap<Integer,Integer>map=new HashMap<>();
        List<Integer>list=new ArrayList<>();
        for (Integer i : L1) {
            map.put(i,1);

        }
        for (Integer i : L2) {
            if(map.containsKey(i)){
                list.add(i);
            }
        }
        return list;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int sum=0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if(word.charAt(i)==c){
                    sum++;
                }
            }
        }
        return sum;
    }
}
