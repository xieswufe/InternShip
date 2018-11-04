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
