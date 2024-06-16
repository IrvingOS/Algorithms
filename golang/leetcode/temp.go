package leetcode

import "sort"

func maximumTotalDamage(power []int) int64 {
	n := len(power)
	sort.Ints(power)
	dp := make([]int64, n)
	dp[0] = int64(power[0])
	res := int64(power[0])

	for i := 1; i < n; i++ {
		dp[i] = int64(power[i])
		pre := int64(0)
		if power[i] == power[i-1] {
			pre = dp[i-1]
		} else {
			cnt := make(map[int]bool)
			for j := i - 1; j >= 0; j-- {
				if power[i] > power[j]+2 {
					cnt[power[j]] = true
					pre = max(pre, dp[j])
				}
				if len(cnt) == 5 {
					break
				}
			}
		}
		dp[i] += pre
		res = max(res, dp[i])
	}
	return res
}

func countOfPeaks(nums []int, queries [][]int) []int {
	n := len(nums)
	upper := make([]int, n)
	for i := 1; i < n-1; i++ {
		if nums[i] > nums[i-1] && nums[i] > nums[i+1] {
			upper[i] = 1
		}
	}
	var res []int
	for _, query := range queries {
		if query[0] == 1 {
			cnt := 0
			for i, j := query[1]+1, query[2]-1; i <= j; i++ {
				cnt += upper[i]
			}
			res = append(res, cnt)
		} else {
			index, value := query[1], query[2]
			nums[index] = value
			for i := max(index-1, 1); i <= index+1 && i < n-1; i++ {
				if nums[i] > nums[i-1] && nums[i] > nums[i+1] {
					upper[i] = 1
				} else {
					upper[i] = 0
				}
			}
		}
	}
	return res
}

// 1 6 6 7
// 2, 2, 3, 5, 7, 8, 9, 9, 10, 10

// [1,1,3,4]
//[7,1,6,6]
//[1, 3, 6, 7]
//[2, 2, 3, 5, 7, 8, 9, 9, 10, 10]
