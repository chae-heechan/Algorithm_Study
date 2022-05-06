def solution(s, n):
    answer = ""
    for a in list(s):
        if a == " ":
            answer += " "
        elif a.isupper():
            answer += chr((ord(a)-ord("A") + n)%26 + ord("A"))
        else:
            answer += chr((ord(a)-ord("a") + n)%26 + ord("a"))
            
    return answer