class Solution:
    def mySqrt(self, x: int) -> int:
        if x < 2:  # Handle edge cases for 0 and 1
            return x
        
        left, right = 0, x
        
        while left <= right:
            mid = (left + right) // 2
            if mid * mid == x:
                return mid
            elif mid * mid < x:
                left = mid + 1
            else:
                right = mid - 1
        
        return right  # When left > right, return the largest integer less than or equal to the square roo
