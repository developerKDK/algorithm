package algorithm.summber_winter.level1;

import java.util.*;

// Summer/Winter Coding(~2018)
// 소수 만들기
public class sosu {
    public static void main(String[] args) {

        // 1
        int[] nums1 = {1,2,3,4};

        // 4
        int[] nums2 = {1,2,7,6,4};

        sosu a = new sosu();
        System.out.println(a.solution(nums2));

    }

    public int solution(int[] nums) {
        int answer = 0;

        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    number.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

//        System.out.println(number);

        for(Integer numbers : number) {
            int count = 0;
            for(int i = 2; i <= Math.sqrt(numbers); i++) {
                // 소수가 아닐경우
                if(numbers % i == 0) {
                    count++;
                }
            }
            if (count == 0) {
                answer++;
            }
        }

        return answer;
    }

    public int solution2(int[] nums) {
        int answer = 0;

        for (int a = 0; a < nums.length; a++) {
            for (int b = (a + 1); b <nums.length; b++) {
                for (int c = (b + 1); c < nums.length; c++) {
                    int sum = nums[a] + nums[b] + nums[c];
                    boolean confirm = true;
                    for (int i = 2; i < sum; i++) {
                        if (sum % i == 0) {
                            confirm = false;
                        }
                    }
                    if (confirm) answer++;
                }
            }
        }

        return answer;
    }
}
