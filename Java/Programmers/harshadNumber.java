package Programmers;

class HarshadNumber {
    public boolean solution(int x) {
        int sum = 0;
        String str = Integer.toString(x);
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - 48;
        }

        return x % sum == 0;
    }
}