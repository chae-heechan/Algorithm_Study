class Solution {
    boolean solution(String s) {
        s = s.toUpperCase();
        int p = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'P') {
                p++;
            } else if (s.charAt(i) == 'Y') {
                y++;
            }
        }
        return (p == y);
    }
}