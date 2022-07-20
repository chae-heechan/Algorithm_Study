import math

def solution(w,h):
    total = w * h
    a = math.gcd(w, h)
    b = h // a
    c = w // a
    left = total - (b+c-1)*a
    return left