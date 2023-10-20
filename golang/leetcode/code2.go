package main

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	var head *ListNode
	var cur *ListNode
	sum := 0
	for l1 != nil || l2 != nil {
		val1, val2 := 0, 0
		if l1 != nil {
			val1 = l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			val2 = l2.Val
			l2 = l2.Next
		}
		sum += val1 + val2
		if head == nil {
			head = &ListNode{
				Val: sum % 10,
			}
			cur = head
		} else {
			cur.Next = &ListNode{
				Val: sum % 10,
			}
			cur = cur.Next
		}
		sum /= 10
	}
	if sum != 0 {
		cur.Next = &ListNode{
			Val: sum,
		}
	}
	return head
}

func main() {

}
