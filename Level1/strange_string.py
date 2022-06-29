def solution(s):
    answer = ""
    s = s.lower()
    for w in s.split(" "):
        for i, a in enumerate(w):
            answer += a.upper() if i%2 == 0 else a.lower()
        answer += " "
    return answer[:-1]