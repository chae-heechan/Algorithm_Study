def solution(dirs):
    answer = 0
    position = [[0, 0], [0, 0]]
    route = []

    for direction in dirs:
        if direction == 'U' and position[1][1] != 5:
            position[1][1] += 1
        elif direction == 'D' and position[1][1] != -5:
            position[1][1] -= 1
        elif direction == 'R' and position[1][0] != 5:
            position[1][0] += 1
        elif direction == 'L' and position[1][0] != -5:
            position[1][0] -= 1

        if position not in route and position[0] != position[1]:
            answer += 1
            route.append([[0, 0], [0, 0]])
            route[len(route)-1][0][0] = position[0][0]
            route[len(route)-1][0][1] = position[0][1]
            route[len(route)-1][1][0] = position[1][0]
            route[len(route)-1][1][1] = position[1][1]

            route.append([[0, 0], [0, 0]])
            route[len(route)-1][0][0] = position[1][0]
            route[len(route)-1][0][1] = position[1][1]
            route[len(route)-1][1][0] = position[0][0]
            route[len(route)-1][1][1] = position[0][1]

        position[0][0] = position[1][0]
        position[0][1] = position[1][1]
    print(route)

    return answer
