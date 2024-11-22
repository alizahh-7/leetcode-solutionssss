class Solution:
    def removeElement(self, nums: list[int], val: int) -> int:
        # Pointer to keep track of where to place non-val elements
        k = 0
        
        # Traverse the list
        for i in range(len(nums)):
            # If the current element is not equal to val, move it to the front
            if nums[i] != val:
                nums[k] = nums[i]
                k += 1
        
        # Return the number of elements that are not equal to val
        return k
