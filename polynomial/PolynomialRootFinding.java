package hus.oop.polynomial;

public class PolynomialRootFinding {
    private Polynomial poly;
    private RootSolver rootSolver;

    /**
     * Khởi tạo đa thức.
     * @param polynomial Đa thức cần tìm nghiệm.
     */
    public PolynomialRootFinding(Polynomial polynomial) {
        this.poly = polynomial;
        this.rootSolver = new NewtonRaphsonSolver(1e-8, 100); // Default to Newton-Raphson solver
    }

    /**
     * Khởi tạo đa thức và phương pháp tìm nghiệm.
     * @param polynomial Đa thức cần tìm nghiệm.
     * @param rootSolver Phương pháp tìm nghiệm.
     */
    public PolynomialRootFinding(Polynomial polynomial, RootSolver rootSolver) {
        this.poly = polynomial;
        this.rootSolver = rootSolver;
    }

    /**
     * Thiết lập đa thức cần tìm nghiệm.
     * @param poly Đa thức cần tìm nghiệm.
     */
    public void setPoly(Polynomial poly) {
        this.poly = poly;
    }

    /**
     * Thiết lập phương pháp tìm nghiệm.
     * @param rootSolver Phương pháp tìm nghiệm.
     */
    public void setRootSolver(RootSolver rootSolver) {
        this.rootSolver = rootSolver;
    }

    /**
     * Tìm nghiệm của đa thức theo phương pháp đã cho.
     * @param lower Giới hạn dưới của khoảng nghiệm.
     * @param upper Giới hạn trên của khoảng nghiệm.
     * @return Nghiệm của đa thức trong khoảng [lower, upper].
     */
    public double solve(double lower, double upper) {
        return rootSolver.solve(poly, lower, upper);
    }
}