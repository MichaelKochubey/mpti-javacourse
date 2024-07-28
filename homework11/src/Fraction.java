public class Fraction implements Fractionable {
    int num;
    int denum;
    Double value = null;

    public Fraction(int num, int denum) {
        this.num = num;
        this.denum = denum;
    }

    @Override
    public double doubleValue() {
        if (value == null) {
            value = (double) num/denum;
            System.out.println("Evaluation");
            return value;
        }
        else {
            return value;
        }
    }

    @Override
    public void setNum(int num) {
        this.num = num;
        value = null;
    }

    @Override
    public void setDenum(int denum) {
        if (denum == 0) throw new IllegalArgumentException("Denum can't be equal to zero");
        this.denum = denum;
        value = null;
    }
}

class Example {
    public static void main(String[] args) {
        Fraction fr = new Fraction(1,3);
        fr.doubleValue(); // Evaluation
        fr.doubleValue();
        fr.setNum(2);
        fr.doubleValue(); // Evaluation
        fr.doubleValue();
        fr.doubleValue();
        fr.setDenum(5);
        fr.doubleValue(); // Evaluation
    }
}