package com.dmdev.hw2;

/**
 Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию Junior Java Developer с зарплатой 600$ в месяц.
 Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 300$ в месяц Ваня тратит на еду и развлечения.
 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.

 Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.

 Для интереса: попробовать увеличить процент, которые Ваня инвестирует из своей зарплаты
 */
public class Task3 {
    public static void main(String[] args) {
        double wage = 600;
        double balance = 0;
        double expenses = 300;
        double investmentBalance = 0;
        int numMonth = 0;

        double investmentSpend;
        double investmentIncome;
        double monthlySpends;

        while (numMonth <= 38) // 3 years, 2 months
        {
            investmentSpend = 0.1 * wage;
            investmentIncome = 1.2 * investmentSpend;
            monthlySpends = expenses + investmentSpend;
            balance = balance + wage - monthlySpends;
            investmentBalance = investmentBalance + investmentIncome;
            numMonth++;
            if (numMonth % 6 == 0){
                wage+=400;
            }
        }
        System.out.println("Balance: "+balance);
        System.out.println("investmentBalance: "+investmentBalance);
    }
}
