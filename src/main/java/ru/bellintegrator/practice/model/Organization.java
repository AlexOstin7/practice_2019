package ru.bellintegrator.practice.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@Entity
@Table(name = "organization")
//@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class Organization {
    private static final long serialVersionUID = -123451868897895L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    @Column(name = "version")
    private Integer version;
    @Column(name = "name")
    private String name;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "inn")
    @Size(min = 12, max = 12)
    private Integer inn;
    @Column(name = "kpp")
    @Size(min = 9, max = 9)
    private Integer kpp;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    @Size(min = 5, max = 20)
    private String phone;
    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Office> offices;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getInn() {
        return inn;
    }

    public void setInn(Integer inn) {
        this.inn = inn;
    }

    public int getKpp() {
        return kpp;
    }

    public void setKpp(int kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public void removeOffice(Office office) {
        //offices.remove(office);
        office.setOrganization(null);

    }

    public Organization() {
        /*offices = new ArrayList<Office>();*/
    }

  /*  public Organization(String name, Integer inn) {
        this.name = name;
        this.inn = inn;
    }*/

    public Organization(String name, Integer inn, Boolean isActive) {
        this.name = name;
        this.inn = inn;
        this.isActive = isActive;
    }

    public Organization(String name, String fullName, Integer inn, Integer kpp, String address, String phone, Boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }


    @Override
    public String toString() {
        return "Organization{" + "id=" + id + ", name='" + name + '\'' + ", fullName='" + fullName + '\'' + ", inn=" + inn + ", kpp=" + kpp + ", address='" + address + '\'' + ", phone=" + phone + ", isActive=" + isActive + '}';
    }
}