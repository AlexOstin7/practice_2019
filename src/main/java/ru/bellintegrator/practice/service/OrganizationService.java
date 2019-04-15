package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.view.OfficeView;
import ru.bellintegrator.practice.view.OrganizationFilterView;
import ru.bellintegrator.practice.view.OrganizationView;


import java.util.List;
import java.util.Optional;

/**
 * Some service. Just for test
 */
public interface OrganizationService {

    List<OrganizationFilterView> filterOrganizationList(OrganizationFilterView organizationFilterView);

    OrganizationView getOrganizationById(Integer id);

    void add(OrganizationView organization);

    void updateOrganization(OrganizationView organization);


    List<OrganizationView> organizations();
    List<Organization> organizations2();


}