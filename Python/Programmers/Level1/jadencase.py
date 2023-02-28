def solution(s):
    return " ".join([i.capitalize() if i != "" else "" for i in s.split(" ")])
