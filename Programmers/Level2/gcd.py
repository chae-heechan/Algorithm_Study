import math


def solution(arr):
    result = 1

    for i in arr:
        result = i*result // math.gcd(i, result)

    return result
