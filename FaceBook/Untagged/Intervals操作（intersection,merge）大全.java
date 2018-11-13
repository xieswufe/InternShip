
// Intervals求交集
public List<Interval> Intersection(List<Interval> interval1,List<Interval> interval2) {
        List<Interval> result = new ArrayList<Interval>();
        if (interval1 == null || interval2 == null || interval1.size() == 0 || interval2.size() == 0) {
            return result;
        }
        Comparator<Interval> comp = new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if (i1.start == i2.start) {
                    return i1.end - i2.end;
                }
                return i1.start - i2.start;
            }
        };
        Collections.sort(interval1,comp);
        Collections.sort(interval2,comp);
        int i1pos = 0;
        int i2pos = 0;
        while (i1pos < interval1.size() && i2pos < interval2.size()) {
            Interval i1curt = interval1.get(i1pos);
            Interval i2curt = interval2.get(i2pos);
            if (i1curt.start > i2curt.end) {
                i2pos ++;
            }
            else if (i2curt.start > i1curt.end) {
                i1pos ++;
            }
            else {
                int start = Math.max(i1curt.start, i2curt.start);
                int end = Math.min(i1curt.end, i2curt.end);
                result.add(new Interval(start, end));
                if (i1curt.end > i2curt.end) {
                    i2pos++;
                } else if (i2curt.end > i1curt.end) {
                    i1pos++;
                } else {
                    i1pos++;
                    i2pos++;
                }
            }
        }
        return result;
    }
    
    // merge interval (单一list) 正常解法
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        Comparator<Interval> comp = new Comparator<Interval>() {
        public int compare(Interval i1, Interval i2) {
            if (i1.start == i2.start) {
                return i1.end - i2.end;
            }
            return i1.start - i2.start;
        }
        };
        Collections.sort(intervals,comp);
        int pos = 0;
        int res_pos = -1;
        while (pos < intervals.size()) {
            Interval curt = intervals.get(pos);
            if (res_pos == -1 || curt.start > result.get(res_pos).end) {
                result.add(curt);
                res_pos ++;
            }
            else {
                result.get(res_pos).end = Math.max(result.get(res_pos).end,curt.end);
            }
            pos ++;
        }
        return result;
    } 
    
   // merge interval(单一list) inplace 解法
   public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 1) return intervals;
        Comparator<Interval> cmp = new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                if (i1.start == i2.start) return i1.end - i2.end;
                return i1.start - i2.start;
            }
        };
        Collections.sort(intervals,cmp);
        int slow = 0;
        int fast = 1;
        while (fast < intervals.size()) {
            Interval curt = intervals.get(fast);
            Interval prev = intervals.get(slow);
            if (curt.start <= prev.end) {
                prev.start = Math.min(curt.start,prev.start);
                prev.end = Math.max(curt.end,prev.end);
            }
            else {
                slow ++;
                intervals.get(slow).start = curt.start;
                intervals.get(slow).end = curt.end;
            }
            fast ++;
        }
        int poi = intervals.size() - 1;
        while (poi > slow) {
            intervals.remove(poi--);
        }
        return intervals;
    }
    
    
    
   
   // merge interval lists
    public List<Interval> mergeList(List<Interval> l1, List<Interval> l2) {
    int pos1 = 0;
    int pos2 = 0;
    List<Interval> result = new ArrayList<>();
    Collections.sort(l1,(a,b) -> a.start - b.start);
    Collections.sort(l2,(a,b) -> a.start - b.start);
    while (pos1 < l1.size() || pos2 < l2.size()) {
      if (pos1 == l1.size() || pos2 < l2.size() && l2.get(pos).start <= l1.get(pos1).start) {
        merge(result,l2.get(pos2++));
      }
      else {
        merge(result,l1.get(pos1++));
      }
    }
    return result;
  }
  public void merge(List<Interval> res, Interval curt) {
    if (res.isEmpty() || res.get(res.size() - 1).end < curt.start) {
      res.add(curt);
    }
    else {
      res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end,curt.end);
    }
  }
