package company.controller;
import company.domain.Modem;
import company.dtos.DataDTO;
import company.dtos.ResponseEntity;
import company.service.ModemService;
import company.utils.BaseUtils;

import java.util.List;

public class ModemController implements BaseController {

    private final ModemService service = new ModemService();

    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Modem>>> responseEntity = service.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByID() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<Modem>> responseEntity = service.findByID(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByColor() {
        BaseUtils.print("Enter color: ");
        ResponseEntity<DataDTO<List<Modem>>> responseEntity = service.findByColor(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByCost() {
        BaseUtils.print("Enter Cost: ");
        ResponseEntity<DataDTO<List<Modem>>> responseEntity = service.findByCost(BaseUtils.readDouble());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByBranchName() {
        BaseUtils.print("Enter branchName: ");
        ResponseEntity<DataDTO<List<Modem>>> responseEntity = service.findByBranchName(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByCost() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Modem>>> responseEntity = service.filterByCost(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByIsTariff(){
        BaseUtils.print("Want tariff (yes/no) : ");
        ResponseEntity<DataDTO<List<Modem>>> responseEntity = service.findByIsTariff(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
    public void findBytariff_company_name(){
        BaseUtils.print("Enter tariff_company_name: ");
        ResponseEntity<DataDTO<List<Modem>>> responseEntity = service.findByTariffCompanyName(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
}
