import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Ct_2023_06_27_1 {
    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int month = date.getMonthValue();

        List<Integer> months = Arrays.asList(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            months.set(1, 28);
        }

        int days = months.get(month);

        System.out.printf(days + " days for " + year + "-" + (month + 1));
    }
}

