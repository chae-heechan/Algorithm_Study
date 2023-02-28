def solution(s):
    strings = []
    answers = []
    
    if len(s) == 1:
        return 1
    
    for u in range(1, len(s)//2+1):
        lst = [s[i:i+u]for i in range(0, len(s), u)]
        strings.append(lst)
    
    for string in strings:
        words = ""
        count = 1
        prev_word = ""
        
        for word in string:
            if prev_word == "":  # 첫 단어일 경우
                prev_word = word
                continue
            
            if prev_word == word:    # 이전 단어와 현재 단어가 같을 경우
                count += 1
            else:   # 이전 단어와 현재 단어가 다를 경우
                if count == 1:
                    words += prev_word
                else:
                    words += str(count)+prev_word
                prev_word = word
                count = 1
            
        if count == 1:
            words += prev_word
        else:
            words += str(count)+prev_word
        
        answers.append(len(words))
    return min(answers)
    
        
        