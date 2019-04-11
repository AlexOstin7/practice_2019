package ru.bellintegrator.practice.view;


public class OrganizationFilterView {

    public String name;

    public Long inn;

    public Boolean isActive;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public OrganizationFilterView() {

    }

    public OrganizationFilterView(String name, Long inn, Boolean isActive) {
        this.name = name;
        this.inn = inn;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "OrganizationView{" + "name='" + name + '\'' +  ", inn=" + inn  + ", isActive=" + isActive + '}';
    }
}