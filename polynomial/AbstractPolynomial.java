package hus.oop.polynomial;

import java.util.Arrays;

public abstract class AbstractPolynomial implements Polynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        int degree = degree();
        StringBuilder polynomialString = new StringBuilder();

        for (int i = degree; i >= 0; i--) {
            double coefficient = coefficient(i);

            if (coefficient != 0) {
                if (polynomialString.length() > 0) {
                    polynomialString.append(" + ");
                }

                if (i == 0) {
                    polynomialString.append(coefficient);
                } else {
                    polynomialString.append(coefficient).append("x");

                    if (i > 1) {
                        polynomialString.append("^").append(i);
                    }
                }
            }
        }

        return polynomialString.toString();
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return Mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        int degree = degree();

        if (degree == 0) {
            return new double[]{0};
        }

        double[] derivativeCoefficients = new double[degree];

        for (int i = 1; i <= degree; i++) {
            derivativeCoefficients[i - 1] = i * coefficient(i);
        }

        return derivativeCoefficients;
    }
}