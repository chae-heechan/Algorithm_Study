from itertools import permutations

def solution(n, k):
    line = [i+1 for i in range(n)]
    
    for index, value in enumerate(permutations(line)):
        if index == k-1:
            return list(value)