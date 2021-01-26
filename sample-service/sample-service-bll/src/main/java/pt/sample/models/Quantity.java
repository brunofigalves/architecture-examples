package pt.sample.models;

import pt.sample.exceptions.SampleServiceException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Quantity {
    @Column(name = "QUANTITY")
    private Integer value;
    @Transient
    private Integer lowerBound = 0;
    @Transient
    private Integer upperBound = 1000;

    protected Quantity() {
        // Only for use of JPA
    }

    public Quantity(Integer value) throws SampleServiceException {
        if(value < lowerBound || value > upperBound) {
            throw new SampleServiceException();
        }

        this.value = value;
    }

    public static Quantity zero() throws SampleServiceException {
        return new Quantity(0);
    }

    public static Quantity valueOf(Integer n) throws SampleServiceException {
        return new Quantity(n);
    }

    public Integer value() {
        return this.value;
    }

    public void add(Quantity q) throws SampleServiceException {
        if((this.value + q.value()) < lowerBound || (this.value + q.value()) > upperBound) {
            throw new SampleServiceException();
        }
        this.value += q.value();
    }

    public void minus(Quantity q) throws SampleServiceException {
        if((this.value - q.value()) < lowerBound || (this.value - q.value()) > upperBound) {
            throw new SampleServiceException();

        }
        this.value -= q.value();
    }
}