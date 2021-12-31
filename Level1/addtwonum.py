def solution(numbers):
    answer = []
    for first in range(len(numbers)):
        for second in range(first):
            if((numbers[first] + numbers[second]) not in answer):
                answer.append(numbers[first] + numbers[second])
        answer.sort()
    return answer
