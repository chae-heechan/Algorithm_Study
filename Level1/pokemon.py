import collections


def solution(nums):
    dic = collections.Counter(nums)
    num_len = len(nums)/2
    dic_len = len(dic)

    if dic_len < num_len:
        return dic_len
    else:
        return num_len
