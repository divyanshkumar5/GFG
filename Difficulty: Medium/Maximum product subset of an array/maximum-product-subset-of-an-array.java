//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    final static int mod = 1000000007;
    
    public long findMaxProduct(List<Integer> arr) {
        int n = arr.size();
        if (n == 1) return arr.get(0);
        
        // Sort the array
        Collections.sort(arr);
        
        long max_product = 1;
        int zero_count = 0;
        int negative_count = 0;
        int max_negative = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 0) {
                zero_count++;
                continue;
            }
            
            if (arr.get(i) < 0) {
                negative_count++;
                max_negative = Math.max(max_negative, arr.get(i));
            }
            
            max_product = (max_product * arr.get(i)) % mod;
        }
        
        // If all numbers were zero
        if (zero_count == n) return 0;
        
        // If count of negative numbers is odd
        if (negative_count % 2 == 1) {
            // If there were more than one negative number and no positive numbers, 
            // remove the largest negative number from the product
            if (negative_count != 1 || zero_count > 0 || zero_count + negative_count != n)
                max_product = (max_product / max_negative) % mod;
        }
        
        return max_product;
    }
}