import java.util.*;

public class SlidingWindowMaximum {
    
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        // Deque to store indices of elements. Elements are in decreasing order.
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            
            // Remove elements smaller than the current element from the deque
            // as they cannot be the maximum if the current element is bigger.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // Add current index to the deque
            deque.offer(i);
            
            // When we have processed at least 'k' elements, record the result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        
        int[] result = maxSlidingWindow(nums, k);
        System.out.println("Sliding Window Maximum: " + Arrays.toString(result));
    }
}
