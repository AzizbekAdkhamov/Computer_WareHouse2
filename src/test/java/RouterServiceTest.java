

import company.domain.Router;
import company.dtos.DataDTO;
import company.dtos.ResponseEntity;
import company.service.RouterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RouterServiceTest {
    private final RouterService service = new RouterService();

    @Test
    public void findByAllTest() {
        String sort = "1";
        ResponseEntity<DataDTO<List<Router>>> all = service.findAll(sort);
        Assertions.assertTrue(all.getData().isSuccess(), "Find all method is not passed!");
    }

    @Test
    public void findByIDTest() {
        Long id = 1L;
        ResponseEntity<DataDTO<Router>> responseEntity = service.findByID(id);
        Assertions.assertTrue(responseEntity.getData().isSuccess(), "Find by id method is not passed!");
    }

    @Test
    public void findByColorTest() {
        String color = "white";
        ResponseEntity<DataDTO<List<Router>>> responseEntity = service.findByColor(color);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by color method is not passed!");
    }

    @Test
    public void filterByCostTest() {
        Double max = 50D;
        Double min = 40D;
        ResponseEntity<DataDTO<List<Router>>> all = service.filterByCost(min, max);
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by cost method is not passed!!");
    }

    @Test
    public void findBySpeedTest() {
        Double speed = 3453D;
        ResponseEntity<DataDTO<List<Router>>> responseEntity = service.findBySpeed(speed);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by speed method is not passed!");
    }


}
