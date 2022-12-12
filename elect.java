//당선 프로그램_JYS
import java.util.*;
import java.util.Map.Entry;

public class Sixth {
  
    public static void main(String[] args) {

        int total_count = 0;

        Map<Integer, Integer> candidate_count = new HashMap<>();
        candidate_count.put(0, 0);
        candidate_count.put(1, 0);
        candidate_count.put(2, 0);
        candidate_count.put(3, 0);

        double total_rate = 0.0;
        double rate_L = 0.0;
        double rate_Y = 0.0;
        double rate_S = 0.0;
        double rate_A = 0.0;

        Random random = new Random();

        String name;

        for (int i = 0; i < 10000; i++) {
            int vote = random.nextInt(4);
            total_count++;
            total_rate = (double) total_count / (double) 10000;
            candidate_count.replace(vote, candidate_count.get(vote), candidate_count.get(vote) + 1);

            switch (vote) {
                case 0:
                    name = "이재명";
                    break;

                case 1:
                    name = "윤석열";
                    break;

                case 2:
                    name = "심상정";
                    break;

                default:
                    name = "안철수";
                    break;
            }

            if (candidate_count.get(0) != 0) {
                rate_L = (double) candidate_count.get(0) / (double) total_count * 100;
            }
            if (candidate_count.get(1) != 0) {
                rate_Y = (double) candidate_count.get(1) / (double) total_count * 100;
            }
            if (candidate_count.get(2) != 0) {
                rate_S = (double) candidate_count.get(2) / (double) total_count * 100;
            }
            if (candidate_count.get(3) != 0) {
                rate_A = (double) candidate_count.get(3) / (double) total_count * 100;
            }

            System.out.printf("[투표진행율]: %.2f", total_rate);
            System.out.print("%");
            System.out.printf(", %d명 투표 => %s\n", total_count, name);
            System.out.printf("[기호:1] 이재명: %05.2f, (투표수: %d)\n", rate_L, candidate_count.get(0));
            System.out.printf("[기호:2] 윤석열: %05.2f, (투표수: %d)\n", rate_Y, candidate_count.get(1));
            System.out.printf("[기호:3] 심상정: %05.2f, (투표수: %d)\n", rate_S, candidate_count.get(2));
            System.out.printf("[기호:4] 안철수: %05.2f, (투표수: %d)\n", rate_A, candidate_count.get(3));

            if (i != 9999) {
                try {
                    Thread.sleep(500);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        List<Entry<Integer, Integer>> list_entries = new ArrayList<Entry<Integer, Integer>>(candidate_count.entrySet());

        Collections.sort(list_entries, new Comparator<Entry<Integer, Integer>>() {
            public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        String elected;

        switch (list_entries.get(0).getKey()) {
            case 0:
                elected = "이재명";
                break;

            case 1:
                elected = "윤석열";
                break;

            case 2:
                elected = "심상정";
                break;

            default:
                elected = "안철수";
                break;
        }

        System.out.printf("[투표결과] 당선인 : %s", elected);
        System.out.println();

    }
}
