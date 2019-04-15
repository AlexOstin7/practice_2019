package ru.bellintegrator.practice.service.impl;

import com.google.common.base.Strings;
//import com.google.common.primitives.Integers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.OfficeDAO;
import ru.bellintegrator.practice.dao.OrganizationDAO;
import ru.bellintegrator.practice.exception.CustomErrorException;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.service.OrganizationService;
import ru.bellintegrator.practice.view.OrganizationFilterView;
import ru.bellintegrator.practice.view.OrganizationView;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OrganizationServiceImpl implements OrganizationService {
    private final Logger log = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    private final OrganizationDAO dao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDAO dao, OfficeDAO daoOffice) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationFilterView> filterOrganizationList(OrganizationFilterView organizationFilterView) {
        log.info("view {} " + organizationFilterView.toString());
        if (Strings.isNullOrEmpty(organizationFilterView.getName())) {
            throw new CustomErrorException("Не заполнено обязательное поле name*");
        }
        List<Organization> all = dao.filterOrganizationList(organizationFilterView);

        Function<Organization, OrganizationFilterView> mapOrganization = p -> {
            OrganizationFilterView view = new OrganizationFilterView();
            view.setName(p.getName());
            view.setInn(p.getInn());
            view.setActive(p.getActive());
            log.info(view.toString());
            return view;
        };
        return all.stream().map(mapOrganization).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public OrganizationView getOrganizationById(Integer id) {
        log.info("getId {} " + id);
        if (id < 1) {
            throw new CustomErrorException(String.format("Неверное ID организации %s", id));
        }
        Organization organization = dao.loadById(id);
        OrganizationView organizationView = new OrganizationView();
        if (organization == null) {
            return organizationView;
        }
        organizationView.setName(organization.getName());
        organizationView.setFullName(organization.getFullName());
        organizationView.setInn(organization.getInn());
        organizationView.setKpp(organization.getKpp());
        organizationView.setAddress(organization.getAddress());
        organizationView.setPhone(organization.getPhone());
        organizationView.setActive(organization.getActive());
        return organizationView;
    }

    @Override
    @Transactional
    public void updateOrganization(OrganizationView view) {
        if (Strings.isNullOrEmpty(view.getId()) || Strings.isNullOrEmpty(view.getName())
                || Strings.isNullOrEmpty(view.getFullName()) || Strings.isNullOrEmpty(view.getInn())
                || Strings.isNullOrEmpty(view.getKpp()) || Strings.isNullOrEmpty(view.getAddress())
        ) {
            throw new CustomErrorException("Не заполнены обязательные поля* ");
        }
        if (Integer.valueOf(view.getId()) < 1) {
            throw new CustomErrorException(String.format("Неверное ID организации %s", view.getId()));
        }
        Organization organization = dao.loadById(Integer.valueOf(view.getId()));
        if (organization == null) {
            throw new CustomErrorException(String.format("Не найдена организация с ID %s", view.getId()));
        }
        organization.setName(view.getName());
        organization.setFullName(view.getFullName());
        organization.setInn(view.getInn());
        organization.setKpp(view.getKpp());
        organization.setAddress(view.getAddress());
        organization.setPhone(view.getPhone());
        organization.setActive(view.getActive());
        log.info("view update {} " + view.toString());
        log.info("view update 2 {} " + organization.toString());
        dao.save(organization);
    }

    @Override
    @Transactional
    public void add(OrganizationView view) {
        log.info("view {} " + view.toString());
        if (Strings.isNullOrEmpty(view.getName()) || Strings.isNullOrEmpty(view.getFullName()) || Strings.isNullOrEmpty(view.getInn())
                || Strings.isNullOrEmpty(view.getKpp()) || Strings.isNullOrEmpty(view.getAddress())
        ) {
            throw new CustomErrorException("Не заполнены обязательные поля* ");
        }
        Organization organization = new Organization(view.getName(), view.getFullName(), view.getInn(), view.getKpp(), view.getAddress(), view.getPhone(), view.getActive());
        dao.save(organization);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationView> organizations() {
        List<Organization> all = dao.all();

        Function<Organization, OrganizationView> mapOrganization = p -> {
            OrganizationView view = new OrganizationView();
            view.setId(String.valueOf(p.getId()));
            view.setName(p.getName());
            view.setFullName(p.getFullName());
            view.setInn(p.getInn());
            view.setKpp(p.getKpp());
            view.setAddress(p.getAddress());
            view.setPhone(p.getPhone());
            view.setActive(p.getActive());
//            view.setActive(false);

            log.info("org all" + view.toString());

            return view;
        };
        return all.stream()
                .map(mapOrganization)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Organization> organizations2() {
        return dao.all();
    }

}
