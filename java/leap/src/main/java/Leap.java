import java.time.LocalDate;

class Leap {

    boolean isLeapYear(int year) {
        return LocalDate.ofYearDay(year, 1).isLeapYear();
    }

}
