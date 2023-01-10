class Solution {
    public long solution(long n) {
        Double x = Math.sqrt(n);
        if (x == x.intValue()) {
            return (long) Math.pow(x + 1, 2);
        } else {
            return -1;
        }
    }
}