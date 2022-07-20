def solution(skill, skill_trees):

    count = 0

    for skills in skill_trees:
        skill_index = 0
        for s in skills:
            if s in skill:
                if s == skill[skill_index]:     # 맞는 스킬 트리면
                    skill_index += 1
                else:    # 틀린 스킬 트리면
                    count -= 1
                    break
        count += 1

    return count
