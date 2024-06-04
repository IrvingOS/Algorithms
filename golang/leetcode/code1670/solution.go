package main

import (
	"container/list"
)

type FrontMiddleBackQueue struct {
	left  *list.List
	right *list.List
}

func Constructor() FrontMiddleBackQueue {
	return FrontMiddleBackQueue{
		left:  list.New(),
		right: list.New(),
	}
}

func (queue *FrontMiddleBackQueue) PushFront(val int) {
	queue.left.PushFront(val)
	if queue.left.Len() == queue.right.Len()+2 {
		queue.right.PushFront(queue.left.Back().Value.(int))
		queue.left.Remove(queue.left.Back())
	}
}

func (queue *FrontMiddleBackQueue) PushMiddle(val int) {
	if queue.left.Len() == queue.right.Len()+1 {
		queue.right.PushFront(queue.left.Back().Value.(int))
		queue.left.Remove(queue.left.Back())
	}
	queue.left.PushBack(val)
}

func (queue *FrontMiddleBackQueue) PushBack(val int) {
	queue.right.PushBack(val)
	if queue.right.Len() == queue.left.Len()+1 {
		queue.left.PushBack(queue.right.Front().Value.(int))
		queue.right.Remove(queue.right.Front())
	}
}

func (queue *FrontMiddleBackQueue) PopFront() int {
	if queue.left.Len() == 0 {
		return -1
	}
	front := queue.left.Front()
	queue.left.Remove(front)
	if queue.left.Len()+1 == queue.right.Len() {
		queue.left.PushBack(queue.right.Front().Value.(int))
		queue.right.Remove(queue.right.Front())
	}
	return front.Value.(int)
}

func (queue *FrontMiddleBackQueue) PopMiddle() int {
	if queue.left.Len() == 0 {
		return -1
	}
	mid := queue.left.Back()
	queue.left.Remove(mid)
	if queue.left.Len()+1 == queue.right.Len() {
		queue.left.PushBack(queue.right.Front().Value.(int))
		queue.right.Remove(queue.right.Front())
	}
	return mid.Value.(int)
}

func (queue *FrontMiddleBackQueue) PopBack() int {
	if queue.left.Len() == 0 {
		return -1
	}
	if queue.right.Len() != 0 {
		back := queue.right.Back()
		queue.right.Remove(back)
		if queue.right.Len()+2 == queue.left.Len() {
			queue.right.PushFront(queue.left.Back().Value.(int))
			queue.left.Remove(queue.left.Back())
		}
		return back.Value.(int)
	} else {
		back := queue.left.Back()
		queue.left.Remove(back)
		return back.Value.(int)
	}
}

func main() {
	a := FrontMiddleBackQueue{}
	println(a.left.Front())
}
