#User function Template for python3


class Solution:
    
    #Function to find the maximum number of cuts.
   def maximizeTheCuts(self,n,x,y,z):
        #code here
        dp = [float('-inf')]*(n+1)
        dp[0] = 0
        for l in range(1, n+1):
            for s in [x, y, z]:
                if l >= s:
                    dp[l] = max(dp[l], dp[l-s]+1)
        return dp[-1] if dp[-1] != float('-inf') else 0

#{ 
 # Driver Code Starts
#Initial Template for Python 3

#contributed by RavinderSinghPB
if __name__ == '__main__':
    t=int(input())
    for tcs in range(t):
        n=int(input())
        x,y,z=[int(x) for x in input().split()]
        
        print(Solution().maximizeTheCuts(n,x,y,z))
# } Driver Code Ends