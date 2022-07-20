def solution(people, limit):
    count = 0
    start_index = 0
    end_index = len(people)-1

    people.sort(reverse=True)

    while start_index <= end_index:
        if people[start_index] + people[end_index] <= limit:     # 두명의 합이 제한보다 작을 경우
            end_index -= 1
        start_index += 1
        count += 1

    if len(people) == 1:
        count += 1

    return count
