import java.util.Arrays;
import java.util.Comparator;

/**
 * @author KiKidog
 * @date 2024/7/1
 */
public class _15AII {
        public static void main(String[] args) {
            /**
             * 二维数组
             */
            int[][]arr={{1,2},{3,4},{5,6,7,2},{1,0,21,29,20},{12,1,2,34,21}};
            System.out.println(arr.length);//行数
            System.out.println(arr[0].length);//0行的列数
            System.out.println(Arrays.toString(arr[0]));//将数组转变为字符串
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });//将数组按照每行第一个数的大小升序排序
            /**
             * 二分查找法
             * 时间复杂度 log n
             *
             */
            int[]arr1={1,9,3,4,5,2,6,10,25};
            System.out.println(binarySearch(arr1, 0, arr.length - 1, 5));
            /**
             * 选择排序
             * 时间复杂度 n^2
             */
            /**
             * 在Java中，参数传递方式统一为值传递（pass by value），
             * 而不是像一些其他编程语言（如C++）那样可以选择值传递或引用传递（地址传递）。
             *
             * 值传递（Pass by Value）
             * Java中的值传递意味着方法调用时，实际参数的值（也就是变量中存储的值）
             * 被复制给对应的形式参数。这意味着，方法内部对形式参数的修改不会影响到实际参数的值，
             * 因为实际参数和形式参数是两个不同的变量，存储在不同的内存空间中
             */
            int[]arr2={1,9,3,4,5,2,6,10,25,23};
            SelectSort(arr2);
            System.out.println(Arrays.toString(arr2));

            /**
             * 归并排序
             * 时间复杂度 nlog n
             */
            int[]arr3={1,2,6,12,3,26,7,10};
            mergeSort(arr3);
            System.out.println(Arrays.toString(arr3));


        }
        public static void SelectSort(int[]arr){
            for(int i=0;i<arr.length-1;i++){
                int min=i;
                for(int k=i+1;k<arr.length;k++){
                    if(arr[k]<arr[min]){
                        min=k;
                    }
                }
                int tmp=arr[min];
                arr[min]=arr[i];
                arr[i]=tmp;
            }

        }
        public static int binarySearch(int[]arr1,int left,int right,int find){
            if(left>right){
                return -1;
            }
            int mid=left+(right-left)/2;
            int m=arr1[mid];
            if(m>find) {
                return binarySearch(arr1,left,m-1,find);
            }else if(m<find) {
                return binarySearch(arr1,m+1,right,find);
            }else {
                return mid;
            }
        }

        /**
         * 合并排序
         * @param array
         */
        //时间复杂度为 （nlog n）
        //主方法 归并排序
        public static void mergeSort(int[]array){
            if(array==null||array.length<=1){
                return;
            }
            sort(array,0,array.length-1);
        }
        //排序递归方法
        public static void sort(int[]array,int left,int right){
            if(left < right){//直至一个节点
                int mid=left+(right-left)/2;
                sort(array,left,mid);//将左半部分进行排序
                sort(array,mid+1,right);//将右半部分进行排序
                merge(array,left,mid,right);//合并左右两部分
            }
        }
        //合并方法
        public static void merge(int[]array,int left,int mid,int right){
            int n1 = mid-left+1;
            int n2 = right - mid;
            int[]L=new int[n1];
            int[]R=new int[n2];
            for(int i=0;i<n1;i++){
                L[i]=array[left+i];
            }
            for(int j=0;j<n2;j++){
                R[j]=array[mid+1+j];
            }
            int i=0,j=0;
            int k=left;
            while(i<n1&&j<n2){
                if(L[i]<=R[j]){
                    array[k]=L[i];
                    i++;
                }else{
                    array[k]=R[j];
                    j++;
                }
                k++;
            }
            while(i<n1){
                array[k++]=L[i++];
            }
            while(j<n2){
                array[k++]=R[j++];
            }
        }
    }

