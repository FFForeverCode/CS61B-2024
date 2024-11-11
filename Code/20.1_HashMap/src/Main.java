import java.util.*;

/**
 * @author KiKidog
 * @date 2024/7/28
 */
public class Main {
    /**
     * 获取数组中单调子数组的最长长度(递增、递减都可以)
     * @param nums 数组
     * @return 返回结果
     */
    public static int getLength(int[]nums){
        int right = 1;
        //len 用于记录符合符合条件子数组的长度
        int len = 1;//初始化nums[0]长度为1
        int result = 1;//初始化最短为1
        for(right = 1;right<nums.length;right++){
            //若递增则将result+1(将nums[right]计入),
            //若不是递增的则将result设置为1,表示nums[right]单个长度,重新计数
            len = nums[right-1]<nums[right]?len+1:1;
            result = Math.max(result,len);//记录最长长度
        }
        return result;
    }

    public static void main(String[] args) {
        int[]nums={1,2,3,4,5,2,1,2,3};
        System.out.println(getLength(nums));
    }
}