package ru.bellintegrator.practice.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ru.bellintegrator.practice.controller.OrganizationController;
import ru.bellintegrator.practice.exception.CustomErrorException;
import ru.bellintegrator.practice.message.Response;
import ru.bellintegrator.practice.message.ResponseSuccess;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.service.OrganizationService;
import ru.bellintegrator.practice.view.OrganizationFilterView;
import ru.bellintegrator.practice.view.OrganizationView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class OrganizationControllerImpl implements OrganizationController {

    private final OrganizationService organizationService;
    private final Logger log = LoggerFactory.getLogger(OrganizationControllerImpl.class);
    @Autowired
    public OrganizationControllerImpl(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }
    @Override
    @RequestMapping(value = "/organization/list", method = {POST})
    public Response filterOrganizations(@RequestBody OrganizationFilterView organization) {
        List<OrganizationFilterView> view = organizationService.filterOrganizationList(organization);
        return new ResponseSuccess("success", view);
    }
    @Override
    @RequestMapping(value =  {"/organization", "/organization/{id}"}, method = {GET})
    public Response getOrganizationById(@PathVariable(value="id",required = false) Long id) {
        log.info("id {} " + id);
        if (id == null) {
            throw new CustomErrorException("Не заполнено обязательное поле Id* ");
        }
        return new ResponseSuccess("success", organizationService.getOrganizationById(id));
    }
    @Override
    @RequestMapping(value = "/organization/update", method = {POST})
    public Response updateOrganizaton(@RequestBody OrganizationView organization) {
        log.info("org serv before update " + organization.toString());
        organizationService.updateOrganization(organization);
        log.info("org serv past update " + organization.toString());
        return new ResponseSuccess("success");
    }
    @Override
    @RequestMapping(value = "/organiazation/save", method = {POST})
    public Response organization(@RequestBody OrganizationView organization) {
        log.info("org contr save befor " + organization.toString());
        organizationService.add(organization);
        log.info("org contr save after " + organization.toString());
        return new ResponseSuccess("success");
    }


    //TEST ONLY
    @Override
    @RequestMapping(value = "/organizations", method = {GET})
    public Response organizations() {
        return new ResponseSuccess("success", organizationService.organizations());
    }

    @Override
    @RequestMapping(value = "/organizations2", method = {GET})
    public Response organizations2() {
        return new ResponseSuccess("success", organizationService.organizations2());
    }

}
