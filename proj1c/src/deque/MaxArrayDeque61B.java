package deque;

import net.sf.saxon.om.Item;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MaxArrayDeque61B <Item>implements Deque61B<Item>{
    private Item[] array;
    private int size;
    private int capacity;
    private int head;
    private int tail;
    private static final int CAPACITY = 8;
    public MaxArrayDeque61B(){
        array = (Item[])new Object[CAPACITY];
        size=0;
        capacity=CAPACITY;
        head=0;
        tail=0;
    }
    public MaxArrayDeque61B(Comparator<Item>c){
    }
    public Item max(){
        return null;
    }
    public Item max(Comparator<Item>c){
        return null;
    }
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
            tail=Math.floorMod(tail+1,capacity);
        }
        head=Math.floorMod(head-1,capacity);
        size++;

    }

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
        }
        tail=Math.floorMod(tail+1,capacity);
        size++;

    }

    @Override
    public List<Item> toList() {
        List<Item> list=new ArrayList<>();
        if(size==0){
            return list;
        }
        int index=Math.floorMod(head+1,capacity);
        int i=0;
        do {
            list.add(array[index]);
            index = Math.floorMod(index + 1, capacity);
        } while (index != tail);
        return list;

    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

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

    @Override
    public Item get(int index) {
        int Index=Math.floorMod(index+head+1,capacity);
        return array[Index];
    }

    @Override
    public Item getRecursive(int index) {
        return null;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator<Item> {
        private int wizPos;
        public ArrayIterator() {
            wizPos=0;
        }
        @Override
        public boolean hasNext() {
            return wizPos<size;
        }

        @Override
        public Item next() {
            Item item=get(wizPos);
            wizPos++;
            return item;
        }
    }
    @Override
    public boolean equals(Object o) {
        if(o==this){
            return true;
        }
        if(o instanceof MaxArrayDeque61B<?>o1){
            if(o1.size!=size){
                return false;
            }
            for(int i=0;i<size;i++){
                if(o1.get(i)!=this.get(i)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        if(size==0){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int i=0;i<size-1;i++){
            sb.append(get(i).toString());
            sb.append(",");
        }
        sb.append(get(size-1).toString());
        sb.append("]");
        return sb.toString();
    }
}
