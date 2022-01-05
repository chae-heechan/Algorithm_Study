import re

def solution(dartResult):
    answer = 0
    pre = 1
    cur = 1
    regex = re.compile("\d{1,2}[S,D,T][*,#]{0,1}")
    points = regex.findall(dartResult)
    
    for index in range(3):
        print(points[index][0])
        if "*" in points[index]:
            cur = 2
            if index != 0:
                pre *= 2
            points[index] = points[index].replace("*", "")
        elif "#" in points[index]:
            cur = -1
            points[index] = points[index].replace("#", "")
        
        if "S" in points[index]:
            points[index] = points[index].replace("S", "")
            cur = cur * int(points[index])
        elif "D" in points[index]:
            points[index] = points[index].replace("D", "")
            cur = cur * ((int(points[index])) ** 2)
        elif "T" in points[index]:
            points[index] = points[index].replace("T", "")
            cur = cur * ((int(points[index])) ** 3)
            
        if index >= 1:
            answer += pre
            pre = 1
        pre = cur
        cur = 1
    answer += pre

    return answer