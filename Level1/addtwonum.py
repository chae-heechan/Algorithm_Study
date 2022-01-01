def solution(numbers):
    answer = []
    for first in range(len(numbers)):
        for second in range(first):
            answer.append(numbers[first] + numbers[second])
    return sorted(list(set(answer)))
