// 正常版本 
public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a,b) -> (a.start - b.start));
        PriorityQueue<Interval> minheap = new PriorityQueue<>((a,b) -> (a.end - b.end));
        int res = 0;
        for (int i = 0; i < intervals.length; i++) {
            Interval curt = intervals[i];
            if (!minheap.isEmpty() && minheap.peek().end <= curt.start) {
                minheap.poll();
            }
            minheap.offer(curt);
            res = Math.max(res, minheap.size());
        }
        return res;
    }

////scan line
private class Point {
        int pos;
        boolean using;
        
        private Point(int pos, boolean using) {
            this.pos = pos;
            this.using = using;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        // check corner cases 
        if (intervals  == null || intervals.length == 0) {
            return 0;
        }
        List<Point> points = new ArrayList<Point>();
        for (Interval item : intervals) {
            points.add(new Point(item.start,true));
            points.add(new Point(item.end,false));
        }
        Collections.sort(points, new Comparator<Point>() {
           public int compare(Point p1, Point p2) {
               if (p1.pos == p2.pos) {
                   if (p1.using) {
                       return 1;
                   }
                   else {
                       return -1;
                   }
               }
               return p1.pos - p2.pos;
           } 
        });
        int maxRoom = 0;
        int curRoom = 0;
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).using) {
                curRoom ++;
            }
            else {
                curRoom --;
            }
            maxRoom = Math.max(curRoom,maxRoom);
        }
        return maxRoom;
    }

////////////
// 带房间号码
private  static class Room {
    Interval timeSlot;
    int roomNum;
    public Room(Interval timeSlot, int roomNum) {
      this.roomNum = roomNum;
      this.timeSlot = timeSlot;
    }
  }
  
public List<List<Interval>> allowRooms(List<Interval> intervals) {
    List<List<Interval>> result = new ArrayList<>();
    if (intervals.size() == 0) return result;
    Collections.sort(intervals, (a,b) -> a.start - b.start);
    PriorityQueue<Room> rooms = new PriorityQueue<>((a,b) -> a.timeSlot.end - b.timeSlot.end);
    int roomCode = 0;
    int curtRoom = 0;
    List<Interval> curtList = null;
    for (int i = 0; i < intervals.size(); i++) {
       Interval curt = intervals.get(i);
       if (!rooms.isEmpty()) { 
         if (curt.start >= rooms.peek().timeSlot.end) {
         curtRoom = rooms.poll().roomNum;
         }
         else {
        curtRoom = ++roomCode;
         }             
      }
      rooms.offer(new Room(curt,curtRoom));
      if (curtRoom >= result.size()) result.add(new ArrayList<>());
      curtList = result.get(curtRoom);
      if (curtList.isEmpty() || curtList.get(curtList.size() - 1).end < curt.start) {
        curtList.add(curt);
      }
      else {
        curtList.get(curtList.size() - 1).end = curt.end;
      }
    }
    return result;
  }
