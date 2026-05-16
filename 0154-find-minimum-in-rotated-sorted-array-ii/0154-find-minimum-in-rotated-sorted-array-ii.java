class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // minimum is in right half
                left = mid + 1;
            } 
            else if (nums[mid] < nums[right]) {
                // minimum is in left half including mid
                right = mid;
            } 
            else {
                // duplicates, shrink search space
                right--;
            }
        }

        return nums[left];
    }
}