//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static String armstrongNumber(int n) {

        int hundredsPlace = n / 100;
        int tensPlace = (n / 10) % 10;
        int unitsPlace = n % 10;


        int sumOfCubes = (hundredsPlace * hundredsPlace * hundredsPlace) +
                         (tensPlace * tensPlace * tensPlace) +
                         (unitsPlace * unitsPlace * unitsPlace);

        if (sumOfCubes == n) {
            return "true";
        } else {
            return "false";
        }
    }
}