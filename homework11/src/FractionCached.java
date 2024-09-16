public class FractionCached implements Fractionable {
    Fraction f1;
    Double cachedValue = null;
    public FractionCached(Fraction fraction) {
        this.f1 = fraction;
        cachedValue = fraction.doubleValue();
    }
    @Override
    public double doubleValue() {
        if (cachedValue == null) throw new IllegalArgumentException("No cached value");
        return cachedValue;
    }

    @Override
    public void setNum(int num) {
        f1.setNum(num);
        cachedValue = f1.doubleValue();
    }

    @Override
    public void setDenum(int denum) {
        f1.setDenum(denum);
        cachedValue = f1.doubleValue();
    }
}

class Example {
    public static void main(String[] args) {
        Fraction f = new Fraction(1,2);
        FractionCached fc = new FractionCached(f);
        fc.doubleValue();
        fc.doubleValue();
        fc.setNum(2);
        fc.doubleValue();
        fc.doubleValue();
    }
}