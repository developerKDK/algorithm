package algorithm.weekchallenge.level1;

import java.util.*;

// 위클리 챌린지
// 6주차_복서 정렬하기

// 1. 지표를 가지고있는 Player class 작성
class Player {
    int no;
    int weight;
    double winRate;
    int overCount;

    public Player(int no, int weight, double winRate, int overCount) {
        this.no = no;
        this.weight = weight;
        this.winRate = winRate;
        this.overCount = overCount;
    }
}

public class week_6 {
    public static void main(String[] args) {

        // [3,4,1,2]
        int[] weights1 = {50,82,75,120};
        String[] head2head1 = {"NLWL","WNLL","LWNW","WWLN"};

        // [2,3,1]
        int[] weights2 = {145,92,86};
        String[] head2head2 = {"NLW","WNL","LWN"};

        // [2,1,3]
        int[] weights3 = {60,70,60};
        String[] head2head3 = {"NNN","NNN","NNN"};

        week_6 a = new week_6();
        System.out.println(a.solution(weights1, head2head1));

    }

    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        List<Player> records = new ArrayList<>();

        // 2. 각종 지표 구하기(승률, 체급차 승리 횟수) + Player를 List에 담기
        for(int i=0; i<head2head.length; i++) {
            double winCount = 0.0;
            double totalCount = 0.0;
            int overCount = 0;
            char[] recordArray = head2head[i].toCharArray();

            for(int j=0; j<recordArray.length; j++) {
                if(recordArray[j] != 'N') {
                    totalCount++;   // 경기 수
                    if(recordArray[j] == 'W') {
                        winCount++; // 승리 수
                        if(weights[i] < weights[j]) overCount++;    // 체급 차 승리 수
                    }
                }
            }

            double winRate = winCount/totalCount;   // 승률
            Player player = new Player(i+1, weights[i], winRate, overCount);
            records.add(player);
        }

        // 3. 요구사항대로 정렬하기
        Collections.sort(records, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                // 승률 내림차순
                if(p1.winRate > p2.winRate) return -1;
                else if(p1.winRate < p2.winRate) return 1;
                else { // 승률 같다면, 체급 차 승리 수 내림차순
                    if(p1.overCount > p2.overCount) return -1;
                    else if(p1.overCount < p2.overCount) return 1;
                    else { // 같다면, 몸무게 내림차순
                        if(p1.weight > p2.weight) return -1;
                        else if(p1.weight < p2.weight) return 1;
                        else { // 같다면, 번호(이름) 오름차순
                            if(p1.no > p2.no) return 1;
                            else if(p1.no < p2.no) return -1;
                        }
                    }
                }
                return 0;
            }
        });

        // 4. return 배열 만들기(player의 번호)
        for(int i=0; i<records.size(); i++) {
            Player player = records.get(i);
            answer[i] = player.no;
        }

        return answer;
    }

    public int[] solution2(int[] weights, String[] head2head) {
        int leng = weights.length;
        int[] answer = new int[leng];
        double rank[][] = new double[leng][4];

        for(int i=0; i<leng; i++){
            int cnt = leng;
            int wins = 0;
            rank[i][2] = weights[i];
            rank[i][3] = i;
            for(int j=0; j<leng; j++){
                if(i==j || head2head[i].charAt(j) == 'N') cnt--;
                else if(head2head[i].charAt(j) == 'W'){
                    if(weights[i] < weights[j]) rank[i][1]++;
                    wins++;
                }
            }
            if(cnt!=0)rank[i][0] = (double)wins/cnt;
        }

        Arrays.sort(rank, (o1, o2) -> {
            if(o1[0] == o2[0]){
                if(o1[1] == o2[1])
                    return Double.compare(o2[2], o1[2]);
                else
                    return Double.compare(o2[1], o1[1]);
            }else{
                return Double.compare(o2[0], o1[0]);
            }
        });

        for(int i=0; i<leng; i++){
            answer[i] = 1 + (int)rank[i][3];
        }
        return answer;
    }

}
