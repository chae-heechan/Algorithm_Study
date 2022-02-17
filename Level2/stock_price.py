def solution(prices):
    result = [0 for i in range(len(prices))]

    for index1 in range(len(prices)):
        for index2 in range(index1+1, len(prices)):
            result[index1] += 1
            if prices[index1] > prices[index2]:    # 떨어졌을 경우
                break

    return result
