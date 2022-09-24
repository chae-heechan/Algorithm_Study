def main():
    days = int(input())
    t = []
    p = []
    dp = [0] * days

    for i in range(days):
        ti, pi = map(int, input().split(" "))
        t.append(ti)
        p.append(pi)

    m = 0
    for i in range(days):
        m = max(m, dp[i])
        if i + t[i] > days:
            continue
        dp[i+t[i]] = max(m + p[i], dp[i+t[i]])

    print(max(dp))


main()
