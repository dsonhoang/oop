package hus.oop.polynomial;

import java.util.Arrays;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 2;
    private double[] coefficients;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        coefficients = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        if (index >= 0 && index < size) {
            return coefficients[index];
        } else {
            return 0.0;
        }
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        return Arrays.copyOf(coefficients, size);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient Hệ số cần thêm vào đa thức.
     * @return Đa thức hiện tại.
     */
    public ArrayPolynomial append(double coefficient) {
        if (size == coefficients.length) {
            enlarge();
        }
        coefficients[size++] = coefficient;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient Hệ số cần thêm vào đa thức.
     * @param index Vị trí cần thêm vào.
     * @return Đa thức hiện tại.
     */
    public ArrayPolynomial insert(double coefficient, int index) {
        if (index >= 0 && index <= size) {
            if (size == coefficients.length) {
                enlarge();
            }
            System.arraycopy(coefficients, index, coefficients, index + 1, size - index);
            coefficients[index] = coefficient;
            size++;
        }
        return this;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     * @param coefficient Hệ số mới.
     * @param index Vị trí cần sửa.
     * @return Đa thức hiện tại.
     */
    public ArrayPolynomial set(double coefficient, int index) {
        if (index >= 0 && index < size) {
            coefficients[index] = coefficient;
        }
        return this;
    }

    /**
     * Lấy bậc của đa thức.
     * @return Bậc của đa thức.
     */
    @Override
    public int degree() {
        return size - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return Giá trị của đa thức khi x = x.
     */
    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public Polynomial derivative() {
        ArrayPolynomial derivative = new ArrayPolynomial();
        for (int i = 1; i < size; i++) {
            derivative.append(coefficients[i] * i);
        }
        return derivative;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another Đa thức cần cộng vào.
     * @return Đa thức hiện tại.
     */
    public ArrayPolynomial plus(ArrayPolynomial another) {
        int maxSize = Math.max(size, another.size);
        for (int i = 0; i < maxSize; i++) {
            double coeffThis = (i < size) ? coefficients[i] : 0;
            double coeffAnother = (i < another.size) ? another.coefficients[i] : 0;
            this.set(coeffThis + coeffAnother, i);
        }
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another Đa thức cần trừ đi.
     * @return Đa thức hiện tại.
     */
    public ArrayPolynomial minus(ArrayPolynomial another) {
        int maxSize = Math.max(size, another.size);
        for (int i = 0; i < maxSize; i++) {
            double coeffThis = (i < size) ? coefficients[i] : 0;
            double coeffAnother = (i < another.size) ? another.coefficients[i] : 0;
            this.set(coeffThis - coeffAnother, i);
        }
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another Đa thức cần nhân vào.
     * @return Đa thức hiện tại.
     */
    public ArrayPolynomial multiply(ArrayPolynomial another) {
        ArrayPolynomial result = new ArrayPolynomial();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < another.size; j++) {
                int newDegree = i + j;
                double newCoeff = result.coefficient(newDegree) + coefficients[i] * another.coefficient(j);
                result.set(newCoeff, newDegree);
            }
        }
        return result;
    }

    /**
     * Thêm kích thước để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        int newCapacity = coefficients.length * 2;
        coefficients = Arrays.copyOf(coefficients, newCapacity);
    }
}