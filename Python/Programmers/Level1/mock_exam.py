def solution(answers):
    answer = []
    score = [0, 0, 0]
    sol1 = [1, 2, 3, 4, 5]
    sol2 = [2, 1, 2, 3, 2, 4, 2, 5]
    sol3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    for i in range(len(answers)) :
        if sol1[i % len(sol1)] == answers[i] :
            score[0] += 1
        if sol2[i % len(sol2)] == answers[i] :
            score[1] += 1
        if sol3[i % len(sol3)] == answers[i] :
            score[2] += 1
    for i in range(3):
        if max(score[0], score[1], score[2]) == score[i] :
            answer.append(i+1)
    return answer