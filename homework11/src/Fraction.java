public class Fraction implements Fractionable {
    int num;
    int denum;

    public Fraction(int num, int denum) {
        this.num = num;
        this.denum = denum;
    }

    @Override
    public double doubleValue() {
        System.out.println("value");
        return (double) this.num / this.denum;
    }

    @Override
    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void setDenum(int denum) {
        if (denum == 0) throw new IllegalArgumentException("Denum can't be equal to zero");
        this.denum = denum;
    }

    public int getNum() {
        return num;
    }

    public int getDenum() {
        return denum;
    }
}