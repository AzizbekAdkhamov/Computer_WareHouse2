

import company.domain.Modem;
import company.dtos.DataDTO;
import company.dtos.ResponseEntity;
import company.service.ModemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ModemServiceTest {

    private final ModemService service = new ModemService();

    @Test
    public void findByAllTest() {
        String sort = "1";
        ResponseEntity<DataDTO<List<Modem>>> all = service.findAll(sort);
        Assertions.assertTrue(all.getData().isSuccess(), "Find all method is not passed!");
    }

    @Test
    public void findByIDTest() {
        Long id = 1L;
        ResponseEntity<DataDTO<Modem>> responseEntity = service.findByID(id);
        Assertions.assertTrue(responseEntity.getData().isSuccess(), "Find by id method is not passed!");
    }

    @Test
    public void findByColorTest() {
        String color = "white";
        ResponseEntity<DataDTO<List<Modem>>> responseEntity = service.findByColor(color);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by color method is not passed!");
    }

    @Test
    public void filterByCostTest() {
        Double max = 25D;
        Double min = 15D;
        ResponseEntity<DataDTO<List<Modem>>> all = service.filterByCost(min, max);
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by cost method is not passed!!");
    }

    @Test
    public void findByIsTariff() {
        String istariff="yes";
        ResponseEntity<DataDTO<List<Modem>>> all = service.findByIsTariff(istariff);
        Assertions.assertTrue(all.getData().isSuccess(), "Find by tariff method is not passed!!");
    }
}
