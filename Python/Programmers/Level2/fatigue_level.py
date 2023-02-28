from itertools import permutations


def solution(k, dungeons):
    max_count = 0

    for ordered_dungeons in permutations(dungeons):
        fatigue_level = k
        count = 0

        for dungeon in ordered_dungeons:
            if fatigue_level >= dungeon[0]:
                fatigue_level -= dungeon[1]
                count += 1

        max_count = max(max_count, count)

    return max_count
