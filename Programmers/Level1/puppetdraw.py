def solution(board, moves):
    stack = []
    count = 0
    print(len(board))
    for col in moves:   # 입력에 따라
        col = col - 1   # 열을 -1 해준다
        for row in range(len(board)):    # 행은 0~4까지 증가

            if board[row][col]:  # 보드에 인형이 있다면
                stack.append(board[row][col])   # stack에 추가
                board[row][col] = 0     # 보드에서 삭제

                if len(stack) > 1:  # stack의 길이가 2이상이면
                    if stack[len(stack)-1] == stack[len(stack)-2]:  # stack 위에 2개가 같다면
                        stack.pop()  # 위 두개 pop
                        stack.pop()
                        count = count + 2   # 카운트 2 추가
                break
    return count
