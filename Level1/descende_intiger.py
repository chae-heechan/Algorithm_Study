def solution(n):
    s = sorted([int(i) for i in str(n)])[::-1]
    answer = ""
    for i in s:
        answer += str(i)
    
    return int(answer)