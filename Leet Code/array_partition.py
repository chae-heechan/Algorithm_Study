class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        nums.sort(reverse = True)
        
        return (sum([i for i in nums[1::2]]))