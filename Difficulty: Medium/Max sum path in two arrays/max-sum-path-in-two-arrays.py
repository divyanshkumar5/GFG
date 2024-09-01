#Your task is to complete this function
#Function should return an integer denoting the required answer
class Solution:
    def maxPathSum(self, arr1, arr2):
        arr1, arr2 = [0] + arr1, [0] + arr2
        s1, s2 = 0, 0
        while arr1 or arr2:
            if arr1[-1] == arr2[-1]:
                s1 = s2 = max(s1, s2) + arr1.pop()
                arr2.pop()
            elif arr1[-1] > arr2[-1]:
                s1 += arr1.pop()
            else:
                s2 += arr2.pop()
        return max(s1, s2)

#{ 
 # Driver Code Starts
if __name__ == "__main__":
    t = int(input().strip())
    for _ in range(t):
        arr1 = list(map(int, input().strip().split()))
        arr2 = list(map(int, input().strip().split()))
        ob = Solution()
        ans = ob.maxPathSum(arr1, arr2)
        print(ans)

# } Driver Code Ends