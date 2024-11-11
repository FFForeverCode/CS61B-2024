/**
 * @author KiKidog
 * @date 2024/8/4
 */

import java.rmi.server.RemoteObjectInvocationHandler;
import java.util.Comparator;

/**
 * 1.实现二叉树的基本功能
 * 2.实现优先级队列堆的要求:1.节点比左右节点都小 2.完整的 优先左节点
 * 3.二叉树的实现方法选择:使用数组实现树
 */
//实现泛型接口时需要指定其泛型的数据类型,若未知则设为Object
public class minHeap implements min_Heap<Object>, Comparator {

    private Object[]keys;//键 存储值
    private int[]parents;//存储当下索引的父索引
    private int CAPACITY = 20;
    private  int size;
    public minHeap(){
        size = 0;
        keys = new Object[CAPACITY];
        parents = new int[CAPACITY];
        keys[0] = null;//使得第一个为空,便于计算
        setParents(parents);
    }

    public minHeap(Object[] keys, int[] parents, int size) {
        this.keys = keys;
        this.parents = parents;
        this.size = size;
    }

    public minHeap(Object[] keys, int[] parents, int CAPACITY, int size) {
        this.keys = keys;
        this.parents = parents;
        this.CAPACITY = CAPACITY;
        this.size = size;
    }


    private void setPosition() {
        int current = this.size;
        int com = compare(keys[current], keys[parents[current]]);
        while (current > 1 && com <0 ) {
           Object tmp = keys[current];
           keys[current] = keys[parents[current]];
           keys[parents[current]] = tmp;
           current = parents[current];
           com = compare(keys[current], keys[parents[current]]);
        }
    }

    /**
     * 获取右子节点索引
     * @return 返回右子节点的索引
     */
    public int rightChild(int k){
        return k*2;
    }

    /**
     * 获取左子节点索引
     * @return return the index of left
     */
    public int leftChild(int k){
        return k*2+1;

    }

    /**
     * 设置父节点的索引值
     * @param parents 存储父节点的数组
     */
    public void setParents(int[]parents){
        for (int i = 0; i < parents.length; i++) {
            parents[i]=(int) Math.floor(i / 2);
        }
    }

    /**
     * 添加元素
     * 首先将元素置于堆尾,然后逐级找到合适的位置
     * @param o 添加的元素
     */
    @Override
    public void add(Object o) {

        keys[size+1] = o;
        ++size;
        setPosition();
    }

    /**
     * 获取最小的元素 即第一个索引处的元素
     * @return 返回最小的元素
     */
    @Override
    public Object getSmallest() {
        return keys[1];
    }

    /**
     * 删除最小的元素 即第一个元素
     * 将堆尾部的元素覆盖根部,然后逐级找到合适的位置
     * @return 返回最小的元素
     */
    @Override
    public Object removeSmallest() {
        if(size==0){
            throw new Error("The heap is Empty!");
        }
       Object Smallest = keys[1];
       keys[1] = keys[size];
       keys[size] = null;
       --size;
       heaplify();
       return Smallest;
    }


    private void heaplify(){
        int current = 1;
        int leftIndex = leftChild(current);
        int rightIndex = rightChild(current);
        while(canSwap(current,leftIndex,rightIndex)) {
            if(keys[leftIndex]!=null&&keys[rightIndex]!=null){
                if(compare(keys[current],keys[leftIndex])>0){
                    Object tem = keys[current];
                    keys[current] = keys[leftIndex];
                    keys[leftIndex] = tem;
                    current = leftIndex;
                }else{
                    Object tem = keys[current];
                    keys[current] = keys[rightIndex];
                    keys[rightIndex] = tem;
                    current = rightIndex;
                }
            }else{
                Object tem = keys[leftIndex];
                keys[leftIndex] = keys[current];
                keys[current] = tem;
                current = leftIndex;
            }
            leftIndex = leftChild(current);
            rightIndex = rightChild(current);
        }
    }
    private boolean canSwap(int current,int leftIndex,int rightIndex){
        if(keys[current]!=null&&keys[leftIndex]!=null){
            int com1 = compare(keys[current],keys[leftIndex]);
            if(com1>0){
                return true;
            }else return keys[rightIndex] != null && compare(keys[current], keys[rightIndex]) > 0;
        }
        return false;
    }
    public void reSize(){
        if(CAPACITY==size+1){
           CAPACITY*=2;
           int[]newParents = new int[CAPACITY];
           Object[]newKeys = new Object[CAPACITY];
           newParents[0] = 0;
           newKeys[0] = null;
            for (int i = 1; i < size+1; i++) {
                newParents[i] = parents[i];
                newKeys[i] = keys[i];
            }
            keys = newKeys;
            parents = newParents;
        }
    }

    @Override
    public Object deleteItem() {
        return null;
    }

    /**
     * To Travel the array of keys
     */
    public  void TravelKeys(){
        for (int i = 1; i < size+1; i++) {
            System.out.println(keys[i]);
        }
    }

    public static void main(String[] args) {
    }

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.<p>
     * <p>
     * The implementor must ensure that {@link Integer#signum
     * signum}{@code (compare(x, y)) == -signum(compare(y, x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * compare(x, y)} must throw an exception if and only if {@code
     * compare(y, x)} throws an exception.)<p>
     * <p>
     * The implementor must also ensure that the relation is transitive:
     * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies
     * {@code compare(x, z)>0}.<p>
     * <p>
     * Finally, the implementor must ensure that {@code compare(x,
     * y)==0} implies that {@code signum(compare(x,
     * z))==signum(compare(y, z))} for all {@code z}.
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     * @throws NullPointerException if an argument is null and this
     *                              comparator does not permit null arguments
     * @throws ClassCastException   if the arguments' types prevent them from
     *                              being compared by this comparator.
     * @apiNote It is generally the case, but <i>not</i> strictly required that
     * {@code (compare(x, y)==0) == (x.equals(y))}.  Generally speaking,
     * any comparator that violates this condition should clearly indicate
     * this fact.  The recommended language is "Note: this comparator
     * imposes orderings that are inconsistent with equals."
     */
    /**
     * 按照HashCode来比较大小
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return if the ASCII of o1 is bigger than o2's
     * return positive integer or negative integer or return 0
     * when the both are equal
     */
    @Override
    public int compare(Object o1, Object o2) {
        if(o1==null){
            throw new IllegalArgumentException("The Object is null");
        }
        if(o2 == null){
            return 0;
        }
        if(o1 instanceof Integer o3 && o2 instanceof Integer o4){
            return o3 - o4;
        }else if(o1 instanceof Character o3
                && o2 instanceof Character o4){
            return (int)o3-(int)o4;
        }else{
            return o1.hashCode() - o2.hashCode();
        }
    }

    /**
     * 获取
     *
     * @return keys
     */
    public Object[] getKeys() {
        return keys;
    }

    /**
     * 设置
     * @param keys
     */
    public void setKeys(Object[] keys) {
        this.keys = keys;
    }

    /**
     * 获取
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * 设置
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    public String toString() {
        return "minHeap{keys = " + keys + ", parents = " + parents + ", CAPACITY = " + CAPACITY + ", size = " + size + "}";
    }

    /**
     * 获取
     * @return parents
     */
    public int[] getParents() {
        return parents;
    }

    /**
     * 获取
     * @return CAPACITY
     */
    public int getCAPACITY() {
        return CAPACITY;
    }

    /**
     * 设置
     * @param CAPACITY
     */
    public void setCAPACITY(int CAPACITY) {
        this.CAPACITY = CAPACITY;
    }
}
