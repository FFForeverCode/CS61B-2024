import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Iteration {
    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        for (Integer i : list) {
            System.out.println(i);

        }
        //上述代码==下述代码
        Iterator<Integer>iterator=list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //Set也具有迭代器
        HashSet<Integer>set=new HashSet<>();
        set.add(1);
        set.add(12);
        set.add(13);
        for (Integer i : set) {
            System.out.println(i);

        }
    }
}
