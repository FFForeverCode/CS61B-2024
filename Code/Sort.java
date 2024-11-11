public class Sort {
    public static void sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min=findSmallest(arr,i);
            Swap(arr,i,min);
        }
    }
    public static void sort_recursive(int[]arr,int i){
        if(i==arr.length-1){
            return;
        }
        int min=findSmallest(arr,i);
        Swap(arr,i,min);
        sort_recursive(arr,i+1);
    }
    public static int findSmallest(int[] arr,int i){
       int min=i;
       for(int j=i+1;j<arr.length;j++){
           if(arr[j]<arr[min]){
               min=j;
           }
       }
       return min;
    }
    public static void Swap(int[]arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
