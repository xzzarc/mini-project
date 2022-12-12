//달력 프로그램_장연숙
import java.util.Calendar;
import java.util.Scanner;

public class Fifth {

    public static final String RESET = "\u001B[0m";    

    public static void main(String[] args) {

        System.out.println("[달력 출력 프로그램]");

        Scanner sc = new Scanner(System.in);

        System.out.print("달력의 년도를 입력해 주세요. (yyyy) : ");
        int year = sc.nextInt();

        System.out.print(RESET + "달력의 월을 입력해 주세요. (mm) : ");
        int month = sc.nextInt();

        int startDayOfWeek = 0;
        int endDay = 0;

        System.out.printf(RESET + "\n\n2022[%d년 %d월]\n", year, month);
        System.out.println();

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        
        start.set(year, month - 1, 1);
        end.set(year, month, 1);
        end.add(Calendar.DATE, -1);
        
        startDayOfWeek = start.get(Calendar.DAY_OF_WEEK);
        endDay = end.get(Calendar.DATE);

        System.out.println("일\t월\t화\t수\t목\t금\t토");
        System.out.println();

        for(int q = 1 ; q < startDayOfWeek ; q++) {
            System.out.print("\t");
        }
        
        int cnt = startDayOfWeek - 1;
        for(int q = 1 ; q <= endDay ; q++) {
            System.out.printf("%02d\t", q);
            cnt ++;
            if(cnt == 7) {
                cnt = 0;
                System.out.println("\n");
            }
        }
        System.out.println();
        sc.close();

       
    }
}
