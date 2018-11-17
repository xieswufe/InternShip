def previous_permutation(nums):
    # Scan from right to left, find the first i s.t. a[i-1] > a[i]
    for i in range(len(nums) - 1, -1, -1):
        if i > 0 and nums[i - 1] > nums[i]:
            left_index = i - 1
            break
    else:
        nums.reverse()
        return

    # switch a[i-1] with the first element a[j] in a[i:]
    for j in range(len(nums) - 1, left_index, -1):
        if nums[j] < nums[left_index]:
            nums[j], nums[left_index] = nums[left_index], nums[j]
            break

    # make a[i:] in descending order (reverse a[i:])
    start, end = left_index + 1, len(nums) - 1
    while start < end:
        nums[start], nums[end] = nums[end], nums[start]
        start, end = start + 1, end - 1

# Testing
nums = [1,2,3]
print(nums)
for _ in range(10):
    previous_permutation(nums)
    print(nums)
