import itertools

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        answer = []    
        nums.sort()

        for i in itertools.combinations(nums, 3):
            if sum(i) == 0:
                answer.append(i)
        return (list(set(answer)))