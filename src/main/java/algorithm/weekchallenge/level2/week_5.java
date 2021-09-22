package algorithm.weekchallenge.level2;

// 위클리 챌린지
// 5주차_모음사전
public class week_5 {
    public static void main(String[] args) {

        //6
        String word1 = "AAAAE";
        //10
        String word2 = "AAAE";
        //1563
        String word3 = "I";
        //1189
        String word4 = "EIO";

        week_5 a = new week_5();
        System.out.println(a.solution2(word1));

    }

    public int solution(String word) {
        int answer = 0, per = 3905;
        for(String s : word.split(""))
            answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        return answer;
    }

    public int solution2(String word) {
        String str = "AEIOU";
        int[] x = {781,156,31,6,1};
        int index,result = word.length();
        for(int i=0; i<word.length(); i++){
            index = str.indexOf(word.charAt(i));
            result += x[i]*index;
        }
        return result;
    }
}
