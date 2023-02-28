import re

class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        
        answer_dict = {}
        
        paragraph = paragraph.lower() 
        paragraph = re.sub("[^a-z]", ' ', paragraph)
        
        for word in paragraph.split(" "):
            if word in answer_dict:
                answer_dict[word] += 1
            else:
                answer_dict[word] = 1
                
        answer_dict = sorted(answer_dict.items(), key = lambda item : item[1])
        answer_dict.reverse()
        
        for i in range(len(answer_dict)):
            if answer_dict[i][0] in banned or answer_dict[i][0] == "":
                continue
            else:
                return answer_dict[i][0]
            
        return answer_dict[0][0]