def solution(d, budget):
    d.sort()
    count = 0
    for team in d:
        budget = budget - team
        count += 1
        if budget < 0:
            count -= 1
            break
    return count
