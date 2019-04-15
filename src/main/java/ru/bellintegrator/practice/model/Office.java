package ru.bellintegrator.practice.model;

//import com.fasterxml.jackson.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "office")
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)

public class Office {
    private static final long serialVersionUID = -123452797979679L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    @Column(name = "version")
    private Integer version;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private Integer phone;
    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "org_id")
//    @JsonManagedReference
    private Organization organization;

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonBackReference
    private List<User> users;

    public Office(String name, String address, Integer phone, Boolean isActive) {
    }

    public Office(String name, String address, Integer phone, Boolean isActive, Integer orgId) {
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        getUsers().add(user);
        user.setOffice(this);
    }

    public Office() {
    }

    @Override
    public String toString() {
        return "Office{" + "id=" + id + ", name='" + name + '\'' + ", address='" + address + '\'' + ", phone=" + phone + ", isActive=" + isActive + ", organization=" + organization + ", users=" + users + '}';
    }
}