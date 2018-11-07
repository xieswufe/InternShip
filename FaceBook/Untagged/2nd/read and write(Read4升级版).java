class ReadWrite{
  char[] buffer;
  private final int SIZE;
  int l,r;
  
  public ReadWrite(int n) {
    buffer = new char[n];
    SIZE = n;
    l = r = -1;
  }
  public int read(char[] buff, int cnt) {
    int count = 0;
    while (count < cnt && l <= r) {
      buff[count++] = buffer[l % SIZE];
      l = l+1;
    }
    if (l == r + 1) l = -1;
    return count;
  }
  public int write(String input) {
    int writenum = 0;
    while (writenum < input.length() && (r+1) % SIZE != l % SIZE) {
      r = r+1;
      if (l == -1) l = r;
      buffer[r % SIZE] = input.charAt(writenum++);
    }
    return writenum;
  }
}
