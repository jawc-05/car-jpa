/**
 * @author jawc
 */
package br.com.jawc.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_seq")
    @SequenceGenerator(name="brand_seq", sequenceName = "seq_brand", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "name",  nullable = false, length = 60, unique = true)
    private String name;

    @OneToMany(mappedBy = "brand")
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
