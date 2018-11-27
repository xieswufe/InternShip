# S(i,j) = min(S(i-1, j-1), S(i-1, j), S(i, j - 1)) + 1
# if matrix[i][j] == matrix[i - 1][j - 1] and matrix[i][j] != matrix[i - 1][j] and matrix[i][j] != matrix[i][j - 1]
# else 1
def max_01_matrix(matrix):
    if not matrix or not matrix[0]:
        return 0

    dp = [[1] * len(matrix[0]) for _ in range(len(matrix))]
    result = 1
    for i in range(1, len(dp)):
        for j in range(1, len(dp[0])):
            if matrix[i][j] == matrix[i - 1][j - 1] and \
                matrix[i][j] != matrix[i - 1][j] and \
                matrix[i][j] != matrix[i][j - 1]:
                dp[i][j] = min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])) + 1
                result = max(result, dp[i][j])
    return result

# Test case
matrix = [  [1, 0, 1, 0],
            [0, 1, 0, 1],
            [1, 0, 1, 0],
            [0, 1, 1, 1]]
result = max_01_matrix(matrix)
print(result)
