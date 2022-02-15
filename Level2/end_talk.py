def solution(n, words):
    word_box = [words[0]]
    words.remove(words[0])
    count = 1

    for word in words:
        # 단어가 이미 나왔거나 끝말잇기가 아닐 경우
        if word in word_box or word_box[-1][-1] != word[0]:
            return [count % n + 1, count // n + 1]
        else:   # 정상적인 경우
            count += 1
            word_box.append(word)
    return [0, 0]
