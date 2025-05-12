import java.util.*;

class Solution {
    public String largestMultipleOfThree(int[] digits) {
        List<Integer>[] mods = new List[3];
        for (int i = 0; i < 3; i++) mods[i] = new ArrayList<>();

        int total = 0;
        for (int d : digits) {
            mods[d % 3].add(d);
            total += d;
        }

        int remainder = total % 3;
        if (remainder != 0) {
            if (!removeDigits(mods, remainder)) {
                return "";
            }
        }

        List<Integer> all = new ArrayList<>();
        for (List<Integer> group : mods) {
            all.addAll(group);
        }

        Collections.sort(all, Collections.reverseOrder());

        if (all.isEmpty()) return "";
        if (all.get(0) == 0) return "0"; // all zeros

        StringBuilder sb = new StringBuilder();
        for (int d : all) sb.append(d);
        return sb.toString();
    }

    private boolean removeDigits(List<Integer>[] mods, int rem) {
        if (!mods[rem].isEmpty()) {
            mods[rem].sort(Comparator.naturalOrder());
            mods[rem].remove(0);
            return true;
        } else {
            int other = 3 - rem;
            if (mods[other].size() >= 2) {
                mods[other].sort(Comparator.naturalOrder());
                mods[other].remove(0);
                mods[other].remove(0);
                return true;
            }
        }
        return false;
    }
}
