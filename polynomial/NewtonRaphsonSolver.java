package hus.oop.polynomial;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance Độ chính xác mong muốn của nghiệm.
     * @param maxIterations Số lần lặp tối đa.
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của đa thức sử dụng phương pháp Newton-Raphson.
     * @param polynomial Đa thức cần tìm nghiệm.
     * @param lower Giới hạn dưới của khoảng nghiệm.
     * @param upper Giới hạn trên của khoảng nghiệm.
     * @return Nghiệm của đa thức.
     */
    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        double x0 = (lower + upper) / 2;
        double x = x0;
        int iterations = 0;

        while (iterations < maxIterations) {
            double fx = polynomial.evaluate(x);
            double fPrimeX = polynomial.derivative().evaluate(x);

            if (Math.abs(fx) < tolerance) {
                return x;
            }

            if (Math.abs(fPrimeX) < tolerance) {
                throw new ArithmeticException("Derivative is too close to zero.");
            }

            x = x - fx / fPrimeX;

            if (x < lower || x > upper) {
                throw new ArithmeticException("Solution is outside the specified interval.");
            }

            iterations++;
        }

        throw new ArithmeticException("Newton-Raphson method did not converge within the specified number of iterations.");
    }
}