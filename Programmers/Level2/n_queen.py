def solution(n):

    # i는 퀸이 있는 곳
    for i in range(n):
        row = [i for i in range(n)]

        for j in range(1, n):
            next_row = [i for i in range(n)]

            # 다음 줄에 가능한 자리만 남겨두기
            if i-1 in next_row:
                next_row.remove(i-1)
            if i+1 in next_row:
                next_row.remove(i+1)
                next_row.remove(i)

    answer = 0
    return answer
