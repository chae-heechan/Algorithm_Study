package Programmers;

import java.util.*;

class Assignment {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        List<String> temp = new ArrayList<>();

        Stack<Plan> stack = new Stack<>();
        int currentTime = 0;

        Arrays.sort(plans, new Comparator<String[]>() {

            @Override
            public int compare(String[] o1, String[] o2) {
                int[] o1Split = Arrays.stream(o1[1].split(":")).mapToInt(Integer::parseInt).toArray();
                int o1Time = o1Split[0] * 60 + o1Split[1];

                int[] o2Split = Arrays.stream(o2[1].split(":")).mapToInt(Integer::parseInt).toArray();
                int o2Time = o2Split[0] * 60 + o2Split[1];
                return o1Time - o2Time;
            }
        });

        for (int i = 0; i < plans.length; i++) {
            Plan newPlan = new Plan(plans[i]);

            if (i == 0){
                stack.push(newPlan);
                currentTime = newPlan.start;
                continue;
            }

            int timeGap = newPlan.start - currentTime;


            while (timeGap > 0 && !stack.isEmpty()){
                Plan oldPlan = stack.pop();
                if (timeGap >= oldPlan.time){
                    timeGap -= oldPlan.time;
                    temp.add(oldPlan.sub);
                } else {
                    oldPlan.time -= timeGap;
                    timeGap = 0;
                    stack.push(oldPlan);
                }
            }
            currentTime = newPlan.start;

            stack.push(newPlan);

        }

        while(!stack.isEmpty()){
            temp.add(stack.pop().sub);
        }

        for (int i = 0; i < plans.length; i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }
}

class Plan {
    String sub;
    int start;
    int time;

    public Plan(String[] plan) {
        this.sub = plan[0];
        int[] timeSplit = Arrays.stream(plan[1].split(":")).mapToInt(Integer::parseInt).toArray();
        this.start = timeSplit[0] * 60 + timeSplit[1];
        this.time = Integer.parseInt(plan[2]);
    }
}