// Insert Delete GetRandom O(1)

class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> map;
    Random rand;

    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int idx = map.get(val);
        if (idx < nums.size() - 1) {
            int lastVal = nums.get(nums.size() - 1);
            nums.set(idx, lastVal);
            map.put(lastVal, idx);
        }
        map.remove(val);
        nums.remove(nums.size()-1);
    }

    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}