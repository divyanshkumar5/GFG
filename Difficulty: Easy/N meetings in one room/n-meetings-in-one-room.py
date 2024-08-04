#User function Template for python3

class Solution:
    
    def maximumMeetings(self,n,start,end):
        meeting=list(zip(start, end))
        meeting_sorted = sorted(meeting, key=lambda tup: (tup[1],tup[0]))

        number_m=1
        end_time=meeting_sorted[0][1]
        for i in range(1,len(meeting_sorted)):
            if meeting_sorted[i][0]>end_time:
                end_time=meeting_sorted[i][1]
                number_m+=1
                
        return number_m



#{ 
 # Driver Code Starts
#Initial Template for Python 3
import atexit
import io
import sys

#Contributed by : Nagendra Jha

if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases) :
        n = int(input())
        start = list(map(int,input().strip().split()))
        end = list(map(int,input().strip().split()))
        ob=Solution()
        print(ob.maximumMeetings(n,start,end))
# } Driver Code Ends