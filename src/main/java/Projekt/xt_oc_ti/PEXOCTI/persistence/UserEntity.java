package Projekt.xt_oc_ti.PEXOCTI.persistence;

import javax.persistence.*;

@Entity(name = "Benutzer")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "income")
    private Double income;

    public UserEntity(String firstName, String lastName, Double income) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.income = income;
    }

    protected UserEntity() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Long getId() {
        return id;
    }
}
