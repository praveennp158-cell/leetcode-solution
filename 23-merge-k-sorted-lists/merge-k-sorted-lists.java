class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return partition(lists, 0, lists.length - 1);
    }

    public ListNode partition(ListNode[] lists, int start, int end) {

        // Only one list
        if (start == end) {
            return lists[start];
        }

        // No lists
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        // Divide
        ListNode left = partition(lists, start, mid);
        ListNode right = partition(lists, mid + 1, end);

        // Conquer: merge the two sorted lists
        return merge(left, right);
    }

    // Merge two sorted linked lists
    public ListNode merge(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}