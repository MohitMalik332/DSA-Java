import java.util.*;

public class _01_TwoSumSorted {
    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int sum = nums[left] + nums[right];

            if (sum == target){
                return new int[]{left, right};
            }
            else if (sum < target){
                left++;
            }
            else{
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}