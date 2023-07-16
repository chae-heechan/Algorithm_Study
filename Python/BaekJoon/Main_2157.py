def main():
    n, m, k = list(map(int,input().split(" ")))

    graph = [[0]*(n+1) for i in range(n+1)] # i에서 j까지 가는 최대 기내식
    dp = [[0]*(m+1) for i in range(n+1)]    # 1부터 i까지 최대 j개 도시를 거쳐 갈 수 있는 최대 기내식

    for i in range(k) :
        start, end, value = map(int, input().split(" "))
        if start > end :
            continue
        graph[start][end] = max(graph[start][end], value)
    
    for i in range(2, n+1) :
        dp[i][2] = graph[1][i]

    for i in range(2, n+1):
        for j in range(2, m+1):
            for k in range(i):
                if dp[k][j-1] and graph[k][i] :
                    dp[i][j] = max(dp[i][j], dp[k][j-1] + graph[k][i])

    print(max(dp[n]))


main()