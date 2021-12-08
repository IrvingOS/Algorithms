package top.irvingsoft.algs4.fundamentals.dataabstraction;

/**
 * 日期
 *
 * @author TimeChaser
 * @since 2021/12/8 18:24
 */
public class Date {

    private static final int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final        int   month;
    private final        int   day;
    private final        int   year;

    public Date(int month, int day, int year) {
        if (!isValid(month, day, year)) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public Date(String date) {
        String[] fields = date.split("/");
        if (fields.length != 3) {
            throw new IllegalArgumentException("Invalid date");
        }
        month = Integer.parseInt(fields[0]);
        day = Integer.parseInt(fields[1]);
        year = Integer.parseInt(fields[2]);
    }

    public int day() {
        return day;
    }

    public boolean isAfter(Date that) {
        return compareTo(that) > 0;
    }

    public boolean isBefore(Date that) {
        return compareTo(that) < 0;
    }

    public int month() {
        return month;
    }

    public Date next() {
        if (isValid(month, day + 1, year)) {
            return new Date(month, day + 1, year);
        } else if (isValid(month + 1, 1, year)) {
            return new Date(month + 1, 1, year);
        } else {
            return new Date(1, 1, year + 1);
        }
    }

    public int year() {
        return year;
    }

    private int compareTo(Date that) {
        if (this.year < that.year) {
            return -1;
        }
        if (this.year > that.year) {
            return 1;
        }
        if (this.month < that.month) {
            return -1;
        }
        if (this.month > that.month) {
            return 1;
        }
        if (this.day < that.day) {
            return -1;
        }
        if (this.day > that.day) {
            return 1;
        }
        return 0;
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    private boolean isValid(int month, int day, int year) {
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > DAYS[month]) {
            return false;
        }
        return month != 2 || day != 29 || isLeapYear(year);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Date that = (Date) obj;
        return this.month == that.month && this.day == that.day && this.year == that.year;
    }

    @Override
    public int hashCode() {
        return day + 31 * month + 31 * 12 * year;
    }
}
