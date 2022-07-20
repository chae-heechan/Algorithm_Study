def solution(left, right):
    answer = 0
    for num in range(left, right+1):
        mcount = 0
        for m in range(1, int(num**(1/2))+1):
            if num%m == 0:
                mcount += 1
                if m ** 2 != num:
                    mcount += 1
        if mcount % 2 == 0:
            answer += num
        else:
            answer -= num
    
    return answer