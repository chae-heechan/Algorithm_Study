def solution(price, money, count):
    return max(sum(i*price for i in range(1, count+1)) - money, 0)
