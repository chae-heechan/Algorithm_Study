def solution(str1, str2):
    str1, str2 = str1.lower(), str2.lower()
    str1, str2 = split(str1), split(str2)
    intersection = 0
    union = 0

    if len(str1) + len(str2) == 0:
        return 65536

    for word in str1:
        if word in str2:
            intersection += 1
            str2.remove(word)

    union = len(str1) + len(str2)

    return int(65536 * (intersection / union))


def split(string):
    new_str = []
    for i in range(len(string)-1):
        if string[i:i+2].isalpha():
            new_str.append(string[i:i+2])

    return new_str
