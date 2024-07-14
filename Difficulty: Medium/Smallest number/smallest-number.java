//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution{
    static String smallestNumber(int s, int d){
    String ans="";
    boolean flag=false;
    if(d*9<s){
        return "-1";
    }
    for(int i=d;i>=1;i--)
    {
        if(flag&&i!=1){
            ans="0"+ans;
        }else if(i==1){
            ans=s+ans;
        }else{
         if(s>9){
             ans="9"+ans;
             s-=9;
         }else{
             ans=(s-1)+""+ans;
             s=1;
             flag=true;
             
         }
            
        }
    }
    
    return ans;
        
    }
}