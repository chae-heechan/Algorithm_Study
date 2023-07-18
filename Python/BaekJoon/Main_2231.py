def main():
    N = int(input())
    n = "1"

    for i in range(N):
        answer = int(n)
        for j in range(len(n)):
            answer += int(n[j])
        
        if answer == N :
            print(n)
            return
        else :
            n = str(int(n)+1)

    print(0)

main()