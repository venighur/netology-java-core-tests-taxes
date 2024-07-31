package ru.netology;

public class Taxes {
    public static int taxEarnings(int earnings) {
        return earnings * 6 / 100;
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        }
        return 0;
    }
}
