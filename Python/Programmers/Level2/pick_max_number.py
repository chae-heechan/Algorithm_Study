import itertools


def solution(number, k):
    answer = ""
    start_index = 0
    remain_number = len(number)-(len(number)-k-1)
    FINAL_NUMBER = "9"

    for i in range(len(number)-k):
        current_number = "0"
        for n in number[start_index:remain_number]:
            if n == FINAL_NUMBER:
                current_number = FINAL_NUMBER
                break
            elif current_number < n:
                current_number = n

        start_index = number[start_index:].index(current_number) + start_index

        start_index += 1
        remain_number += 1

        answer += str(current_number)

    return answer
