def solution(msg):
    answer = []
    dictionary = []
    current = 0
    final = False

    for alphabet in range(ord("A"), ord("Z")+1):
        dictionary.append(chr(alphabet))

    for msg_index in range(len(msg)):
        if current != 0:
            current -= 1
            continue
        next_index = msg_index
        word = msg[msg_index]

        while word in dictionary:   # 사전에 단어가 있을 경우 반복
            next_index += 1
            if next_index >= len(msg):    # 마지막 인덱스일 경우 종료
                final = True
                break
            word += msg[next_index]
            current += 1

        if len(word) != 1 and final == False:      # 단어가 한글자가 아닐 경우
            answer.append(dictionary.index(word[:-1])+1)
            dictionary.append(word)
            current -= 1
        else:       # 단어가 한글자일 경우
            answer.append(dictionary.index(word)+1)

    return answer
