package company.controller;

import company.domain.Printer;
import company.dtos.DataDTO;
import company.dtos.ResponseEntity;
import company.service.PrinterService;
import company.utils.BaseUtils;

import java.util.List;

public class PrinterController implements BaseController{

    private final PrinterService service = new PrinterService();

    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Printer>>> responseEntity = service.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByID() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<Printer>> responseEntity = service.findByID(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByColor() {
        BaseUtils.print("Enter color: ");
        ResponseEntity<DataDTO<List<Printer>>> responseEntity = service.findByColor(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByCost() {
        BaseUtils.print("Enter Cost: ");
        ResponseEntity<DataDTO<List<Printer>>> responseEntity = service.findByCost(BaseUtils.readDouble());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByBranchName() {
        BaseUtils.print("Enter branchName: ");
        ResponseEntity<DataDTO<List<Printer>>> responseEntity = service.findByBranchName(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByCost() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Printer>>> responseEntity = service.filterByCost(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByHeightAndWidth(){
        BaseUtils.print("Enter height: ");
        Double height = BaseUtils.readDouble();
        BaseUtils.print("Enter width: ");
        Double width = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Printer>>> responseEntity = service.findByWidthAndHeight(height, width);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }



}
