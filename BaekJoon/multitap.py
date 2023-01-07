from collections import Counter


def solution():
    answer = 0
    n, k = map(int, input().split(" "))

    s = list(map(int, input().split(" ")))
    multitap = []

    for i in range(k):
        if len(multitap) < n and s[i] not in multitap:  # 멀티탭 자리가 있고 중복되지 않으면
            multitap.append(s[i])
        # 멀티탭 자리가 없고 중복되지 않은 경우
        elif len(multitap) >= n and s[i] not in multitap:
            answer += 1
            min_tap = k + 1
            for tap in multitap:
                min(min_tap, s[i+1:].count(tap))
        elif s[i] in multitap:    # 중복된 경우
            continue

    if len(multitap) >= n and s[k-1] not in multitap:
        answer += 1

    print(answer)


solution()