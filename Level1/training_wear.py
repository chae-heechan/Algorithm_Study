def solution(n, lost, reserve):
    count = 0
    
    for student in lost[:]:
        if student in reserve:
            lost.remove(student)
            reserve.remove(student)
    
    for student in lost:
        if student-1 in reserve:
            count += 1
            reserve.remove(student-1)
        elif student+1 in reserve:
            count += 1
            reserve.remove(student+1)
                
    return n-(len(lost)-count)