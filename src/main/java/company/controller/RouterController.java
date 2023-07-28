package company.controller;




import company.domain.Router;
import company.domain.Router;
import company.dtos.DataDTO;
import company.dtos.ResponseEntity;
import company.service.RouterService;
import company.service.RouterService;
import company.utils.BaseUtils;

import java.util.List;

public class RouterController implements BaseController {

    private final RouterService service = new RouterService();

    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Router>>> responseEntity = service.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByID() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<Router>> responseEntity = service.findByID(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByColor() {
        BaseUtils.print("Enter color: ");
        ResponseEntity<DataDTO<List<Router>>> responseEntity = service.findByColor(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByCost() {
        BaseUtils.print("Enter Cost: ");
        ResponseEntity<DataDTO<List<Router>>> responseEntity = service.findByCost(BaseUtils.readDouble());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByBranchName() {
        BaseUtils.print("Enter branchName: ");
        ResponseEntity<DataDTO<List<Router>>> responseEntity = service.findByBranchName(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByCost() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Router>>> responseEntity = service.filterByCost(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findBySpeed() {
        BaseUtils.print("Enter speed: ");
        ResponseEntity<DataDTO<List<Router>>> responseEntity = service.findBySpeed(BaseUtils.readDouble());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByWireless() {
        BaseUtils.print("Want wireless(yes/no): ");
        ResponseEntity<DataDTO<List<Router>>> responseEntity = service.findByWireless(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
}
