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

func maxHeightOfTriangle(red int, blue int) int {
	m, n := min(red, blue), max(red, blue)
	cur1 := 1
	useN := true
	for {
		if useN && n < cur1 {
			break
		} else if !useN && m < cur1 {
			break
		}
		if useN {
			n -= cur1
		} else {
			m -= cur1
		}
		useN = !useN
		cur1++
	}

	m, n = min(red, blue), max(red, blue)
	cur2 := 1
	useN = false
	for {
		if useN && n < cur2 {
			break
		} else if !useN && m < cur2 {
			break
		}
		if useN {
			n -= cur2
		} else {
			m -= cur2
		}
		useN = !useN
		cur2++
	}
	return max(cur1, cur2) - 1
}

// nums = [1,2,3,4,5], k = 2
//
//	1,0,1,0,1
//
// 1 1 1 1
// 5
// nums = [1,4,2,3,1,4], k = 3
//
//	1,1,2,0,1,1
//
// 2,0,2,1,2
// 4
// nums = [1,2,3,10,2], k = 6
//
//	1,2,3,4,2
//
// 2,5,1,0
// 3
func maximumLength(nums []int, k int) int {
	res := 0
	n := len(nums)
	arr := make([]int, n-1)
	for i := 0; i < n-1; i++ {
		arr[i] = (nums[i] + nums[i+1]) % k
	}

	var dfs func(l, r, cur int, s []int)
	dfs = func(l, r, cur int, s []int) {
		if l == r {
			res = max(cur+1, res)
		} else if l > r {
			res = max(cur, res)
			return
		} else {
			if s[l] == s[r] {
				dfs(l+1, r-1, cur+2, s)
			} else {
				dfs(l+1, r, cur, s)
				dfs(l+1, r-1, cur, s)
				dfs(l, r-1, cur, s)
			}
		}
	}

	dfs(0, n-1, 0, nums)
	dfs(0, n-2, 0, arr)

	return res + 1
}

// [8,5,9,9,8,4]
// [4,5,8,8,9,9]
func minOperations(nums []int) int {
	sort.Ints(nums)
	n := len(nums)
	res := n
	for i, j, cnt := 0, 0, make(map[int]int); i < n; i++ {
		for ; j < n && nums[j]-nums[i] < n; j++ {
			cnt[nums[j]]++
		}
		res = min(res, n-len(cnt))
		cnt[nums[i]]--
		if cnt[nums[i]] == 0 {
			delete(cnt, nums[i])
		}
	}
	return res
}
