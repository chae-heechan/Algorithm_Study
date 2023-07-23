def main():
    x, y = list(map(int, input().split(" ")))
    board = []

    b_count = 0
    w_count = 0


    for i in range(x):
        board.append(input())


    for i in range(0, x, 2) :
        for j in range(0, y, 2):
            if board[i][j] == "B":
                b_count += 1
            else :
                w_count += 1
    
    count1 = min(b_count, w_count)

    b_count = 0
    w_count = 0

    for i in range(0, x, 2) :
        for j in range(1, y, 2):
            if board[i][j] == "B":
                b_count += 1
            else :
                w_count += 1

    
    count2 = min(b_count, w_count)

    print(count1 + count2)

main()