import company.domain.Multimedia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import company.dtos.DataDTO;
import company.dtos.ResponseEntity;
import company.service.MultimediaService;

import java.util.List;

public class MultimediaServiceTest {

    private final MultimediaService service = new MultimediaService();

    @Test
    public void findByAllTest() {
        String sort = "1";
        ResponseEntity<DataDTO<List<Multimedia>>> all = service.findAll(sort);
        Assertions.assertTrue(all.getData().isSuccess(), "Find all method is not passed!");
    }

    @Test
    public void findByIDTest() {
        Long id = 1L;
        ResponseEntity<DataDTO<Multimedia>> responseEntity = service.findByID(id);
        Assertions.assertTrue(responseEntity.getData().isSuccess(), "Find by id method is not passed!");
    }

    @Test
    public void findByColorTest() {
        String color = "white";
        ResponseEntity<DataDTO<List<Multimedia>>> responseEntity = service.findByColor(color);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by color method is not passed!");
    }

    @Test
    public void filterByCostTest() {
        Double max = 50D;
        Double min = 40D;
        ResponseEntity<DataDTO<List<Multimedia>>> all = service.filterByCost(min, max);
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by cost method is not passed!!");
    }

    @Test
    public void findByMemory() {
        Double memory =12413D;
        ResponseEntity<DataDTO<List<Multimedia>>> responseEntity = service.findByMemory(memory);
        Assertions.assertTrue(responseEntity.getData().isSuccess(), "Find by memory method is not passed!");
    }
}
