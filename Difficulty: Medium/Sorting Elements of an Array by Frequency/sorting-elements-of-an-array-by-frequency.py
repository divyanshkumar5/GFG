#User function Template for python3
 
from collections import Counter,defaultdict
class Solution:
   
    #Function to sort the array according to frequency of elements.
    def sortByFreq(self,arr):
        num_count  = dict(Counter(arr))
        freq_nums = defaultdict(list)
        for num in num_count:
            freq_nums[num_count[num]].append(num)
        for key,val in freq_nums.items():
            freq_nums[key].sort()
        ans = []
        for key in sorted(freq_nums.keys(),reverse=True):
            for num in freq_nums[key]:
                ans+=[num]*key

        return ans


#{ 
 # Driver Code Starts
#Initial Template for Python 3

import atexit
import io
import sys

_INPUT_LINES = sys.stdin.read().splitlines()
input = iter(_INPUT_LINES).__next__
_OUTPUT_BUFFER = io.StringIO()
sys.stdout = _OUTPUT_BUFFER


@atexit.register
def write():
    sys.__stdout__.write(_OUTPUT_BUFFER.getvalue())


if __name__ == '__main__':
    t = int(input())
    for tt in range(t):

        arr = list(map(int, input().strip().split()))
        l = Solution().sortByFreq(arr)
        print(*l)

# } Driver Code Ends