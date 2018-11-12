

// 漏水和不漏水都可以用下面这种写法  time complexity O(n)
public int trappingWater(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        int leftIndex = 0;
        int leftHeight = 0;
        int bottomHeight = 0;
        Deque<Integer> container = new ArrayDeque<Integer>();
        int totalwater = 0;
        for (int  i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                while (!container.isEmpty() && nums[container.peek()] < nums[i]) {
                    int bottom = container.pop();
                    if (!container.isEmpty()) {
                        leftIndex = container.peek();
                        leftHeight = nums[leftIndex];
                        bottomHeight = nums[bottom];
                        totalwater += (Math.min(leftHeight, nums[i]) - bottomHeight) * (i - leftIndex - 1);
                    }
                }
                container.push(i);
            }
            else {
                container.clear();
            }
        }
        return totalwater;
    }

// two pointer + 每个bar还有宽度
public int trap(int[] height,int[] bar) {
        // check corner cases 
        if (height == null || height.length == 0) {
            return 0;
        }
        // two pointer
        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        int trap_water = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                left_max = Math.max(left_max,height[left]);
               // trap_water += left_max - height[left++];
                trap_water += bar[left] * (left_max - height[left++]); 
            }
            else {
                right_max = Math.max(right_max,height[right]);
              //trap_water += left_max - height[right++];
                trap_water += bar[right] * (right_max - height[right--]);
            }
        }
        return trap_water;
    }
