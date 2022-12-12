//주민등록번호_JYS
import java.util.Scanner;

public class Fourth {

    public static final String RESET = "\u001B[0m";    
    public static final String FONT_GREEN = "\u001B[32m";    

    public static void main(String[] args) {

        System.out.println("[주민등록번호 계산]");

        Scanner sc = new Scanner(System.in);

        System.out.print("출생년도를 입력해 주세요. (yyyy) : ");
        int birth_year = sc.nextInt();

        System.out.print(RESET + "출생월을 입력해 주세요. (mm) : ");
        int birth_month = sc.nextInt();

        System.out.print(RESET + "출생일을 입력해 주세요. (dd) : ");
        int birth_date = sc.nextInt();

        System.out.print(RESET + "성별을 입력해 주세요. (m/f) : ");
        char sex = sc.next().trim().charAt(0);

        String first_chunk = String.format("%d%d%d",birth_year, birth_month, birth_date).substring(2);

        int random_value = (int) (Math.random() * (999999 - 100000 + 1)) + 100000;

        if (sex == 'm') {
            random_value += 3000000;
        } else {
            random_value += 4000000;
        }

        sc.close();

        String ans = String.format(first_chunk + " - %d", random_value);
        System.out.println(RESET + ans);

        //String id_num = first_chunk + random_value
    }
}
