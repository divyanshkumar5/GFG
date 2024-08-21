#User function Template for python3

class Solution:
    def shortestPath(self, edges, n, m, src):
        # code here
        from collections import defaultdict
        
        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        
        visited = set([src])
        q = [src]
        ans = [-1]*n
        d = 0
        while q:
            nq = []
            for e in q:
                ans[e] = d
                for nbr in g[e]:
                    if nbr not in visited:
                        nq.append(nbr)
                        visited.add(nbr)
            q = nq
            d += 1
        return ans


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        n, m = map(int, input().strip().split())
        edges=[]
        for i in range(m):
            li=list(map(int,input().split()))
            edges.append(li)
        src=int(input())
        ob = Solution()
        ans = ob.shortestPath(edges,n,m,src)
        for i in ans:
            print(i,end=" ")
        print()
        tc -= 1
# } Driver Code Ends