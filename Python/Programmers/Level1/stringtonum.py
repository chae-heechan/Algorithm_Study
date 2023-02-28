def solution(s):
    string = s
    nums = {
        "zero": "0",
        "one": "1",
        "two": "2",
        "three": "3",
        "four": "4",
        "five": "5",
        "six": "6",
        "seven": "7",
        "eight": "8",
        "nine": "9"
    }

    for num in nums:
        if num in s:
            string = string.replace(num, nums.get(num))

    return int(string)
