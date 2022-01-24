def solution(fees, records):
    answer = []
    cars = {}
    
    for record in records:
        times, number, io = record.split(" ")
        hour, minute = map(int, times.split(":"))
        time = hour*60 + minute
        
        if io =="IN":       # 입차일 경우
            if number in cars:  # 기록에 이미 있을 경우
                cars[number] -= time
            else:             # 기록에 없을 경우
                cars[number] = -time
        else:               # 출차일 경우
            cars[number] += time
    
    for number, time in sorted(cars.items()):
        if time <= 0:
            time += 1439    # 23시 59분

        if time - fees[0] <= 0:     # 기본시간보다 적게 사용했을 경우
            answer.append(fees[1])
        else:                       # 기본시간 넘겼을 경우
            if (time - fees[0]) % fees[2] == 0: # 나눠 떨어질 경우
                answer.append(fees[1] + ((time - fees[0]) // fees[2]) * fees[3])
            else:                               # 안나눠 떨어질 경우
                answer.append(fees[1] + (((time - fees[0]) // fees[2]) + 1) * fees[3])
            
    return answer