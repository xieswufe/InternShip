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
  
  
  
