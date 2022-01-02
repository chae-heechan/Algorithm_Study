def solution(N, stages):
    answer = []
    rates = []

    for S in range(N):  # 전체 스테이지 순환
        S += 1  # 0 -> 1
        reach_count = 0
        unclear_count = 0

        for index in range(len(stages)):    # stages 인덱스 만큼 순환
            if stages[index] >= S:  # 현재 스테이지보다 크거나 같으면
                reach_count += 1    # 도달 카운트 + 1
                if stages[index] == S:  # 현재 스테이지와 같으면
                    unclear_count += 1  # 미클리어 카운트 + 1

        if reach_count == 0:    # 도달 카운트가 0이면
            rates.append(0)    # 실패율에 0 추가
        else:   # 도달 카운트가 1이상이면
            rates.append(unclear_count / reach_count)    # 실패율에 실패율 추가

    for i in range(len(rates)):
        answer.append(rates.index(max(rates))+1)
        rates[rates.index(max(rates))] = -1

    return answer
