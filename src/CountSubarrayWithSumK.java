import java.util.HashMap;
import java.util.Map;
// //https://neetcode.io/problems/subarray-sum-equals-k/question?list=neetcode250
public class CountSubarrayWithSumK {

    static int cntSubarrays(int[] arr, int k) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        int res = 0;
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum == k)
                res++;
            if (prefixSums.containsKey(currSum - k))
                res += prefixSums.get(currSum - k);
            prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0) + 1);
        }

        return res;
    }


    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;
        System.out.println(cntSubarrays(arr, k));
    }
}
