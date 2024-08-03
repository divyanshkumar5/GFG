class Solution:
    def celebrity(self, mat):
        for i in range(len(mat)):
            a=1
            for j in range(len(mat)):
                if mat[i][j]==1:
                    a=0
                    break
            if a==1:
                for j in range(len(mat)):
                    if i!=j and mat[j][i]==0:
                        a=0
                        break
            if a==1:
                return i
        return -1


#{ 
 # Driver Code Starts
# Main function to handle input and output
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        n = int(input())
        M = []
        for _ in range(n):
            M.append(list(map(int, input().split())))

        ob = Solution()
        print(ob.celebrity(M))

# } Driver Code Ends