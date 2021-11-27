def solution(lottos, win_nums):

    count = 0
    result = []

    for lotto in lottos:
        if lotto in win_nums:
            count = count + 1

    if (lottos.count(0)+count) != 0:
        result.append(7-(lottos.count(0)+count))
    else:
        result.append(6)

    if count != 0:
        result.append(7-count)
    else:
        result.append(6)

    return result
