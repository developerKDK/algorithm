package algorithm.maester.level1;

// 찾아라 프로그래밍 마에스터
// 폰켓몬
public class pocketmon {
    public static void main(String[] args) {

        int price = 3;
        int money = 20;
        int count = 4;

        pocketmon a = new pocketmon();
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
