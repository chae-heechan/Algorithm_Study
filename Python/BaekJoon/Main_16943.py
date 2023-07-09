from itertools import permutations

def main():
    max = -1

    a, b = input().split(" ")
    b = int(b)

    permu = permutations(a, len(a))

    for i in permu:
        i = int(''.join(i))

        if i > max and i < b and len(str(i)) == len(a):
            max = i

    print(max)

main()