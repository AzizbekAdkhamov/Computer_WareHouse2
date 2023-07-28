package company.controller;


import company.domain.Multimedia;
import company.domain.Multimedia;
import company.dtos.DataDTO;
import company.dtos.ResponseEntity;
import company.service.MultimediaService;
import company.service.MultimediaService;
import company.utils.BaseUtils;

import java.util.List;

public class MultimediaController implements BaseController {

    private final MultimediaService service = new MultimediaService();

    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Multimedia>>> responseEntity = service.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByID() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<Multimedia>> responseEntity = service.findByID(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByColor() {
        BaseUtils.print("Enter color: ");
        ResponseEntity<DataDTO<List<Multimedia>>> responseEntity = service.findByColor(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByCost() {
        BaseUtils.print("Enter Cost: ");
        ResponseEntity<DataDTO<List<Multimedia>>> responseEntity = service.findByCost(BaseUtils.readDouble());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByBranchName() {
        BaseUtils.print("Enter branchName: ");
        ResponseEntity<DataDTO<List<Multimedia>>> responseEntity = service.findByBranchName(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByCost() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Multimedia>>> responseEntity = service.filterByCost(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByCPUName() {
        BaseUtils.print("Enter CPU_name : ");
        ResponseEntity<DataDTO<List<Multimedia>>> responseEntity = service.findByCPUName(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByMemory() {
        BaseUtils.print("Enter memory: ");
        ResponseEntity<DataDTO<List<Multimedia>>> responseEntity = service.findByMemory(BaseUtils.readDouble());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
}
