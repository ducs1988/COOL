// Container With Most Water

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        if (height == null || height.length == 0)
            return maxArea;
        
        int left = 0, right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right-left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
