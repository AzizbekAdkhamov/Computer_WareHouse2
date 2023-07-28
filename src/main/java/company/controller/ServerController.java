package company.controller;

import company.domain.Modem;
import company.domain.Server;
import company.dtos.DataDTO;
import company.dtos.ResponseEntity;
import company.service.ModemService;
import company.service.ServerService;
import company.utils.BaseUtils;

import java.sql.Timestamp;
import java.util.List;

public class ServerController implements BaseController{

    private final ServerService service = new ServerService();

    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Server>>> responseEntity = service.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByID() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<Server>> responseEntity = service.findByID(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByColor() {
        BaseUtils.print("Enter color: ");
        ResponseEntity<DataDTO<List<Server>>> responseEntity = service.findByColor(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByCost() {
        BaseUtils.print("Enter Cost: ");
        ResponseEntity<DataDTO<List<Server>>> responseEntity = service.findByCost(BaseUtils.readDouble());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByBranchName() {
        BaseUtils.print("Enter branchName: ");
        ResponseEntity<DataDTO<List<Server>>> responseEntity = service.findByBranchName(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByCost() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Server>>> responseEntity = service.filterByCost(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }


    public void findByCreationDate() {
        BaseUtils.print("Enter creationDate: ");
        ResponseEntity<DataDTO<List<Server>>> responseEntity = service.findByCreationDate(Timestamp.valueOf(BaseUtils.readText()));
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByCapacity() {
        BaseUtils.print("Enter capacity: ");
        ResponseEntity<DataDTO<List<Server>>> responseEntity = service.findByCapacity(BaseUtils.readDouble());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

}
