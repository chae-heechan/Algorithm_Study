def solution(n, arr1, arr2):
    answer = ['' for i in range(n)]
    line = ""
    for a,b,i in zip(arr1,arr2,range(n)):
        arr1[i] = format(a, 'b').zfill(n).replace('1', '#').replace('0', ' ')
        arr2[i] = format(b, 'b').zfill(n).replace('1', '#').replace('0', ' ')
        for j in range(n):
            if arr1[i][j] == '#' or arr2[i][j] == '#':
              line += "#"
            else: 
              line += " "
        answer.append(line)
    return answer

solution(5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28])