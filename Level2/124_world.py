def solution(n):
    result = ''
    
    while n > 0:
        n, mod = divmod(n, 3)
        if mod == 0:
            n -= 1
            mod = 3
        result += str(mod)
        
    result = result.replace('3', '4')
    return result[::-1]