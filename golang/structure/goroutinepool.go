package structure

import (
	"fmt"
	"time"
)

type Task struct {
	f func() error
}

func (t Task) Execute() {
	_ = t.f()
}

func NewTask(f func() error) *Task {
	return &Task{f: f}
}

type Pool struct {
	EntryChannel chan *Task
	JobChannel   chan *Task
	workerNum    int
}

func (p Pool) Run() {
	//
	for i := 0; i < p.workerNum; i++ {
		go p.worker(i)
	}

	for task := range p.EntryChannel {
		p.JobChannel <- task
	}

	close(p.JobChannel)
	close(p.EntryChannel)
}

func (p Pool) worker(id int) {
	for task := range p.JobChannel {
		task.Execute()
		fmt.Println("worker id ", id, " done")
	}
}

func NewPool(cap int) *Pool {
	return &Pool{
		EntryChannel: make(chan *Task),
		JobChannel:   make(chan *Task),
		workerNum:    cap,
	}
}

func main() {
	t := NewTask(func() error {
		fmt.Println(time.Now())
		return nil
	})

	pool := NewPool(3)

	go func() {
		for {
			pool.EntryChannel <- t
		}
	}()

	pool.Run()
}
