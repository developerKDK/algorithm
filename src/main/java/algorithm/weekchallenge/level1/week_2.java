package algorithm.weekchallenge.level1;

import java.util.HashMap;
import java.util.Map;

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

    //풀이
    //1. 열에서 최대 값 찾기
    //2. 열에서 최소 값 찾기
    //3. 자기 자신의 값과 똑같은 값이 있다면 유일한 최고, 최저 조건이 아님으로 예외
    //4. 평균값으로 학점을 구하는 함수 만들기
    public String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < scores.length; i++) {
            int ownScore = scores[i][i];
            boolean sameScore = true;
            int max = scores[0][i];
            int min = scores[0][i];
            int sum = 0;
            int divide = 0;
            double avg;

            for (int j = 0; j < scores.length; j++) {
                //자기자신의 값과 똑같은 값 찾기
                if (i != j && ownScore == scores[j][i]) {
                    sameScore = false;
                }

                //열 비교
                if (max < scores[j][i]) {
                    max = scores[j][i];
                }
                if (min > scores[j][i]) {
                    min = scores[j][i];
                }

                sum += scores[j][i];
                divide++;
            }

            //유일한 최고, 최저일 경우 제외
            if (sameScore && (max == ownScore || min == ownScore)) {
                sum -= ownScore;
                divide--;
            }

            avg = (double)sum / (double)divide;
            answer.append(getRank(avg));
        }

        return answer.toString();
    }

    public static String getRank(double score) {
        if (score >= 90) {
            return "A";
        }
        if (score >= 80) {
            return "B";
        }
        if (score >= 70) {
            return "C";
        }
        if (score >= 50) {
            return "D";
        }

        return "F";
    }
}
