package pt.tangela.example.persistence.models;

import javax.persistence.*;

@Table(name = "EXAMPLE")
@Entity
public class Example {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "VALUE", length = 50)
    private String value;

    public Example() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
