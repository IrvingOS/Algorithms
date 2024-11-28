package code2516

func takeCharacters(s string, k int) int {
	if k == 0 {
		return 0
	}
	cnt, n := [3]int{}, len(s)
	for _, c := range s {
		switch c {
		case 'a':
			cnt[0]++
		case 'b':
			cnt[1]++
		case 'c':
			cnt[2]++
		}
	}
	if cnt[0] < k || cnt[1] < k || cnt[2] < k {
		return -1
	}
	tar := [3]int{}
	for i := range cnt {
		tar[i] = cnt[i] - k
	}
	res := n
	for i, j, cnt := 0, 0, [3]int{}; j < n; j++ {
		var flag uint8
		for ; j < n && (cnt[0] <= tar[0] && cnt[1] <= tar[1] && cnt[2] <= tar[2]); j++ {
			out := false
			switch s[j] {
			case 'a':
				cnt[0]++
				if cnt[0] > tar[0] {
					flag = 'a'
					out = true
					break
				}
			case 'b':
				cnt[1]++
				if cnt[1] > tar[1] {
					flag = 'b'
					out = true
					break
				}
			case 'c':
				cnt[2]++
				if cnt[2] > tar[2] {
					flag = 'c'
					out = true
					break
				}
			}
			if out {
				break
			}
		}
		res = min(res, n-(j-i))
		for i < n {
			switch s[i] {
			case 'a':
				cnt[0]--
			case 'b':
				cnt[1]--
			case 'c':
				cnt[2]--
			}
			i++
			if s[i-1] == flag {
				break
			}
		}
	}
	return res
}
