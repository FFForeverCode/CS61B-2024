import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T>implements Deque61B<T>{

    public Node sentinel;
    private int size;
    public class Node{
        private T data;
        private Node next;
        private Node prev;
        public Node(){
        }
        public Node(T data,Node next,Node pre){
            this.data=data;
            this.next=next;
            prev=pre;
        }
    }
    public LinkedListDeque61B(){
        sentinel=new Node();
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
        size=0;
    }
    @Override
    public void addFirst(T x) {
        Node p=new Node(x,sentinel.next,sentinel);
        sentinel.next.prev=p;
        sentinel.next=p;
        size++;
    }

    @Override
    public void addLast(T x) {
     Node p=new Node(x,sentinel,sentinel.prev);
     sentinel.prev.next=p;
     sentinel.prev=p;
     size++;

    }

    @Override
    public List<T> toList() {
        List<T>returnList=new ArrayList<>();
        Node p=sentinel;
        while(p.next!=sentinel){
            returnList.add(p.next.data);
            p=p.next;
        }
        return returnList;
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
    public T removeFirst() {
        if(size==0){
            return null;
        }
        Node p=sentinel.next;
        sentinel.next= p.next;
        p.next.prev=sentinel;
        p.next=null;
        p.prev=null;
        return p.data;

    }

    @Override
    public T removeLast() {
        if(size==0){
            return null;
        }
        Node p=sentinel.prev;
        sentinel.prev=p.prev;
        p.prev.next=sentinel;
        p.next=null;
        p.prev=null;
        return p.data;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("The method is useless");
    }

}
