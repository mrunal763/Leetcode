class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Step 1: Count frequency of each number
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a HashSet to find unique frequency counts
        Set<Integer> freqSet = new HashSet<>(freqMap.values());

        // Step 3: If sizes match, every frequency was unique
        return freqMap.size() == freqSet.size();
    }
}