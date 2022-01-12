def solution(n):
    
    answer = [True]*(n+1)
    
    m = int(n ** 0.5)
    for i in range(2, m+1):
        if answer[i] == True:
            for j in range(i*i, n+1, i):
                answer[j] = False
            
    return answer.count(True)-2