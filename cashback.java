//캐시백 계산_JYS
import java.util.Scanner;

public class Second {

    public static final String RESET = "\u001B[0m";      

    public static void main(String[] args) {

        System.out.println("[캐시백 계산]");

        Scanner sc = new Scanner(System.in);

        System.out.print("결제 금액을 입력해 주세요. (금액) : ");

        int amount = sc.nextInt();
        int cashback;

        if (amount >= 3000) {
            cashback = 300;
        } else if (amount >= 2000) {
            cashback = 200;
        } else if (amount >= 1000) {
            cashback = 100;
        } else {
            cashback = 0;
        }

        sc.close();

        String ans = String.format("결제 금액은 %d원이고, 캐시백은 %d원 입니다. ", amount, cashback);
        System.out.println(RESET + ans);
    }
}
