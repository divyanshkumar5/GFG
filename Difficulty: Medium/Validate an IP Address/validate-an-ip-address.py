#User function Template for python3
class Solution:
    def isValid(self, str):
        parts = str.split(".")
        return len(parts) == 4 and all(part and (len(part) == 1 or part[0] != "0") and 0 <= int(part) <= 255 for part in parts)


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == "__main__":
    t = int(input())
    for _ in range(0, t):
        s = input()
        ob = Solution()
        if (ob.isValid(s)):
            print("true")
        else:
            print("false")

# } Driver Code Ends