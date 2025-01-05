/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each list to the heap
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }

        // Dummy node to help build the result list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Process the hea
        while (!heap.isEmpty()) {
            // Extract the smallest node from the heap
            ListNode smallest = heap.poll();
            current.next = smallest;
            current = current.next;

            // Add the next node of the extracted list to the heap
            if (smallest.next != null) {
                heap.add(smallest.next);
            }
        }

        // Return the merged list
        return dummy.next;
    }
}
