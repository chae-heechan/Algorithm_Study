def solution(clothes):
    dic = {}
    for item in clothes:
        if item[1] not in dic:      # 딕셔너리에 없는 종류일 경우
            dic[item[1]] = 2
        else:       # 딕셔너리에 이미 있는 종류일 경우
            dic[item[1]] += 1

    answer = 1
    for i in dic.values():
        answer *= i
    return answer-1
