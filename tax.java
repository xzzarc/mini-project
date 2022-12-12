//세금계산 프로그램_JYS
import java.util.*;

public class Eighth {

    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("[과세금액 계산 프로그램]\n");
        System.out.print("연소득을 입력해 주세요. : ");

        int annual_income = sc.nextInt();

        System.out.print(RESET + "\n");

        sc.close();

        Tax_caculate tc = new Tax_caculate();

        tc.caculate_TaxRate(annual_income);
        tc.caculate_ProgressiveTax(annual_income);

        System.out.println();

    }

}

class Tax_caculate {

    int[] income_brackets = { 12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000 };
    int[] tax_rates = { 6, 15, 24, 35, 38, 40, 42, 45 };
    int[] tax_brackets = { 12000000, 34000000, 42000000, 62000000, 150000000, 200000000, 500000000 };

    public void caculate_TaxRate(int annual_income) {

        int tax = 0;

        if (annual_income <= income_brackets[0]) {

            int level = 0;
            tax += annual_income * tax_rates[level] / 100;

            print_taxrates(annual_income, 6, tax);

        } else if (annual_income <= income_brackets[1]) {

            int rest_amount = annual_income - income_brackets[0];
            int level = 1;

            tax = print_tax(annual_income, rest_amount, level);

        } else if (annual_income <= income_brackets[2]) {

            int rest_amount = annual_income - income_brackets[1];
            int level = 2;

            tax = print_tax(annual_income, rest_amount, level);

        } else if (annual_income <= income_brackets[3]) {

            int rest_amount = annual_income - income_brackets[2];
            int level = 3;

            tax = print_tax(annual_income, rest_amount, level);

        } else if (annual_income <= income_brackets[4]) {

            int rest_amount = annual_income - income_brackets[3];
            int level = 4;

            tax = print_tax(annual_income, rest_amount, level);

        } else if (annual_income <= income_brackets[5]) {

            int rest_amount = annual_income - income_brackets[4];
            int level = 5;

            tax = print_tax(annual_income, rest_amount, level);

        } else if (annual_income <= income_brackets[6]) {

            int rest_amount = annual_income - income_brackets[5];
            int level = 6;

            tax = print_tax(annual_income, rest_amount, level);

        } else {

            int rest_amount = annual_income - income_brackets[6];
            int level = 7;

            tax = print_tax(annual_income, rest_amount, level);

        }

        System.out.println();
        System.out.printf("[세율에 의한 세금]:      \t%d\n", tax);

    }

    public void caculate_ProgressiveTax(int annual_income) {

        Long tax;
        Long annualIncome = (long) annual_income;

        if (annual_income <= income_brackets[0]) {

            tax = annualIncome * tax_rates[0] / 100;

        } else if (annual_income <= income_brackets[1]) {

            tax = annualIncome * tax_rates[1] / 100 - 1080000;

        } else if (annual_income <= income_brackets[2]) {

            tax = annualIncome * tax_rates[2] / 100 - 5220000;

        } else if (annual_income <= income_brackets[3]) {

            tax = annualIncome * tax_rates[3] / 100 - 14900000;

        } else if (annual_income <= income_brackets[4]) {

            tax = annualIncome * tax_rates[4] / 100 - 19400000;

        } else if (annual_income <= income_brackets[5]) {

            tax = annualIncome * tax_rates[5] / 100 - 25400000;

        } else if (annual_income <= income_brackets[6]) {

            tax = annualIncome * tax_rates[6] / 100 - 35400000;

        } else {

            tax = annualIncome * tax_rates[7] / 100 - 65400000;

        }

        System.out.printf("[누진공제 계산에 의한 세금]:\t%d\n", tax);
    }

    public void print_taxrates(int amount, int rate, int total) {

        System.out.printf("%10d * %2d", amount, rate);
        System.out.print("% = ");
        System.out.printf("%10d \n", total);

    }

    public int print_tax(int annual_income, int rest_amount, int level) {

        int tax_rest = rest_amount * tax_rates[level] / 100;
        int tax = tax_rest;

        for (int i = 0; i < level; i++) {
            int tax_phase = tax_brackets[i] * tax_rates[i] / 100;
            tax += tax_phase;
            print_taxrates(income_brackets[i], tax_rates[i], tax_phase);
        }

        print_taxrates(rest_amount, tax_rates[level], tax_rest);

        return tax;
    }
}
