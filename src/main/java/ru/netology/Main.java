package ru.netology;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int earnings = 0;
        int spendings = 0;

        while (true) {
            System.out.println("Выберите операцию и введите её номер (или введите end для завершения):");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            String moneyStr;
            int money;

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    moneyStr = scanner.nextLine();
                    money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    moneyStr = scanner.nextLine();
                    money = Integer.parseInt(moneyStr);
                    spendings += money;
                    break;
                case 3:
                    int taxE = Taxes.taxEarnings(earnings);
                    int taxEMS = Taxes.taxEarningsMinusSpendings(earnings, spendings);

                    if (taxE == taxEMS) {
                        System.out.println("Суммы налога в обеих системах равны, можете выбрать любую систему налогообложения");
                    } else {
                        String taxSystem = taxE < taxEMS ? "УСН доходы" : "УСН доходы минус расходы";
                        int taxSaving = Math.abs(taxE - taxEMS);

                        System.out.println("Мы советуем вам " + taxSystem);
                        System.out.println("Ваш налог составит: " + Math.min(taxE, taxEMS) + " рублей");
                        System.out.println("Налог на другой системе: " + Math.max(taxE, taxEMS) + " рублей");
                        System.out.println("Экономия: " + taxSaving + " рублей");
                        System.out.println();
                    }

                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }

        System.out.println("Программа завершена!");
    }
}