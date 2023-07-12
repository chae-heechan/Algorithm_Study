def main():
    n = int(input())
    words = []

    for i in range(n):
        words.append(input())

    for j in range(n-1):
        for i in range(n-1):
            if len(words[i]) > len(words[i+1]):
                temp = words[i]
                words[i] = words[i+1]
                words[i+1] = temp
            elif len(words[i]) == len(words[i+1]):
                if words[i] > words[i+1]:
                    temp = words[i]
                    words[i] = words[i+1]
                    words[i+1] = temp

    for i in range(n-1):
        if words[i] != words[i+1]:
            print(words[i])
    print(words[n-1])


main()
