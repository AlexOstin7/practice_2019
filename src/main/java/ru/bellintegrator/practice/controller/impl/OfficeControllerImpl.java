package ru.bellintegrator.practice.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.controller.OfficeController;
import ru.bellintegrator.practice.message.Response;
import ru.bellintegrator.practice.message.ResponseSuccess;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.service.impl.OfficeServiceImpl;
import ru.bellintegrator.practice.service.OfficeService;
import ru.bellintegrator.practice.view.OfficeFilterView;
import ru.bellintegrator.practice.view.OfficeView;


import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class OfficeControllerImpl implements OfficeController {

    private final Logger log = LoggerFactory.getLogger(OfficeServiceImpl.class);
    private final OfficeService officeService;
    //private final OrganizationService organizationService;

    @Autowired
    public OfficeControllerImpl(OfficeService officeService) {
        this.officeService = officeService;
    }

    @Override
    @RequestMapping(value = "/office/{id}", method = {GET})
    public Response getOfficeById(@PathVariable(value = "id") Long id) {
        log.info("controller before service.getOfficeByID "+ id.toString());
        Office office = officeService.getOfficeById(id);
        log.info("controller after service.getOfficeByID "+ id.toString() + " office - " + office.toString());
        return new ResponseSuccess("success", office);
    }

    @Override
    @RequestMapping(value = "/office/list", method = {POST})
    public Response filterOffices(@RequestBody OfficeFilterView office) {
        log.info("view-listByOrgId" + office.toString());
        List<OfficeFilterView> officeFilterViewList = officeService.filterOfficeList(office);

        return new ResponseSuccess("success", officeFilterViewList);
    }
    @Override
    @RequestMapping(value = "/office/update", method = {POST})
    public Response updateOffice(@RequestBody OfficeView office) {
        log.info("Office controller update view-update " + office.toString());
        officeService.updateOffice(office);
        return new ResponseSuccess("success");
    }

    @Override
    @RequestMapping(value = "/office/delete", method = {POST})
    public Response deleteOffice(@RequestBody OfficeView office) {
        officeService.deleteOffice(office);
        return new ResponseSuccess("success");
    }


    @Override
    @RequestMapping(value = "/office/save", method = {POST})
    public Response office(@RequestBody OfficeView office) {
        log.info("office contr save before " + office.toString());
        officeService.add(office);
        log.info("office contr save after " + office.toString());
        return new ResponseSuccess("success");
    }

    //FOR TEST ONLY!!!!
    @Override
    @RequestMapping(value = "/offices", method = {GET})
    public Response offices() {
        return new ResponseSuccess("success", officeService.offices());
    }

    @Override
    @RequestMapping(value = "/office/lists", method = {POST})
    public Response offices(@RequestBody OfficeView office) {
        log.info("view-list" + office.toString());
        return new ResponseSuccess("success", officeService.listOffices(office));
    }


}

