

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleForming {
    
    public static List<int[]> findTriangleCombinations(int[] nums) {
        List<int[]> combinations = new ArrayList<>();
        
        // Sort the array
        Arrays.sort(nums);
        
        // Fix one element as a[i] and find other two elements
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1; // Initialize left pointer
            int right = nums.length - 1; // Initialize right pointer
            
            while (left < right) {
                // If triplet found, add to combinations
                if (nums[i] + nums[left] > nums[right]) {
                    // If nums[i] + nums[left] > nums[right], then elements after right can also form triangles
                    // Therefore, we add (right - left) combinations to the result
                    for (int k = right; k > left; k--) {
                        combinations.add(new int[]{nums[i], nums[left], nums[k]});
                    }
                    left++; // Increment left pointer
                } else {
                    right--; // Decrement right pointer
                }
            }
        }
        
        return combinations;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 7, 8, 9};
        List<int[]> triangleCombinations = findTriangleCombinations(nums);
        
        if (triangleCombinations.isEmpty()) {
            System.out.println("No triangle can be formed with the given elements.");
        } else {
            System.out.println("Triangles can be formed with the following combinations:");
            for (int[] combination : triangleCombinations) {
                System.out.println(Arrays.toString(combination));
            }
        }
    }
}
