def main():
    n = int(input())
    t = []
    p = []
    dp = [0] * n

    for i in range(n):
        ti, pi = map(int, input().split(" "))
        t.append(ti)
        p.append(pi)

    m = 0
    for i in range(n):
        m = max(m, dp[i])
        if i + t[i] > n:
            continue
        dp[i+t[i]] = max(dp[i+t[i]], m + p[i])

    print(max(dp))


main()
