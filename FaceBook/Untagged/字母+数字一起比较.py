def compare_num_char(s1, s2):
    pos1, pos2 = 0, 0
    while pos1 < len(s1) and pos2 < len(s2):
        if s1[pos1].isdigit() and s2[pos2].isdigit():
            num1, num2 = 0, 0
            while pos1 < len(s1) and s1[pos1].isdigit():
                num1 = num1 * 10 + int(s1[pos1])
                pos1 += 1

            while pos2 < len(s2) and s2[pos2].isdigit():
                num2 = num2 * 10 + int(s2[pos2])
                pos2 += 1

            if num1 < num2:
                return s1
            elif num2 < num1:
                return s2
            else:
                continue

        elif s1[pos1].isdigit():
            return s1

        elif s2[pos2].isdigit():
            return s2

        else:
            if s1[pos1] < s2[pos2]:
                return s1
            elif s2[pos2] < s1[pos1]:
                return s2
            else:
                pos1 += 1 
                pos2 += 1

    if pos1 == len(s1) and pos2 == len(s2):
        return 0
    return s2 if pos1 < len(s1) else s1
