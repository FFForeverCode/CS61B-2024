import javax.xml.transform.Source;
import java.util.ArrayList;

public class List {
    public static class VengefulSLList<T> extends ArrayList<T> implements method{
        ArrayList<T>deletl;
        public VengefulSLList() {
            deletl=new ArrayList<>();
        }
        public T removeLast(){
            T oldItem=super.remove(super.size()-1);
            deletl.add(oldItem);
            return oldItem;
        }
        public void PrintLostItem(){
            for (T t : deletl) {
                System.out.print(t+" ");
            }
        }

        @Override
        public void print() {

        }
    }

    public static void main(String[] args) {
        VengefulSLList<Integer>l1=new VengefulSLList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.removeLast();
        l1.removeLast();
        l1.removeLast();
        l1.PrintLostItem();
        System.out.println(l1.toString());

    }
}
