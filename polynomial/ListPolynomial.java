package hus.oop.polynomial;

import java.util.*;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        coefficients = new ArrayList<>();
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     * @return
     */
    @Override
    public double coefficient(int index) {
        if (index >= 0 && index < coefficients.size()) {
            return coefficients.get(index);
        } else {
            return 0.0;
        }
    }

    /**
     * Lấy các hệ số của đa thức.
     * @return
     */
    @Override
    public double[] coefficients() {
        double[] result = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            result[i] = coefficients.get(i);
        }
        return result;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức hiện tại.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial append(double coefficient) {
        coefficients.add(coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial insert(double coefficient, int index) {
        if (index >= 0 && index <= coefficients.size()) {
            coefficients.add(index, coefficient);
        }
        return this;
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial set(double coefficient, int index) {
        if (index >= 0 && index < coefficients.size()) {
            coefficients.set(index, coefficient);
        }
        return this;
    }

    /**
     * Lấy ra bậc của đa thức.
     * @return
     */
    @Override
    public int degree() {
        return coefficients.size() - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return
     */
    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * Math.pow(x, i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public Polynomial derivative() {
        ListPolynomial derivative = new ListPolynomial();
        for (int i = 1; i < coefficients.size(); i++) {
            derivative.append(coefficients.get(i) * i);
        }
        return derivative;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plus(ListPolynomial another) {
        int maxSize = Math.max(coefficients.size(), another.coefficients.size());
        for (int i = 0; i < maxSize; i++) {
            double coeffThis = (i < coefficients.size()) ? coefficients.get(i) : 0;
            double coeffAnother = (i < another.coefficients.size()) ? another.coefficients.get(i) : 0;
            this.set(coeffThis + coeffAnother, i);
        }
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minus(ListPolynomial another) {
        int maxSize = Math.max(coefficients.size(), another.coefficients.size());
        for (int i = 0; i < maxSize; i++) {
            double coeffThis = (i < coefficients.size()) ? coefficients.get(i) : 0;
            double coeffAnother = (i < another.coefficients.size()) ? another.coefficients.get(i) : 0;
            this.set(coeffThis - coeffAnother, i);
        }
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiply(ListPolynomial another) {
        ListPolynomial result = new ListPolynomial();
        for (int i = 0; i < coefficients.size(); i++) {
            for (int j = 0; j < another.coefficients.size(); j++) {
                int newDegree = i + j;
                double newCoeff = result.coefficient(newDegree) + coefficients.get(i) * another.coefficient(j);
                result.set(newCoeff, newDegree);
            }
        }
        return result;
    }
}
