#User function Template for python3

class Solution:
    def sum_of_middle_elements(self, arr1, arr2):
        n = len(arr1)
        
        if n == 0:
            return 0
        
        if arr1[-1] <= arr2[0]:
            # Case where arr1 is completely on the left of arr2
            return arr1[-1] + arr2[0]
        
        if arr2[-1] <= arr1[0]:
            # Case where arr2 is completely on the left of arr1
            return arr2[-1] + arr1[0]
        
        # Binary search to find the right partition
        low, high = 0, n
        while low <= high:
            mid1 = (low + high) // 2
            mid2 = n - mid1
            
            left1 = arr1[mid1 - 1] if mid1 > 0 else float('-inf')
            right1 = arr1[mid1] if mid1 < n else float('inf')
            
            left2 = arr2[mid2 - 1] if mid2 > 0 else float('-inf')
            right2 = arr2[mid2] if mid2 < n else float('inf')
            
            if left1 <= right2 and left2 <= right1:
                return max(left1, left2) + min(right1, right2)
            elif left1 > right2:
                high = mid1 - 1
            else:
                low = mid1 + 1
        
        return -1  # Just in case no solution found, though it shouldn't happen

#{ 
 # Driver Code Starts
#Initial Template for Python 3

import sys

input = sys.stdin.read


def main():
    input_lines = input().strip().split("\n")
    t = int(input_lines[0])

    index = 1
    results = []
    while t > 0:
        arr = list(map(int, input_lines[index].strip().split()))
        brr = list(map(int, input_lines[index + 1].strip().split()))
        index += 2

        solution = Solution()
        res = solution.sum_of_middle_elements(arr, brr)
        results.append(res)

        t -= 1

    for result in results:
        print(result)


if __name__ == "__main__":
    main()

# } Driver Code Ends