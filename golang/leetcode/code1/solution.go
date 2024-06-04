package code1

func twoSum(nums []int, target int) []int {
	n := len(nums)
	diff := make(map[int]int)
	for i := 0; i < n; i++ {
		if j, ok := diff[target-nums[i]]; ok {
			return []int{i, j}
		}
		diff[nums[i]] = i
	}
	return nil
}

func main() {

}
