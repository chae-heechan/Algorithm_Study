def solution(numbers):
    number_list = []
    answer = []
    for number in numbers:
        number_str = str(number)*4
        number_list.append((number_str[:4], len(str(number))))

    number_list.sort(key=lambda x: x[0])
    number_list.reverse()

    for number, index in number_list:
        answer.append(str(number)[:index])
    return str(int(''.join(answer)))
