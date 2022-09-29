def main():
    n, s, m = map(int, input().split(" "))
    v = list(map(int, input().split(" ")))
    dp = [[0] * (m + 1) for i in range(n + 1)]
    dp[0][s] = 1

    for i in range(n):
        for j in range(m):
            if dp[i][j] == 1:
                if j + v[i] <= m:
                    dp[i+1][j + v[i]] = 1
                if j - v[i] >= 0:
                    dp[i+1][j - v[i]] = 1

    try:
        print(m - list(reversed(dp[n])).index(1))
    except ValueError:
        print(-1)


main()
