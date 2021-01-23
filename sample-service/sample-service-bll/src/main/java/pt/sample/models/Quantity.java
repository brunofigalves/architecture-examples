package pt.sample.models;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Quantity {
    private int value;
    @Transient
    private int lowerBound = 0;
    @Transient
    private int upperBound = 1000;

    protected Quantity() {
        // Only for use of JPA
    }

    public Quantity(int value) throws Exception {
        if(value < lowerBound || value > upperBound) {
            throw new Exception();
        }

        this.value = value;
    }

    public static Quantity zero() throws Exception {
        return new Quantity(0);
    }

    public static Quantity valueOf(int n) throws Exception {
        return new Quantity(n);
    }

    public static Quantity valueOf(Long n) throws Exception {
        return new Quantity(Math.toIntExact(n));
    }

    public Integer value() {
        return this.value;
    }

    public void add(Quantity q) throws Exception {
        if((this.value + q.value()) < lowerBound || (this.value + q.value()) > upperBound) {
            throw new Exception();
        }
        this.value += q.value();
    }

    public void minus(Quantity q) throws Exception {
        if((this.value - q.value()) < lowerBound || (this.value - q.value()) > upperBound) {
            throw new Exception();

        }
        this.value -= q.value();
    }
}