class Solution:
    def findMaxDiff(self, arr):
        stk=[0]
        tmp=[]
        for ve in arr:
            while stk and ve<=stk[-1]:
                stk.pop()
            tmp.append(stk[-1])
            stk.append(ve)
        stk=[0]
        mx=-1
        for ix in range(len(arr)-1,-1,-1):
            while stk and arr[ix]<=stk[-1]:
                stk.pop()
            mx=max(mx,abs(tmp[ix]-stk[-1]))
            stk.append(arr[ix])
        return mx

#{ 
 # Driver Code Starts
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().split()))
        ob = Solution()
        print(ob.findMaxDiff(arr))

# } Driver Code Ends