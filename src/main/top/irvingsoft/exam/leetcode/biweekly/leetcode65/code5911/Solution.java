package top.irvingsoft.exam.leetcode.biweekly.leetcode65.code5911;

/**
 * 模拟行走机器人 ⅱ
 *
 * @author TimeChaser
 * @since 2021/11/13 22:39
 */
public class Solution {

}

class Robot {

    private final int     maxX;
    private final int     maxY;
    private       int     x;
    private       int     y;
    private       DIREnum dirEnum;

    public Robot(int width, int height) {
        this.x = 0;
        this.y = 0;
        this.maxX = width - 1;
        this.maxY = height - 1;
        this.dirEnum = DIREnum.East;
    }

    public String getDir() {
        return this.dirEnum.dir;
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public void move(int num) {
        if (num > (this.maxX + 1) * 2 + (this.maxY - 1) * 2) {
            if ((this.x == 0 && this.y == 0)
                    || (this.x == 0 && this.y == this.maxY)
                    || (this.x == this.maxX && this.y == 0)
                    || (this.x == this.maxX && this.y == this.maxY)) {
                this.dirEnum = this.dirEnum.getPre();
            }
        }
        num %= (this.maxX + 1) * 2 + (this.maxY - 1) * 2;
        System.out.println(num);
        /*while (num > 0) {
            if (this.x + num * this.dirEnum.x > this.maxX
                    || this.x + num * this.dirEnum.x < 0
                    || this.y + num * this.dirEnum.y > this.maxY
                    || this.y + num * this.dirEnum.y < 0) {
                int numDecrease;
                if (this.dirEnum.x != 0) {
                    numDecrease = this.dirEnum.x == 1 ? this.maxX - this.x : this.x;
                    this.x = this.dirEnum.x == 1 ? this.maxX : 0;
                } else {
                    numDecrease = this.dirEnum.y == 1 ? this.maxY - this.y : this.y;
                    this.y = this.dirEnum.y == 1 ? this.maxY : 0;
                }
                num -= numDecrease;
                this.dirEnum = this.dirEnum.getNext();
            } else {
                this.x += num * this.dirEnum.x;
                this.y += num * this.dirEnum.y;
                break;
            }
        }*/

        for (int i = 0; i < num; i++) {
            if (this.x + this.dirEnum.x > this.maxX
                    || this.x + this.dirEnum.x < 0
                    || this.y + this.dirEnum.y > this.maxY
                    || this.y + this.dirEnum.y < 0) {
                this.dirEnum = this.dirEnum.getNext();
            }
            this.x += this.dirEnum.x;
            this.y += this.dirEnum.y;
        }
    }

    public enum DIREnum {

        /**
         * 方向枚举
         */
        East("East", 1, 0),
        North("North", 0, 1),
        West("West", -1, 0),
        South("South", 0, -1);

        private final String dir;
        private final int    x;
        private final int    y;

        DIREnum(String dir, int x, int y) {
            this.dir = dir;
            this.x = x;
            this.y = y;
        }

        DIREnum getNext() {
            switch (this) {
                case East:
                    return North;
                case North:
                    return West;
                case West:
                    return South;
                case South:
                    return East;
                default:
                    break;
            }
            return East;
        }

        DIREnum getPre() {
            switch (this) {
                case East:
                    return South;
                case North:
                    return East;
                case West:
                    return North;
                case South:
                    return West;
                default:
                    break;
            }
            return East;
        }
    }
}