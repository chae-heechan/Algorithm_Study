def solution(bridge_length, weight, truck_weights):
    answer = 0
    on_load = []
    sum_weight = 0
    # 7 4 5 6
    for truck in truck_weights:
        if sum_weight + truck <= weight:
            on_load.insert(0, truck)
            sum_weight += truck
            answer += 1
        else:
            while len(on_load) != bridge_length:
                on_load.insert(0, 0)
                answer += 1
                if len(on_load) == bridge_length:
                    sum_weight -= on_load.pop()
                if sum_weight + truck <= weight:
                    on_load.insert(0, truck)
                    sum_weight += truck
                    answer += 1
        if len(on_load) == bridge_length:
            sum_weight -= on_load.pop()

    return answer + bridge_length
