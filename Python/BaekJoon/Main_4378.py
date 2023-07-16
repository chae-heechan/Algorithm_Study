import sys

def main():
    lst = [
        ['`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '='],
        ['Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\'],
        ['A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\''],
        ['Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/']
    ]

    for line in sys.stdin :

        answer = ""

        for t in line :
            if t == ' ':
                answer += ' '
                continue

            for x in range(len(lst)):
                for y in range(len(lst[x])):
                    if lst[x][y] == t:
                        answer += lst[x][y-1]

        print(answer)
main()