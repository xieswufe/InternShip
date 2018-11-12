/*  rules 
    1. pure numbers: we need to check if the first place of the string is '0'. if it is '0', 
    we need to check the length of the string. if not, return true
    2. including spaces, if the spaces are in the head or the tail of the string, return true, 
    if the spaces are in the mid of the string, return false.if string  only include + -, return false
    3. including positive/ negative sign: the sign could only exist once, no matter it is 
    positive or negative, if they exist more than once, return false
    4. including dot: dot can exist in the start of the string, which equals to "0.xxxxxx", 
    and it can exist in the end of string, it equals to "xxxxx.0" which are both
       valid. but if dot exist more than once or the string only contains dot, return false; 
    5. if the string only contains spaces or it's length == 0, return false

    */
    public boolean validNumber(String number) {
        number = number.trim();
        if (number.length() == 0) return false;
        int pos = 0;
        boolean meetNum = false;
        boolean meetDot = false;

        if (pos < number.length() && (number.charAt(pos) == '+' || number.charAt(pos) == '-'))  pos ++;
        if (pos == number.length()) return false;
        if (pos < number.length() && number.charAt(pos) == '0') return pos == number.length() - 1;
        while (pos < number.length()) {
            char curt = number.charAt(pos);
            if (Character.isDigit(curt)) {
                meetNum = true;
            }
            else if (curt == '.') {
                if (meetDot) return false;
                if (!meetNum && pos == number.length() - 1) return false;
                meetDot = true;
            }
            else {
                return false;
            }
            pos ++;
        }
        return true;
    }
