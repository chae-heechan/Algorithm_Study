import math


def solution(n, a, b):
    answer = 1
    mid = n

    for i in range(int(math.log2(n))):
        mid = mid//2

        if (a+1)//2 != (b+1)//2:    # a,b가 다음에 경기를 못할 경우
            answer += 1
            a = (a+1)//2
            b = (b+1)//2
            continue
        else:   # a,b가 다음에 경기할 경우
            return answer
