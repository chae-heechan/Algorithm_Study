package Programmers;

class Reminder1 {
    public int solution(int n) {
        int answer;

        for (answer = 1; answer < n; answer++) {
            if (n % answer == 1) {
                return answer;
            }
        }

        return answer;
    }
}