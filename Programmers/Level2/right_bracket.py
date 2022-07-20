def solution(s):
    answer = True
    tmp = ''
    li = []

    for c in s:
        if c == '(':
            li.append(c)
        else:
            if len(li) == 0:
                return False
            tmp = li.pop()
            if tmp == '':
                return False

    return len(li) == 0
