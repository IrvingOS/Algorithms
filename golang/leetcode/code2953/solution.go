package code2953

func countCompleteSubstrings(word string, k int) (res int) {
	for i, j, n := 0, 0, len(word); i < n; i = j {
		for j++; j < n && abs(int(word[j])-int(word[j-1])) <= 2; j++ {
		}
		res += f(word[i:j], k)
	}
	return res
}

func f(s string, k int) (res int) {
	for m := 1; m <= 26 && k*m <= len(s); m++ {
		cnt := [26]int{}
		check := func() {
			for i := range cnt {
				if cnt[i] > 0 && cnt[i] != k {
					return
				}
			}
			res++
		}
		for right, in := range s {
			cnt[in-'a']++
			if left := right - k*m + 1; left >= 0 {
				check()
				cnt[s[left]-'a']--
			}
		}
	}
	return
}

func abs(x int) int {
	if x >= 0 {
		return x
	}
	return -x
}
