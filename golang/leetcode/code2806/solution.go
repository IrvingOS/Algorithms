package code3067

func accountBalanceAfterPurchase(purchaseAmount int) int {
	a := purchaseAmount / 10
	more := (a + 1) * 10
	less := a * 10
	if more-purchaseAmount <= purchaseAmount-less {
		return 100 - more
	} else {
		return 100 - less
	}
}
