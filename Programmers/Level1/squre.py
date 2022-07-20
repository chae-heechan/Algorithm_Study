def solution(sizes):
    return max([min(i) for i in sizes]) * max([max(i) for i in sizes])