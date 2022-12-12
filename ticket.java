//놀이공원 입장권 계산_장연숙
import java.util.Scanner;

public class Third {


    public static final String RESET = "\u001B[0m";    
    public static final String FONT_GREEN = "\u001B[32m";    

    public static void main(String[] args) {

        System.out.println("[입장권 계산]");

        Scanner sc = new Scanner(System.in);

        System.out.print("나이를 입력해 주세요. (숫자) : ");
        int age = sc.nextInt();

        System.out.print(RESET + "입장시간을 입력해 주세요. (숫자입력) : ");
        int entryTime = sc.nextInt();

        System.out.print(RESET + "국가유공자 여부를 입력해 주세요. (y/n) : ");
        char ck_nationalMerit = sc.next().trim().charAt(0);

        System.out.print(RESET + "복지카드 여부를 입력해 주세요. (y/n) : ");
        char ck_welfare = sc.next().trim().charAt(0);

        int price;

        if (age < 3) {
            price = 0;
        } else if (age < 13 || entryTime >= 17) {
            price = 4000;
        } else if (ck_nationalMerit == 'y' || ck_welfare == 'y') {
            price = 8000;
        } else {
            price = 10000;
        }

        sc.close();

        String ans = String.format("입장료: %d", price);
        System.out.println(RESET + ans);
    }
}
