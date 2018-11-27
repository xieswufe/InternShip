def find_left_most_1_col(bit_map):
    pos = [0, len(bit_map[0]) - 1]

    while is_valid(bit_map, pos):

        if bit_map[pos[0]][pos[1]] == 1:
            pos[1] -= 1
        else:
            pos[0] += 1
    return pos[1] + 1

def is_valid(bit_map, pos):
    return 0 <= pos[0] < len(bit_map) and 0 <= pos[1] < len(bit_map[0])

# Test case
matrix =   [[0, 0, 0, 1, 1],
            [0, 0, 0, 1, 1],
            [0, 0, 1, 1, 1],
            [1, 1, 1, 1, 1],
            [0, 0, 0, 1, 1]]
print(find_left_most_1_col(matrix))
