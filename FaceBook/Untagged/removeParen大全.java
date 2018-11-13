/////////////////只要返回一个结果
// two pass  双指针 o(n)（看string delete算时间复杂度不）  空间o(1)
public String removeInvalidParen(String paren) {
    if (paren.length() == 0) return "";
    StringBuilder  sb = new StringBuilder(paren);
    int left = 0;
    for (int i = 0; i < sb.length(); i++) {
      char curt = sb.charAt(i);
      if (curt == '(') left++;
      else if (curt == ')') {
        if (left > 0) left --;
        else {
          sb.deleteCharAt(i--);
        }
      }
    }
    if (left == 0) return sb.toString();
    int right = 0;
    for (int i = sb.length() - 1; i >= 0; i--) {
      char curt = sb.charAt(i);
      if (curt == ')') right ++;
      else if (curt == '(') {
        if (right > 0) right --;
        else {
          sb.deleteCharAt(i); // 注意不要加了
        }
      }
    }
    return sb.toString();
  }

//////// one pass stack   
// a stack
public String removeParen(String s) {
    if (s.length() <= 1) {
      return "";
    }
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char curt = s.charAt(i);
      if (curt == '(') {
        stack.push(i);
      }
      else if (curt == ')'){
        if (stack.isEmpty() || s.charAt(stack.peek()) == ')') {
          stack.push(i);
        }
        else {
          stack.pop();
        }
      }
    }
    //因为是从后往前删除，所以序号是不变的
    StringBuilder sb = new StringBuilder(s);
    while (!stack.isEmpty()) {
      sb.deleteCharAt(stack.pop());
    }
    return sb.toString();
  }




////////////////////////返回多个结果
/////////////bfs  时间复杂度高达 2^n * n   空间也是这么多
public List<String> removeInvalidParentheses(String s) {
        // firtstly, check corner cases
        // the shortest path, use bfs
        Set<String> visited = new HashSet<String>();
        List<String> res = new ArrayList<String>();
        if (s == null  || s.length() == 0) {
            res.add("");
            return new ArrayList(res);
        }
        if (isValid(s)) {
            res.add(s);
            return res;
        }
        Queue<String> bfs = new LinkedList<String>();
        bfs.offer(s);
        visited.add(s);
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            while (size -- > 0) {
                String curt = bfs.poll();
                for (int i = 0; i < curt.length(); i++) {
                    if (curt.charAt(i) != '(' && curt.charAt(i) != ')') {
                        continue;
                    }
                    String temp = curt.substring(0,i) + curt.substring(i+1);
                    if (visited.contains(temp)) {
                        continue;
                    }
                    if (isValid(temp)) {
                        res.add(temp);
                    }
                    else {
                        bfs.offer(temp);
                    }
                    visited.add(temp);
                }
            }
            if (!res.isEmpty()) {
                return res;
            }
        }
        return res;
    }
    private boolean isValid(String s) {
        int leftcount = 0;
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == '(') {
                leftcount ++;
            }
            else if (s.charAt(index) == ')') {
                if (leftcount == 0) {
                    return false;
                }
                leftcount --;
            }
            index ++;
        }
        return leftcount == 0;
    }



////////////////dfs   剪枝之后 O( 2 ^（l+ r）)
public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            char curt = s.charAt(i);
            if (curt == '(') left ++;
            else if (curt == ')') {
                if (left > 0) left --;
                else right ++;
            }
        }
        Set<String> res = new HashSet<>();
        dfs(s,res, new StringBuilder(),left,right,0,0);
        return new ArrayList<>(res);
    }
    public void dfs(String s, Set<String> res, StringBuilder sb, int left, int right, int open, int idx) {
        if (left < 0 || right < 0 || open < 0) return;
        
        if (idx == s.length()) {
            if (left == 0 && right == 0 && open == 0) res.add(sb.toString());
            return;
        }
        int len = sb.length();
        char curt = s.charAt(idx);
        if (curt == '(') {
            dfs(s,res,sb, left - 1, right, open, idx + 1);
            dfs(s,res,sb.append(curt),left,right,open + 1, idx + 1);
        }
        else if (curt == ')') {
            dfs(s,res,sb, left, right - 1, open, idx + 1);
            dfs(s,res,sb.append(curt),left,right,open - 1, idx + 1);
        }
        else {
            dfs(s,res,sb.append(curt),left,right,open, idx + 1);
        }
        sb.setLength(len);
    }

