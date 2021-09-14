package algorithm.weekchallenge.level1;

// 위클리 챌린지
// 2주차_상호평가
public class week_2 {
    public static void main(String[] args) {

        // "FBABD"
        int[][] scores1 = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};

        // "DA"
        int[][] scores2 = {{50,90},{50,87}};

        // "CFD"
        int[][] scores3 = {{70,49,90},{68,50,38},{73,31,100}};

        week_2 a = new week_2();
        System.out.println(a.solution(scores1));

    }

    public String solution(int[][] scores) {
        String answer = "";

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                int score = scores[i][j];
                System.out.println(score);
            }
        }

        return answer;
    }
}
