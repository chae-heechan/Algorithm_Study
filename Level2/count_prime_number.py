def solution(n, k):
    count = 0
    result = ''

    while n > 0:
        n, r = divmod(n, k)
        result += str(r)
    result = result[::-1]

    for prime in result.split("0"):
        if prime == "" or prime == "1":
            continue
        if prime == "2":
            count += 1
            continue

        sqrt_num = int(int(prime)**0.5+1)

        for i in range(2, sqrt_num+1):
            if int(prime)%i == 0:    # 나눠 떨어질 경우
                break
            if i == sqrt_num:        # 나눠 떨어지지 않고 끝까지 올 경우
                count += 1

    return count