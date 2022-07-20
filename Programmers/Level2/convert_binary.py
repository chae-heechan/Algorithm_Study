def solution(s):
    result = [0, 0]

    while True:
        result[0] += 1
        result[1] += s.count("0")
        s = bin(s.count("1"))[2:]
        if s == "1":
            break

    return result
