def solution(numbers):
    answer = []
    for number in numbers:

        number_str = "0" + str(bin(int(number))[2:])
        zero_index = number_str.rfind("0")

        if zero_index == len(number_str) - 1:     # 0이 마지막 인덱스에 있을 경우
            if number_str[0] == "0":
                number_str = number_str[1:]
            answer.append(int("0b" + number_str, 2) + 1)
        else:
            number_str = number_str[:zero_index] + \
                "10" + number_str[zero_index + 2:]
            answer.append(int("0b" + number_str, 2))

    return answer
