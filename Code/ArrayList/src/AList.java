public class AList <T>{
    private T[]arr;
    private  int size;
    private int length;
    public AList(){
        size=0;
        length=100;
        arr= (T[]) new Object[length];
    }
    public void resize(int length){
        T[] newarr= (T[]) new Object[length];
        System.arraycopy(arr,0,newarr,0,size);
        arr=newarr;
    }
    public double REFACTOR(){
        return (double)size/length;
    }
    public void addLast(T item){
        double r=REFACTOR();
        if(size==length) {
          length= (int) (length*r)*2;
            resize(length);
        }
        arr[size++]=item;
    }
    public int length(){
        return length;
    }
    public T getLast(){
        return arr[size-1];
    }
    public int size(){
        return size;
    }
    public T removeLast(){
        T item=arr[--size];
        arr[size]= null;
        return item;
    }
    public void Travelarr(){
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }



}
