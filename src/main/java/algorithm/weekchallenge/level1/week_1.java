package algorithm.weekchallenge.level1;

// 위클리 챌린지
// 1주차_부족한 금액 계산하기
public class week_1 {
    public static void main(String[] args) {

        int price = 3;
        int money = 20;
        int count = 4;

        week_1 a = new week_1();
        System.out.println(a.solution(price, money, count));

    }

    //long 타입을 잘확인해야 한다.
    public long solution(int price, int money, int count) {
        // 총 이용금액
        long total = 0;

        for (int i = 1; i <= count; i++) {
            total += price * i;
        }

        if ((money - total) <= 0) {
            return total - money;
        }

        return 0;
    }
}
