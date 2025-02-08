# Sliding-Window-Maximum
Given an array of integers nums and an integer k, return an array representing the maximum value in each sliding window of size k moving from left to right.  A sliding window is a contiguous subarray of size k. The goal is to compute the maximum element within each such window.
Explanation:
Deque Usage:
The deque stores indices of array elements and ensures that the indices are in decreasing order of the corresponding values in nums.

Window Maintenance:

Before processing the current element at index i, we remove indices from the front of the deque that are no longer in the current window (i.e., indices less than i - k + 1).
Then, we remove all indices from the back whose corresponding values are less than nums[i], because they will not be needed as nums[i] is a better candidate for the maximum.
Recording Results:

Once the first window is complete (when i >= k - 1), the element at the front of the deque is the maximum for that window.
We record that in the result array and continue this process until the end of the array.
