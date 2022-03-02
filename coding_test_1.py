def solution():
    amount = int(input())
    list_size = input()
    count = int(input())

    memory = []

    for size in list_size.split(" "):
        memory.append([int(size), {}])
    memory.append([0, {}])

    for c in range(count):
        input_value = list(input().split(" "))
        if input_value[0] == 'I':
            key, volume = int(input_value[1]), int(input_value[2])
            memory[0][1][key] = volume

            for i in range(len(memory)-1):
                if memory[i][0] < sum(memory[i][1].values()):
                    memory[i + 1][1].update(memory[i][1])
                    memory[i][1] = {}
                else:
                    break

        elif input_value[0] == 'F':
            for i in range(len(memory)):
                key = int(input_value[1])

                if key not in memory[i][1]:
                    continue

                print(i+1, memory[i][1][key])
                break
            else:
                print(None)


solution()
