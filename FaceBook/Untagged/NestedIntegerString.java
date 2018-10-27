 public String unfold(List<NestedInteger> nest) {
       String res = helper(nest,1);
        return res;
}
public String helper(List<NestedInteger> nest, int level) {
  if (nest.isEmpty()) return "";
  StringBuilder sb = new StringBuilder();
  for (NestedInteger item : nest) {
    if (item.isInteger()) {
      sb.append("+").append(item.getInteger());
    }
    else {
        String levelDepth = helper(item.getList(), level + 1);
        if (levelDepth.equals("")) continue;
      sb.append("+").append(levelDepth);
    }
  }
  sb.deleteCharAt(0);
  if (level == 1) return sb.toString();
  return sb.insert(0,"(").append(")").append("*").append(level).toString();
} 
