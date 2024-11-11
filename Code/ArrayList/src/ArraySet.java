import net.sf.saxon.om.GroundedValue;
import net.sf.saxon.om.Item;
import net.sf.saxon.om.SequenceIterator;
import org.apache.commons.collections.iterators.ArrayIterator;

import java.util.Iterator;

public class ArraySet <T>{
    private T[]items;
    private int size;
    public ArraySet(){
        items=(T[]) new Object[100];
        size=0;
    }
    public boolean contains(T x){
        for (int i = 0; i < size; i++) {
            if(items[i].equals(x)){
                return true;
            }
        }
        return false;
    }
    public void add(T x){
        if(x==null){
            throw new NullPointerException();
        }
        if(contains(x)){
            return;
        }
        items[size++]=x;
    }
    public int size(){
        return size;
    }
    public Iterator<T>iterator(){
        return new ArraySetIterator();
    }
    public class ArraySetIterator implements Iterator<T>{
        private int wizPos;
        public ArraySetIterator(){
            wizPos=0;
        }
        @Override
        public boolean hasNext() {
            return wizPos<size;
        }

        @Override
        public T next() {
            T returnItem=items[wizPos];
            wizPos++;
            return returnItem;
        }
    }
    @Override
    public String toString(){
       StringBuilder stb=new StringBuilder();
       stb.append("{");
       for (int i = 0; i < size-1; i++) {
           stb.append(items[i].toString());
           stb.append(",");
       }
       stb.append(items[size-1].toString());
       stb.append("}");
       return stb.toString();
    }
    @Override
    public boolean equals(Object o1){
        if(o1==null){
            return false;
        }
        ArraySet<T>arr1=(ArraySet<T>)o1;
        if(((ArraySet<?>) o1).size==this.size){
            return true;
        }

        return false;
    }

}
