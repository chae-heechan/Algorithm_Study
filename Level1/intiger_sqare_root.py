import math

def solution(n):
    k = math.sqrt(n)
    
    if k % 1 == 0:
        return (k+1)**2
    
    return -1