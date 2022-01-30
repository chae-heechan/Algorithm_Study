def solution(n, t, m, p):
    answer = ''
    result = ''
    dic = {10: 'A', 11: 'B', 12: 'C', 13: 'D', 14: 'E', 15: 'F'}
    cnt = 0
    value = 0
    tmp = []

    while len(answer) < t*m:
        remainder = value % n
        if remainder >= 10:
            tmp.append(dic[remainder])
        else:
            tmp.append(str(remainder))
        value = value // n
        if value == 0:
            answer += ''.join(reversed(tmp))
            cnt += 1
            tmp = []
            value = cnt
    for index in range(p-1, t*m, m):
        result += answer[index]

    return result
