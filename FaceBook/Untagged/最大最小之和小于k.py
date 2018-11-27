def subset(nums, k):
    nums.sort()
    left, right = 0, len(nums) - 1
    count = 0
    while left <= right:
        while left <= right and nums[left] + nums[right] >= k:
             right -= 1

        if left <= right:
            count += 2 ** (right - left)
            left += 1
    return count

# Test case
nums = [8, 3, 1, 2, 4, 5]
result = subset(nums, 5)
print(result)
