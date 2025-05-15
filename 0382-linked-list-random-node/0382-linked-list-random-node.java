import java.util.*;

class Solution {
    private ListNode head;
    private Random rand;

    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    public int getRandom() {
        ListNode current = head;
        int result = current.val;
        int index = 1;

        while (current.next != null) {
            current = current.next;
            if (rand.nextInt(++index) == 0) {
                result = current.val;
            }
        }

        return result;
    }
}
