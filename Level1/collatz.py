def solution(num):
    answer = 0
    while num != 1 and answer < 500 :
        if num % 2 == 0:    # 짝수일 경우
            num /= 2
        else:               # 홀수일 경우
            num = (num*3) + 1 
        answer += 1
        
    if answer >= 500:
        answer = -1
    
    return answer