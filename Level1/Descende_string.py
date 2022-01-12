def solution(s):
    a = sorted([ord(i) for i in s])[::-1]
    b = ""
    for j in a:
        b += chr(j)
    return b