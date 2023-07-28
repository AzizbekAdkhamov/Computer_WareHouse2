import company.domain.Server;
import company.dtos.DataDTO;
import company.dtos.ResponseEntity;
import company.service.ServerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ServerServiceTest {
    private final ServerService service = new ServerService();

    @Test
    public void findByAllTest() {
        String sort = "1";
        ResponseEntity<DataDTO<List<Server>>> all = service.findAll(sort);
        Assertions.assertTrue(all.getData().isSuccess(), "Find all method is not passed!");
    }

    @Test
    public void findByIDTest() {
        Long id = 1L;
        ResponseEntity<DataDTO<Server>> responseEntity = service.findByID(id);
        Assertions.assertTrue(responseEntity.getData().isSuccess(), "Find by id method is not passed!");
    }

    @Test
    public void findByColorTest() {
        String color = "white";
        ResponseEntity<DataDTO<List<Server>>> responseEntity = service.findByColor(color);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by color method is not passed!");
    }

    @Test
    public void filterByCostTest() {
        Double max = 25D;
        Double min = 15D;
        ResponseEntity<DataDTO<List<Server>>> all = service.filterByCost(min, max);
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by cost method is not passed!!");
    }

    @Test
    public void findByCapacity() {
        Double capacity = 423D;
        ResponseEntity<DataDTO<List<Server>>> responseEntity = service.findByCapacity(capacity);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by capacity method is not passed!");
    }

}
