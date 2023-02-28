import numpy


def solution(m, n, board):
    trash_can = []
    answer = 0
    for index in range(len(board)):
        board[index] = list(board[index])

    while True:
        for x in range(m-1):
            for y in range(n-1):
                if board[x][y] == board[x][y+1] and board[x][y] == board[x+1][y] and board[x][y] == board[x+1][y+1] and board[x][y] != "S":
                    trash_can.append([x, y])
                    trash_can.append([x, y+1])
                    trash_can.append([x+1, y])
                    trash_can.append([x+1, y+1])

        if len(trash_can) == 0:
            break

        for trash in trash_can:
            x, y = trash[0], trash[1]
            board[x][y] = "S"
            answer += 1
        print(trash_can)
        trash_can = []
        print(trash_can)

        for x in range(m-1, 0, -1):
            for y in range(n-1, 0, -1):
                if board[x][y] == "S":
                    for p in range(x-1, 0, -1):
                        board[p+1][y] = board[p][y]
                        board[p][y] = "S"
        print(board)
        print(answer)


solution(4, 5, ["CCBDE", "AAADE", "AAABF", "CCBBF"])
