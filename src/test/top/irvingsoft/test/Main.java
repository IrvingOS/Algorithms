package top.irvingsoft.test;

import java.util.Scanner;

public class Main {

    // public static void main(String[] args) {
    //     Scanner scan = new Scanner(System.in);
    //     int m = scan.nextInt();
    //     int n = scan.nextInt();
    //     int k = scan.nextInt();
    //     List<Integer> stones = new ArrayList<>();
    //     for (int i = 0; i < k; i++) {
    //         int x = scan.nextInt() - 1;
    //         int y = scan.nextInt() - 1;
    //         stones.add(x * 100000 + y);
    //     }
    //     int[] row = new int[m];
    //     int[] col = new int[n];
    //     row[0] = 1;
    //     col[0] = 1;
    //     for (int i = 1; i < m; i++) {
    //         int key = i * 100000;
    //         if (stones.contains(key)) {
    //             row[i] = 0;
    //         } else {
    //             row[i] = row[i - 1];
    //         }
    //     }
    //     for (int i = 1; i < n; i++) {
    //         int key = i;
    //         if (stones.contains(key)) {
    //             col[i] = 0;
    //         } else {
    //             col[i] = col[i - 1];
    //         }
    //     }
    //     for (int i = 1; i < m; i++) {
    //         for (int j = 1; j < n; j++) {
    //             int key = i * 100000 + j;
    //             if (stones.contains(key)) {
    //                 row[i] = 0;
    //                 col[j] = 0;
    //             } else {
    //                 int val = row[i] + col[j];
    //                 row[i] = val;
    //                 col[j] = val;
    //             }
    //         }
    //     }
    //     System.out.print(col[n - 1]);
    // }

    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] prices = new int[n];
        int[] sales = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scan.nextInt();
        }
        for(int i = 0; i < n; i++) {
            sales[i] = scan.nextInt();
        }
        int m = scan.nextInt();
        int[][] closes = new int[m][2];
        for(int j = 0; j < 2; j++) {
            for(int i = 0; i < m; i++) {
                closes[i][j] = scan.nextInt();
            }
        }
        // PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {});
        // for (int i = 0; i < m; i++) {
        //
        // }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int sale = 0;
        for(int i = 0; i < n; i++) {
            count += prices[i];
            sale += sales[i];
            int close = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++) {
                if(closes[j][0] > count) {
                    break;
                }
                if(count - closes[j][1] < close) {
                    close = count - closes[j][1];
                }
            }
            //System.out.println(i + " : " + sale + " : " + close);
            if(sale == count && close == Integer.MAX_VALUE) {
                sb.append("B");
            } else if(sale < close) {
                sb.append("Z");
            } else if(sale > close) {
                sb.append("M");
            } else {
                sb.append("B");
            }
        }
        System.out.println(sb);
    }*/

    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int t = scan.nextInt();
        StringBuilder str = new StringBuilder(scan.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = (int) Math.ceil(i / t);
            char ch = str.charAt(index - 1);
            str.deleteCharAt(index - 1);
            sb.append(ch);
        }
        System.out.println(sb);
    }*/

    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m1 = scan.nextInt();
        int m2 = scan.nextInt();
        int[][] game = new int[m1][2];
        int[][] old = new int[m2][2];
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < m1; i++) {
                game[i][j] = scan.nextInt();
            }
        }
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < m2; i++) {
                old[i][j] = scan.nextInt();
            }
        }
        int[] diffGame = new int[n];
        int[] diffOld = new int[n];
        for (int i = 0; i < m1; i++) {
            diffGame[game[i][0] - 1] += diffGame[game[i][0] - 1] == 1 ? 0 : 1;
            diffGame[game[i][1]] -= diffGame[game[i][1]] == -1 ? 0 : 1;
        }
        for (int i = 0; i < m2; i++) {
            diffOld[old[i][0] - 1] += diffOld[old[i][0] - 1] == 1 ? 0 : 1;
            diffOld[old[i][1]] -= diffOld[old[i][1]] == -1 ? 0 : 1;
        }
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = diffGame[i] + diffOld[i];
        }
        int result = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += diff[i];
            if (count == 2) {
                result++;
            }
        }
        System.out.println(result);
    }*/

    private static int count;
    private static int k1;
    private static int k2;
    private static int maxSum;
    private static int n;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k1 = scan.nextInt();
        k2 = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        dfs(nums, 0, 0);
        System.out.println(maxSum + " " + count);
    }

    private static void dfs(int[] nums, int start, int sum) {
        if (start == n) {
            if (sum % k1 == 0 && sum % k2 != 0) {
                if (maxSum < sum) {
                    maxSum = sum;
                }
                count++;
            }
            return;
        }
        dfs(nums, start + 1, sum + nums[start]);
        dfs(nums, start + 1, sum);
    }

}
