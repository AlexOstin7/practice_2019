package ru.bellintegrator.practice.view;

//import com.fasterxml.jackson.annotation.JsonInclude;
//import io.swagger.annotations.ApiModelProperty;
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfficeFilterView {
//    @ApiModelProperty(hidden = true)

    private String id;

    private String name;

    private Integer phone;

    private Boolean isActive;

    private Integer orgId;

    public OfficeFilterView() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getPhone() {
        return phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setActive(Boolean isActive) {
        isActive = isActive;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "OfficeFilterView{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", phone=" + phone + ", isActive=" + isActive + ", orgId=" + orgId + '}';
    }
}