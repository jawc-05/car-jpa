/**
 * @author jawc
 */
package br.com.jawc.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
    @SequenceGenerator(name="car_seq", sequenceName = "seq_car", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String model;

    @ManyToOne
    private Brand brand;

    @ManyToMany
    @JoinTable(
            name = "tb_car_accesories",
            joinColumns = {@JoinColumn(name = "id_car_fk")},
            inverseJoinColumns = {@JoinColumn(name = "id_accessories_fk")}
    )
    private List<Accessories> accesories;

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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Accessories> getAccesories() {
        return accesories;
    }

    public void setAccesories(List<Accessories> accesories) {
        this.accesories = accesories;
    }
}
