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
