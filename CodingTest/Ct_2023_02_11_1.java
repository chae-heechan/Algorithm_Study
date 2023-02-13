class Ct1 {
    public static void main(String[] args) {
        String a = "aaa";
        char[] c = a.toCharArray();

        System.out.println(c);
    }

    public int solution(int[][] lotteries) {
        double[] rate = new double[lotteries.length];
        double max_rate = 0.0;
        int max_price = 0;
        int max_index = 0;

        for (int i = 0; i < lotteries.length; i++) {

            rate[i] = (double)lotteries[i][0] / (double)(lotteries[i][1]+1) * 100.0;
            if ((int)rate[i] >= 100){
                rate[i] = 100.0;
            }

            if (max_rate < rate[i]){
                max_rate = rate[i];
                max_price = lotteries[i][2];
                max_index = i;
            }else if (max_rate == rate[i]){
                if (max_price < lotteries[i][2]){
                    max_rate = rate[i];
                    max_price = lotteries[i][2];
                    max_index = i;
                }
            }


        }

        return max_index+1;


    }
}