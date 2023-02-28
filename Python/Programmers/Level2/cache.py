def solution(cacheSize, cities):
    cache = []
    run_time = 0

    for city in cities:
        city_l = city.lower()
        if city_l in cache:       # 캐시 안에 있을 경우
            cache.remove(city_l)
            cache.insert(0, city_l)
            run_time += 1
            continue

        else:   # 캐시가 없을 경우
            cache.insert(0, city_l)
            run_time += 5

        if len(cache) > cacheSize:    # 캐시가 사이즈보다 커졌을 경우
            cache.pop()

    return run_time
