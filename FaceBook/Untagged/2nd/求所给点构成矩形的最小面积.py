import sys
def min_rect_area(points):
    point_set = set()
    for point in points:
        point_set.add(point[0], point[1])

    min_area = sys.maxsize
    for i in range(len(points)):
        for j in range(i + 1, len(points)):
            if points[i][0] == points[j][0] or points[i][1] == points[j][1]:
                continue
            if (points[i][0], points[j][i]) in point_set and \
                (points[j][0], points[i][1]) in point_set:
                min_area = min(min_area, abs(points[i][0] - points[j][0]) * abs(points[i][1] - points[j][1]))
    return area
