import itertools

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        answer = []
        for i, j in itertools.combinations(nums, 2):
            if (i + j) == target:
                answer.append(nums.index(i))
                nums.remove(i)
                answer.append(nums.index(j)+1)
                break
        
        return answer