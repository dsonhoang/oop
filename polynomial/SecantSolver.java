package hus.oop.polynomial;

public class SecantSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance Độ chính xác mong muốn của nghiệm.
     * @param maxIterations Số lần lặp tối đa.
     */
    public SecantSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của đa thức theo phương pháp Secant
     * @param polynomial Đa thức cần tìm nghiệm.
     * @param lower Giới hạn dưới của khoảng nghiệm.
     * @param upper Giới hạn trên của khoảng nghiệm.
     * @return Nghiệm của đa thức trong khoảng [lower, upper].
     */
    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        double x0 = lower;
        double x1 = upper;
        int iterations = 0;

        while (iterations < maxIterations) {
            double fx0 = polynomial.evaluate(x0);
            double fx1 = polynomial.evaluate(x1);

            if (Math.abs(fx1 - fx0) < tolerance) {
                return x1;
            }

            double x2 = x1 - fx1 * (x1 - x0) / (fx1 - fx0);

            if (Math.abs(x2 - x1) < tolerance) {
                return x2;
            }

            x0 = x1;
            x1 = x2;

            iterations++;
        }

        throw new ArithmeticException("Secant method did not converge within the specified number of iterations.");
    }
}