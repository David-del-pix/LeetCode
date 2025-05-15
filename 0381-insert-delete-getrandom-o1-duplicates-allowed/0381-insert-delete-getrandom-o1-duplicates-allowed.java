import java.util.*;

class RandomizedCollection {
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random rand;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        boolean isNew = !map.containsKey(val);

        map.computeIfAbsent(val, k -> new HashSet<>()).add(list.size());
        list.add(val);

        return isNew;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }

        // Get an index of the value to remove
        int indexToRemove = map.get(val).iterator().next();
        map.get(val).remove(indexToRemove);

        int lastIndex = list.size() - 1;
        int lastVal = list.get(lastIndex);

        // If we're not removing the last element, move the last element to the place of the removed element
        if (indexToRemove != lastIndex) {
            list.set(indexToRemove, lastVal);
            map.get(lastVal).remove(lastIndex);
            map.get(lastVal).add(indexToRemove);
        }

        // Remove last element
        list.remove(lastIndex);

        // Clean up the map
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }

        return true;
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}
