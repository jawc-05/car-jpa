/**
 * @author jawc
 */
package br.com.jawc.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_accesories")
public class Accessories {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accesories_seq")
    @SequenceGenerator(name="accesories_seq", sequenceName = "seq_accesories", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(length = 100)
    private String name;

    @ManyToMany(mappedBy = "accesories")
    private List<Car> cars;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
