def solution(n):
    count = 0
    for i in range(1, n+1):
        result = 0
        addNum = i
        while(True):
            result += addNum
            addNum += 1
            if result == n:
                count += 1
                break
            elif result > n:
                break

    return count
