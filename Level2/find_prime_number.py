import itertools


def solution(numbers):
    prime_number = []

    for length in range(1, len(numbers)+1):
        for number in itertools.permutations(numbers, length):
            number = int(''.join(number))
            for i in range(2, int(number**0.5)+1):
                if number % i == 0:
                    break
            else:
                prime_number.append(number)
    prime_number = set(prime_number)
    if 0 in prime_number:
        prime_number.remove(0)
    if 1 in prime_number:
        prime_number.remove(1)

    return len(prime_number)
