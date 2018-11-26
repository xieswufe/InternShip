////// intersection 不让输出重复的

// set解法
public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numset = new HashSet<Integer>();
        Set<Integer> result = new HashSet<Integer>();
        for (int num :nums1) {
            numset.add(num);
        }
        for (int num : nums2) {
            if (numset.contains(num)) {
                result.add(num);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        for (int item : result) {
            res[i++] = item;
        }
        return res;
    }


//双指针解法
public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int pos1 = 0;
        int pos2 = 0;
        while (pos1 < nums1.length && pos2 < nums2.length) {
            if (nums1[pos1] == nums2[pos2]) {
                res.add(nums1[pos1]);
                pos1 ++;
                pos2 ++;
                while (pos1 < nums1.length && nums1[pos1] == nums1[pos1 - 1]) pos1 ++;
                while (pos2 < nums2.length  && nums2[pos2] == nums2[pos2 - 1]) pos2 ++;
            }
            else if (nums1[pos1] > nums2[pos2]) {
                pos2 ++;
            }
            else {
                pos1 ++;
            }
        }
        int[] res_arr = new int[res.size()];
        int i = 0;
        for (int item : res) {
            res_arr[i++] = item;
        }
        return res_arr;
    }

// bs同下，只是注意相同元素（直接滑倒下面）


////// intersction 包含重复的

// 非排序 map做法 ： o(n+m)
public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> val2fre = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            val2fre.put(nums1[i], val2fre.getOrDefault(nums1[i],0) + 1);
        }
        for (int num : nums2) {
            if (val2fre.containsKey(num) && val2fre.get(num) > 0) {
                val2fre.put(num, val2fre.get(num) - 1);
                res.add(num);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

// 排序双指针 ： (O（nlogn） + O (mlogm)) 如果没排序 + O(m+n)
public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int pos1 = 0;
        int pos2 = 0;
        while (pos1 < nums1.length && pos2 < nums2.length) {
            if (nums1[pos1] == nums2[pos2]) {
                res.add(nums1[pos1]);
                pos1 ++;
                pos2 ++;
            }
            else if (nums1[pos1] > nums2[pos2]) {
                pos2 ++;
            }
            else {
                pos1 ++;
            }
        }
        int[] res_arr = new int[res.size()];
        int i = 0;
        for (int item : res) {
            res_arr[i++] = item;
        }
        return res_arr;
    }


// 排序 binary search lower bound 做法 nlogm 
public int[] intersect(int[] nums1, int[] nums2) {
        // suppose nums2.length is much lower, then we can use the elements in nums2 to binary search
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int pos1 = 0;
        int pos2 = 0;
        while (pos1 < nums1.length && pos2 < nums2.length) {
            int lower = binarySearch(pos1,nums2[pos2],nums1);
            int curtVal = nums2[pos2];
            if (lower != -1) {
                pos1 = lower;
                while (pos1 < nums1.length && pos2 < nums2.length && nums1[pos1] == nums2[pos2]) {
                    res.add(nums1[pos1]);
                    pos1 ++;
                    pos2 ++;
                }
            }
            else {
                pos2 ++;
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) result[i] = res.get(i);
        return result;
    }
    public int binarySearch(int start, int target, int[] nums) {
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= target) end = mid;
            else start = mid;
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
