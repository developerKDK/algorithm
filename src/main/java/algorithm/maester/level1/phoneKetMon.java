package algorithm.maester.level1;

import java.util.*;

// 찾아라 프로그래밍 마에스터
// 폰켓몬
public class phoneKetMon {
    public static void main(String[] args) {

        // 2
        int[] nums1 = {3,1,2,3};

        // 3
        int[] nums2 = {3,3,3,2,2,4};

        // 2
        int[] nums3 = {3,3,3,2,2,2};

        phoneKetMon a = new phoneKetMon();
        System.out.println(a.solution(nums1));

    }

    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // 최대로 가질수 있는 포켓몬 수
        int number = nums.length / 2;

        if (set.size() > number) {
            return number;
        }

        return set.size();
    }
}
