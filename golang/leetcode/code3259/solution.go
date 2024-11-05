package code3259

func maxEnergyBoost(energyDrinkA []int, energyDrinkB []int) int64 {
	n := len(energyDrinkA)
	dp := make([][]int64, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = make([]int64, 2)
	}
	dp[1][0] = int64(energyDrinkA[0])
	dp[1][1] = int64(energyDrinkB[0])
	for i := 2; i <= n; i++ {
		dp[i][0] = max(dp[i-1][0], dp[i-2][1]) + int64(energyDrinkA[i-1])
		dp[i][1] = max(dp[i-2][0], dp[i-1][1]) + int64(energyDrinkB[i-1])
	}
	return max(dp[n][0], dp[n][1])
}
