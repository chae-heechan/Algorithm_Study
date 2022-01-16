def solution(n):
    result = ''
    while n > 0:
        n, m = divmod(n, 3)
        result += str(m)
        
    return int(result, 3)