def solution(priorities, location):
    answer = 0
    count = 0
    while True:
        if len(priorities) == 0:
            break

        if priorities[0] == max(priorities):
            count += 1
            priorities.pop(0)

            if location == 0:
                return count
            else:
                location -= 1
        else:
            priorities.append(priorities.pop(0))
            if location == 0:
                location += len(priorities) - 1
            else:
                location -= 1

    return answer
