import java.util.Comparator;

public class Dog implements CompareTo,Comparable<Dog> {
    public int size;
    public String name;
    public Dog(int size, String name) {
        this.size = size;
        this.name = name;
    }
    public Dog(){
    }
    //在类中 为了实现多种比较功能，创建不同的内类 implements Comparator接口
    // 以达到不同的功能重写其方法

    /**
     * 接口 Comparator比较器  实现名字的比较
     */
    public static  class NameComparator implements Comparator<Dog> {//static 静态 不用实例化狗即可用 比较方法

        @Override
        public int compare(Dog o1, Dog o2) {//可以接受两个 Object 因此 可以用作静态工具 实现不同的多次比较
           return  o1.name.compareTo(o2.name);
        }
    }
    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }
    public static Comparator<Dog> getSizeComparator() {
        return new SizeComparator();
    }
    public static class SizeComparator implements Comparator<Dog>{

        @Override
        public int compare(Dog o1, Dog o2) {
            return o1.size-o2.size;
        }
    }
    @Override
    public int compare(Object o1) {
        Dog d = (Dog) o1;
       if(d.size == this.size){
           return 0;
       }else if(d.size > this.size){
           return -1;
       }else{
           return 1;
       }
    }

    @Override
    public int compareTo(Dog o) {
        return this.size - o.size;
    }

}
