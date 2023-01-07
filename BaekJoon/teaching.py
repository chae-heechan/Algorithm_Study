def solution():
    answer = 0
    n, k = map(int, input().split(" "))

    if k < 5:
        print(0)
        return

    words = []

    for i in range(n):
        word = input()

        word = word.replace("a", "")
        word = word.replace("n", "")
        word = word.replace("t", "")
        word = word.replace("i", "")
        word = word.replace("c", "")

        print(word)
        if len(word) == 0:
            answer += 1
            continue

        if k - 5 >= len(word):
            words.append(word)

    words.sort(key=len)

    print(words)

    for word in words:





solution()
