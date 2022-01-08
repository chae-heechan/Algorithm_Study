def solution(n, m):
    a,b = max(n,m),min(n,m)
    r = 1

    while r > 0:
      r = a % b
      a, b = b, r

    return [a, n*m/a]