def main():
    n, m, v = map(int, input().split(" "))
    mat = [[0] * (n + 1) for i in range(n + 1)]
    visited = [0] * (n + 1)

    for i in range(m):
        a, b = map(int, input().split(" "))
        mat[a][b] = 1
        mat[b][a] = 1
    print(visited)
    dfs(visited, v, mat)


def dfs(visited, v, mat):
    visited[v] = 1
    print(v, end=" ")

    for i in range(1, len(mat[v])):
        if mat[v][i] != 0 and visited[i] == 0:
            dfs(visited, i, mat)


def bfs(visited, v, mat):
    queue = [v]

    visited[v] = 0

    while queue:
        v = queue.pop(0)
        print(v, end=" ")
        for i in range(1, len(mat[v])):
            if visited[i] == 1 and mat[v][i] == 1:
                queue.append(i)
                visited[i] = 0


main()
