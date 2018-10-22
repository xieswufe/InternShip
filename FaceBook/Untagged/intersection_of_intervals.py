def intersection_of_intervals(l1, l2):
    if not l1 or not l2:
        return []

    result = []
    i, j = 0, 0
    while i < len(l1) and j < len(l2):
        interval1, interval2 = l1[i], l2[j]
        if interval1[0] > interval2[1]:
            j += 1
        elif interval2[0] > interval1[1]:
            i += 1
        else:
            start, end = max(interval1[0], interval2[0]), min(interval1[1], interval2[1])
            result.append([start, end])
            if interval1[1] > interval2[1]:
                j += 1
            else:
                i += 1
    return result

# # Test case
# l1 = [[0, 1], [3, 5]]
# l2 = [[0, 2], [4, 6]]
#
# intersection = intersection_of_intervals(l1, l2)
# print(intersection)
