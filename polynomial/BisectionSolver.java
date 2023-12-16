package hus.oop.polynomial;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance Độ chính xác mong muốn của nghiệm.
     * @param maxIterations Số lần lặp tối đa.
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của đa thức theo phương pháp chia đôi (Bisection)
     * @param polynomial Đa thức cần tìm nghiệm.
     * @param lower Giới hạn dưới của khoảng nghiệm.
     * @param upper Giới hạn trên của khoảng nghiệm.
     * @return Nghiệm của đa thức trong khoảng [lower, upper].
     */
    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        if (polynomial.evaluate(lower) * polynomial.evaluate(upper) > 0) {
            throw new IllegalArgumentException("The signs of the function values at the endpoints must be different.");
        }

        double xMid = 0.0;
        int iterations = 0;

        while ((upper - lower) / 2 > tolerance && iterations < maxIterations) {
            xMid = (lower + upper) / 2;
            double fMid = polynomial.evaluate(xMid);

            if (fMid == 0) {
                return xMid;
            } else if (fMid * polynomial.evaluate(lower) < 0) {
                upper = xMid;
            } else {
                lower = xMid;
            }

            iterations++;
        }

        return xMid;
    }
}