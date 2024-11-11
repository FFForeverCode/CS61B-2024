public class Guide_3_1 {

    public static boolean Equal_Array(int []arr1, int[]arr2){
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}
