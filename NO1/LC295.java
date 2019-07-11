/**
 * 295. Find Median from Data Stream
 * https://leetcode.com/problems/find-median-from-data-stream/
 * 
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 

Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */

class MedianFinder {
    PriorityQueue<Long> large;
    PriorityQueue<Long> small;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>(new Comparator<Long>() {
            public int compare(Long a, Long b) {
                return (int)(b-a);
            }
        });
    }
    
    public void addNum(int num) {
        large.add((long)num);
        small.add(large.poll());
        if (large.size() < small.size())
            large.add(small.poll());
    }
    
    public double findMedian() {
        if (large.isEmpty() && small.isEmpty())
            return 0;
        else if (large.size() > small.size())
            return (double)large.peek();
        return (large.peek() + small.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */