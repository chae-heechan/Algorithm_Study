import re


def time_calculator(start_time, finish_time):
    time1, minute1 = map(int, start_time.split(":"))
    time2, minute2 = map(int, finish_time.split(":"))

    play_time = (time2-time1)*60 + minute2-minute1

    return play_time


def change_melody(melody):
    regular = "[A-G]{1}#?"
    dictionary = {"A": "a", "A#": "b",  "B": "c", "C": "d", "C#": "e", "D": "f",
                  "D#": "g", "E": "h", "F": "i", "F#": "j", "G": "k", "G#": "l", "E#": "m"}

    listed_melody = re.findall(regular, melody)
    changed_melody = ""

    for item in listed_melody:
        changed_melody += dictionary[item]

    return changed_melody


def solution(m, musicinfos):
    answer = 'aa'
    same_music = []
    time = 0

    listened_melody = change_melody(m)

    for index in range(len(musicinfos)):
        info = musicinfos[index].split(",")
        play_time = time_calculator(info[0], info[1])

        changed_melody = change_melody(info[3])

        melody = changed_melody * \
            (play_time//len(changed_melody)) + \
            changed_melody[:play_time % len(changed_melody)]

        if melody.find(listened_melody) != -1 and time < play_time:
            time = play_time
            answer = info[2]

    if time == 0:
        return "(None)"

    return answer
