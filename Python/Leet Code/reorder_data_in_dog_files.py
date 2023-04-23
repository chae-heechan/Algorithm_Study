class Assignment:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        letters, digits = [], []
        for log in logs:
            if log.split()[1].isdigit():    # 숫자일 경우
                digits.append(log)
            else:   # 영어일 경우
                letters.append(log)
                
        letters.sort(key = lambda x : (x.split()[1:], x.split()[0]))
        return letters + digits