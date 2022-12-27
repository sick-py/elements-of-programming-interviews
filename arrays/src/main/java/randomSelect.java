import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class randomSelect {
    public static void main(String[] args) {

        int n = args.length;
        int[] ques = new int[n];
        for (int i = 0; i < n; i++) {
            ques[i] = Integer.parseInt(args[i]);
        }
        int index = select(ques);
        System.out.println("Then:");
        ques[index - 1] = 1;
        select(ques);
    }

    private static int select(int[] ques) {
        int n = ques.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= ques.length; i++) {
            preSum[i] = preSum[i - 1] + ques[i - 1];
        }
        Random gen = new Random();
        int target = gen.nextInt(preSum[n]) + 1;
        int res = left_bound(preSum, target);
        System.out.printf("Let's talk about the %dth question!!\n", res);
        return res;
    }

    private static int left_bound(int[] preSum, int target) {
        int left = 0, right = preSum.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (preSum[mid] == target) {
                right = mid - 1;
            }else if (preSum[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

}
