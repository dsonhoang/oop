package hus.oop.polynomial;

public class TestPolynomial {
    public static void main(String[] args) {
        testArrayPolynomial();
        testListPolynomial();
        testRootSolver();
    }

    public static void testArrayPolynomial() {
        // TODO: Write test cases for ArrayPolynomial
        ArrayPolynomial poly1 = new ArrayPolynomial();
        poly1.append(2.0).append(3.0).append(1.0);

        ArrayPolynomial poly2 = new ArrayPolynomial();
        poly2.append(1.0).append(-2.0).append(4.0);

        System.out.println("ArrayPolynomial 1: " + poly1.toString());
        System.out.println("ArrayPolynomial 2: " + poly2.toString());

        ArrayPolynomial sum = poly1.plus(poly2);
        System.out.println("Sum of polynomials: " + sum.toString());

        ArrayPolynomial difference = poly1.minus(poly2);
        System.out.println("Difference of polynomials: " + difference.toString());

        ArrayPolynomial product = poly1.multiply(poly2);
        System.out.println("Product of polynomials: " + product.toString());

        double xValue = 2.0;
        System.out.println("Value of polynomial at x=" + xValue + ": " + poly1.evaluate(xValue));
    }

    public static void testListPolynomial() {
        // TODO: Write test cases for ListPolynomial
        ListPolynomial poly1 = new ListPolynomial();
        poly1.append(2.0).append(3.0).append(1.0);

        ListPolynomial poly2 = new ListPolynomial();
        poly2.append(1.0).append(-2.0).append(4.0);

        System.out.println("ListPolynomial 1: " + poly1.toString());
        System.out.println("ListPolynomial 2: " + poly2.toString());

        ListPolynomial sum = poly1.plus(poly2);
        System.out.println("Sum of polynomials: " + sum.toString());

        ListPolynomial difference = poly1.minus(poly2);
        System.out.println("Difference of polynomials: " + difference.toString());

        ListPolynomial product = poly1.multiply(poly2);
        System.out.println("Product of polynomials: " + product.toString());

        double xValue = 2.0;
        System.out.println("Value of polynomial at x=" + xValue + ": " + poly1.evaluate(xValue));
    }

    public static void testRootSolver() {
        // TODO: Write test cases for RootSolver
        Polynomial polynomial = new ArrayPolynomial().append(-1.0).append(0.0).append(1.0);

        System.out.println("Polynomial: " + polynomial.toString());

        PolynomialRootFinding rootFinding = new PolynomialRootFinding(polynomial);

        double lower = -2.0;
        double upper = 2.0;

        double root = rootFinding.solve(lower, upper);

        System.out.println("Root of the polynomial in the interval [" + lower + ", " + upper + "]: " + root);
    }
}