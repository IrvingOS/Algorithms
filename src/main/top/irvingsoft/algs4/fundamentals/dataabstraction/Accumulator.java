package top.irvingsoft.algs4.fundamentals.dataabstraction;

/**
 * 累加器
 *
 * @author TimeChaser
 * @since 2021/12/8 17:41
 */
public class Accumulator {

    private double mu = 0.0;
    private int n = 0;
    private double sum = 0.0;

    public Accumulator() {
    }

    public void addDataValue(double x) {
        n++;
        double delta = x - mu;
        mu += delta / n;
        sum += (double) (n - 1) / n * delta * delta;
    }

    public int count() {
        return n;
    }

    public double mean() {
        return mu;
    }

    public double stddev() {
        return Math.sqrt(this.var());
    }

    public double var() {
        if (n <= 1) {
            return Double.NaN;
        }
        return sum / (n - 1);
    }

    @Override
    public String toString() {
        return "n = " + n + ", mean = " + mean() + ", stddev = " + stddev();
    }

}
