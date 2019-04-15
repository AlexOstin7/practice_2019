package ru.bellintegrator.practice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.message.Response;
import ru.bellintegrator.practice.view.OrganizationFilterView;
import ru.bellintegrator.practice.view.OrganizationView;

public interface OrganizationController {

    Response organization(@RequestBody OrganizationView organization);

    Response updateOrganizaton(@RequestBody OrganizationView organization);

    Response getOrganizationById(@PathVariable("id") Integer id) ;

    Response filterOrganizations(@RequestBody OrganizationFilterView organization);

    Response organizations(); //test only
    Response organizations2(); //test only


}
