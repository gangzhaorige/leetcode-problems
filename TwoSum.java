import java.util.*
;
public class TwoSum{
    /*
        Unsorted array
        Brute Force
        Find all pairs that sums to the target
        Time O(n^2)
        Space O(1) 
    */
    public static int[] twoSumBruteForce(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
    /*
        Unsorted array
        Optimized Solution HashMap
        Sacrafice space to reduce time
        Time O(n)
        Space O(n) 
    */
    public static int[] twoSumHashMap(int[] nums, int target){
        // Mapping Value with its index
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            int curNumber = nums[i];
            int otherNumber = target - curNumber;
            // if map does not have the other number put the current number inside and continue;
            if(!map.containsKey(otherNumber)){
                map.put(curNumber, i);
            } else{
                result[0] = i;
                result[1] = map.get(otherNumber);
                return result;
            }
        }
        return new int[0];
    }
    /*
        Sorted array
        Two Pointers
        Time O(n)
        Space O(1) 
    */
    // 1 5 8 9      target 13
    public static int[] twoSumSorted(int[] nums, int target){
        int[] result = new int[2];
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while(leftIndex < rightIndex){
            int curSum = nums[leftIndex] + nums[rightIndex];
            if(curSum == target){
                result[0] = leftIndex;
                result[1] = rightIndex;
                return result;
            } else if (curSum < target){
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumSorted(new int[]{1,3,4,5,8}, 8)));
    }
}