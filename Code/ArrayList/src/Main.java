public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ArraySet<Integer>arr=new ArraySet<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        System.out.println(arr.toString());
        System.out.println(arr.contains(1));
        System.out.println(arr.size());
    }
}