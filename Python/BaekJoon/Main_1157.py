def main():
    dic = {}
    max_num = 0
    max_string = "?"

    string = input().upper()

    for char in string:
        if char in dic:
            dic[char] += 1
        else :
            dic[char] = 1

    for key, value in dic.items():
        if max_num < value:
            max_num = value
            max_string = key
        elif max_num == value:
            max_string = "?"

    print(max_string)




main()