package top.irvingsoft.algs4.searching.symboltables;

/**
 * @author TimeChaser
 * @since 2021/11/29 18:20
 */
public class Time implements Comparable<Time> {

    private final String timeString;
    private final int    hour;
    private final int    min;
    private final int    sec;
    private final long   timeInterval;

    public Time(String time) {
        if (!time.matches("\\d{1,2}:\\d{1,2}:\\d{1,2}")) {
            throw new IllegalArgumentException("不合法的时间格式");
        }
        timeString = time;
        String[] cmp = time.split(":");
        hour = Integer.parseInt(cmp[0]);
        min = Integer.parseInt(cmp[1]);
        sec = Integer.parseInt(cmp[2]);
        if (hour < 0 || hour > 23 ||
                min < 0 || min > 59 ||
                sec < 0 || sec > 59) {
            throw new IllegalArgumentException("不合法的时间范围");
        }
        timeInterval = hour * 60 * 60 + min * 60 + sec;
    }

    @Override
    public int compareTo(Time t) {
        return Long.compare(timeInterval, t.timeInterval);
    }

    @Override
    public String toString() {
        return "Time{" +
                "timeString='" + timeString + '\'' +
                '}';
    }
}
