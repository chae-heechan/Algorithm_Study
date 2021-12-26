def solution(numbers, hand):
    result = ""
    my_l = 10
    my_r = 12
    dis = {
        0: 0,
        1: 1,
        2: 2,
        3: 1,
        4: 2,
        5: 3,
        6: 2,
        7: 3,
        8: 4,
        9: 3,
        10: 4,
    }

    for num in numbers:
        if num == 0:
            num = 11

        if num == 1 or num == 4 or num == 7:
            result = result + "L"
            my_l = num
        elif num == 3 or num == 6 or num == 9:
            result = result + "R"
            my_r = num
        else:
            if dis[abs(num-my_l)] < dis[abs(num-my_r)]:
                print(num)
                result = result + "L"
                my_l = num
            elif dis[abs(num-my_l)] > dis[abs(num-my_r)]:
                result = result + "R"
                my_r = num
            else:
                if hand == "right":
                    result = result + "R"
                    my_r = num
                else:
                    result = result + "L"
                    my_l = num

    return result
