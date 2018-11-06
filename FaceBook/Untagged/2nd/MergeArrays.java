//合并3个array

public int[] mergeArrays(int[] a, int[] b, int[] c) {
    int posa = 0;
    int posb = 0;
    int posc = 0;
    int pos = 0;
    int min;
    int[] res = new int[a.length + b.length + c.length];
    while (posa < a.length || posb < b.length || posc < c.length) {
      if (posc == c.length) {
        if (posa == a.length || (posb < b.length && b[posb] <= a[posa])) res[pos++] = b[posb++];
        else res[pos++] = a[posa++];
      }
      else if (posa == a.length) {
        if (posc == c.length || (posb < b.length && b[posb] <= c[posc])) res[pos++] = b[posb++];
        else res[pos++] = c[posc++];
      }
      else if (posb == b.length) {
        if (posc == c.length || (posa < a.length && a[posa] <= c[posc])) res[pos++] = a[posa++];
        else res[pos++] = c[posc++];
      }
      else {
        min = Math.min(a[posa], Math.min(b[posb], c[posc]));
        if (min == a[posa]) res[pos++] = a[posa++];
        else if (min == b[posb]) res[pos++] = b[posb++];
        else res[pos++] = c[posc++];
      }
    }
    return res;
  }
  
  
  //merge n arrs (heap)
  }
  public List<Integer> mergeArrays(List<int[]> arrs) {
    List<Integer> res = new ArrayList<>();
    PriorityQueue<Node> minheap = new PriorityQueue<>(new Comparator<Node>() {
      public int compare(Node n1, Node n2) {
        return arrs.get(n1.arr_idx)[n1.idx] - arrs.get(n2.arr_idx)[n2.idx];
      }
    }); 
    for (int i = 0; i < arrs.size(); i++) {
      int[] item = arrs.get(i);
      if (item.length != 0) {
        minheap.offer(new Node(i,0));
      }
    }
    while (!minheap.isEmpty()) {
      Node curt = minheap.poll();
      res.add(arrs.get(curt.arr_idx)[curt.idx]);
      if (++curt.idx < arrs.get(curt.arr_idx).length) {
        minheap.add(new Node(curt.arr_idx,curt.idx));
      }
    }
    return res;
  }
  
  private class Node {
    int arr_idx;
    int idx;
    public Node(int arr_idx, int idx) {
      this.arr_idx = arr_idx;
      this.idx = idx;
    }
  }
  
  
// merge k arrs by mergeSort
  public List<Integer> mergeArrays(List<int[]> arrs) {
     return mergeSort(arrs,0,arrs.size() - 1);
  }
  public List<Integer> mergeSort(List<int[]> arrs, int start, int end) {
    List<Integer> res = new ArrayList<>();
    if (start > end) return res;
    if (start == end) {
      for (int item : arrs.get(start))  res.add(item);
      return res;
    }
    int mid = start + (end - start) / 2;
    List<Integer> left = mergeSort(arrs,start,mid);
    List<Integer> right = mergeSort(arrs,mid + 1,end);
    res = merge(left,right);
    return res;
  }
  
  public List<Integer> merge(List<Integer> left, List<Integer> right) {
    List<Integer> res = new ArrayList<>();
    int posl = 0;
    int posr = 0;
    while (posl < left.size() || posr < right.size()) {
      if (posl == left.size() || (posr < right.size() && right.get(posr) <= left.get(posl))) {
        res.add(right.get(posr++));
      }
      else {
        res.add(left.get(posl++));
      }
    } 
    return res;
  }
  
// iterator
class MergeSortedIterator {
  PriorityQueue<ListNode> minheap;
  public MergeSortedIterator(ListNode[] lists) {
    minheap = new PriorityQueue<>((a,b) -> a.val - b.val);
    for (ListNode item : lists) {
      minheap.offer(item);
    }
  }
  public boolean hasNext() {
    return !minheap.isEmpty();
  }
  public int next() {
    ListNode curt = minheap.poll();
    if (curt.next != null) {
      minheap.offer(curt.next);
    }
    return curt.val;
  }
  
