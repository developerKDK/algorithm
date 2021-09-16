package algorithm.weekchallenge.level1;

// 위클리 챌린지
// 4주차_직업군 추천하기
public class week_4 {
    public static void main(String[] args) {

        // "HARDWARE"
        String[] table1 = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages1 = {"PYTHON", "C++", "SQL"};
        int[] preference1 = {7, 5, 5};

        // "PORTAL"
        String[] table2 = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages2 = {"JAVA", "JAVASCRIPT"};
        int[] preference2 = {7, 5};

        week_4 a = new week_4();
        System.out.println(a.solution(table1, languages1, preference1));

    }

    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";

        for (int i = 0; i < table.length; i++) {
            String[] s = table[i].split(" ");
            for (int k = 0; k < languages.length; k++) {
                int value = 0;
                for (int j = 1; j < s.length; j++) {
//                System.out.println(s[j]);
                    if (s[j].equals(languages[k])) {
//                        System.out.println(s[j]);
//                        System.out.println(languages[k]);
//                        System.out.println(j);
                        value = 6 - j;
                    }
                    System.out.println(value);
                }
            }
        }

        return answer;
    }
}
