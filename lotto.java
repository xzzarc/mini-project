//로또 프로그램_JYS
import java.util.*;

public class Seventh {

    public static final String RESET = "\u001B[0m";
    public static final String FONT_GREEN = "\u001B[32m";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Lotto lot = new Lotto();

        ArrayList<ArrayList<Integer>> lottos = new ArrayList<>();
        ArrayList<Integer> target_lotto = new ArrayList<>();

        System.out.println("[로또 당첨 프로그램]\n\n");
        System.out.print("로또 개수를 입력해 주세요. (숫자 1 ~ 10) : " + FONT_GREEN);

        int num_of_lotto = sc.nextInt();

        System.out.print(RESET + "\n");

        sc.close();

        for (int i = 0; i < num_of_lotto; i++) {

            char n = (char) (65 + i);
            System.out.print(n + "\t");

            lottos.add(lot.lotto_generate(6));
            System.out.print("\n");
        }

        System.out.println("\n\n[로또 발표]\n");

        System.out.print("\t");

        target_lotto = lot.lotto_generate(6);

        System.out.println("\n\n[내 로또 결과]\n");

        for (int i = 0; i < lottos.size(); i++) {

            char n = (char) (65 + i);
            System.out.print(n + "\t");

            ArrayList<Integer> current_lotto = lottos.get(i);
            lot.print_lotto(current_lotto);

            int count = 0;

            for (Integer integer : current_lotto) {

                if ( target_lotto.contains(integer)) {
                    count++;
                }
            }

            System.out.printf(" => %d개 일치", count);
            System.out.print("\n");
        }

        System.out.println();

    }

}

class Lotto {

    public ArrayList<Integer> lotto_generate(int num_lotto) {

        ArrayList<Integer> lotto = new ArrayList<>();
        Random random = new Random();

        while (lotto.size() < num_lotto) {
            int num = random.nextInt(45) + 1;

            if (!lotto.contains(num)) {
                lotto.add(num);
            }
        }

        Collections.sort(lotto);

        print_lotto(lotto);

        return lotto;
    }

    public void print_lotto(ArrayList<Integer> lotto) {

        for (int j = 0; j < lotto.size(); j++) {

            System.out.printf("%02d", lotto.get(j));

            if (j != 5) {
                System.out.print(", ");
            }
        }
    }
}
