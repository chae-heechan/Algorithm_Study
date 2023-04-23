import numpy


class Assignment:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        answer = numpy.ones(len(nums))
        answer = answer.astype(int)

        for i, v in enumerate(nums):
            temp = answer[i]
            answer = answer * v
            answer[i] = temp

        return list(answer)
