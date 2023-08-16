public class MyDate {
    private int day;
    private int month;
    private int year;

    final int JANUARY = 1;
    final int FEBRUARY = 2;
    final int MARCH = 3;
    final int APRIL = 4;
    final int MAY = 5;
    final int JUNE = 6;
    final int JULY = 7;
    final int AUGUST = 8;
    final int SEPTEMBER = 9;
    final int OCTOBER = 10;
    final int NOVEMBER = 11;
    final int DECEMBER = 12;

    public MyDate() {}

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String display() {
        return day + "/" + month + "/" + year;
    }

    public void nextDay() {
        int nextDay = this.day + 1;
        if(nextDay <= getDayOfMonth(this.month,this.year)){
            this.day = nextDay;
        } else {
            this.day = 1;
            if(this.month == DECEMBER) {
                this.month = 1;
                this.year += 1;
            } else {
                this.month += 1;
            }
        }
    }

    public int getDayOfMonth(int month, int year) {


        switch (month) {
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> {
                return 31;
            }
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> {
                return 30;
            }
            case FEBRUARY -> {
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            }
            default -> {
                return 1;
            }
        }
    }

    public boolean isLeapYear(int year) {
        if(year % 4 == 0) {
            if(year % 100 == 0) {
                if (year % 400 == 0)
                    return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
