import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 循环数组实现双向链表 使得链表头尾添加元素删除元素均为O(1);
 * @param <Item>
 */
public class ArrayDeque61B<Item>implements Deque61B<Item> {


            private Item[] array;
            private int size;
            private int capacity;
            private int head;//头节点 指向头部将要插入的索引
            private int tail;//尾节点 指向尾部将要插入的节点
            private static final int CAPACITY = 8;
            public ArrayDeque61B(){
                array = (Item[])new Object[CAPACITY];
                size=0;
                capacity=CAPACITY;
                head=0;
                tail=0;
            }

    /**
     * 改变数组的大小 容量
     * @param newCapacity 数组改变后的新容量大小
     */
    public void resize(int newCapacity){
                Item[] newArray = (Item[])new Object[newCapacity];
                int index=Math.floorMod(head-1,capacity);
                int i=0;
                do {
                    newArray[i++] = array[index];
                    index = Math.floorMod(index + 1, capacity);
                } while (index != tail);
                tail=size-1;
                head=0;
                array = newArray;
                capacity=newCapacity;
            }

    /**
     * 在头部插入新的节点
     * @param x item to add
     */
    @Override
            public void addFirst(Item x) {
                if(x==null){
                    throw new NullPointerException("The item is null");
                }
                if(size==capacity){
                    resize(2*capacity);
                    capacity=capacity*2;
                }
                array[head]=x;
                if(size==0){
                    tail=Math.floorMod(tail+1,capacity);//若为初始状态，由于tail指向尾节点将要插入的索引，所以tail要指向初始的下一个索引
                }
                head=Math.floorMod(head-1,capacity);//head 节点改变
                size++;

            }

    /**
     * 在尾部插入新的节点
     * @param x item to add
     */
    @Override
            public void addLast(Item x) {
                if(x==null){
                    throw new NullPointerException("The item is null");
                }
                if(size==capacity){
                    resize(2*capacity);
                }
                array[tail]=x;
                if(size==0){
                    head=Math.floorMod(head-1,capacity);
                    //初始状态head 与 tail 指向同一个节点0
                    // 插入节点后 head应指向头节点应插入的索引
                    //因此要-1 取模
                }
                tail=Math.floorMod(tail+1,capacity);
                size++;

            }

    /**
     * 将数组按照索引 head->tail 存储到list中
     * @return 返回存储数组链表值的链表
     */
    @Override
            public List<Item> toList() {
                List<Item> list=new ArrayList<>();
                if(size==0){
                    return list;
                }
                int index=Math.floorMod(head+1,capacity);//头节点索引
                int i=0;
                do {
                    list.add(array[index]);
                    index = Math.floorMod(index + 1, capacity);
                } while (index != tail);
                return list;

            }

    /**
     * 判断数组链表是否为空
     * @return 空返回true 反之返回false
     */
    @Override
            public boolean isEmpty() {
                return size==0;
            }

    /**
     * 得到数组链表的size
     * @return 返回其大小
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 删除头节点
     * @return 返回删除的头节点的值
     */
    @Override
    public Item removeFirst() {
        if(isEmpty()){
            return null;
        }
        int index=Math.floorMod(head+1,capacity);
        Item item=array[index];
        array[index]=null;
        size--;
        head=index;
        return item;
    }

    /**
     * 删除尾节点
     * @return 返回删除的尾节点的值
     */

    @Override
    public Item removeLast() {
        if(isEmpty()){
            return null;
        }
        int index=Math.floorMod(tail-1,capacity);
        Item x=array[index];
        array[index]=null;
        size--;
        tail=index;
        return x;

    }

    /**
     *
     * @param index index to get
     * @return 获取索引的值
     */
    @Override
    public Item get(int index) {
        int Index=Math.floorMod(index+head+1,capacity);
        return array[Index];
    }

    /**
     * 递归获取
     * @param index index to get
     * @return 索引的值
     */
    @Override
    public Item getRecursive(int index) {
        return null;
    }
}
