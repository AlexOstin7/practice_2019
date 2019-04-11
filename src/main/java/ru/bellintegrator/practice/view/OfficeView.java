package ru.bellintegrator.practice.view;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.bellintegrator.practice.model.Organization;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class OfficeView {

    private String id;

    private String name;

    private String address;

    private Integer phone;

    private Boolean isActive;

    private Long orgId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void setActive(Boolean IsActive) {
        this.isActive = isActive;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public OfficeView() {
    }

    public OfficeView(String name, String address, Integer phone, Boolean isActive, Long orgId) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "OfficeView{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", address='" + address + '\'' + ", phone=" + phone + ", isActive=" + isActive + ", orgId=" + orgId + '}';
    }
}