from itertools import combinations


def solution(nums):
    answer = list(combinations(nums, 3))
    cnt = 0
    for x in map(sum, answer):
        for i in range(2, x):
            if x % i == 0:
                break
            elif x-1 == i:
                cnt += 1
    return cnt
