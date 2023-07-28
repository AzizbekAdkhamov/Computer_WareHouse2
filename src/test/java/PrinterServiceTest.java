import company.domain.Printer;
import company.dtos.DataDTO;
import company.dtos.ResponseEntity;
import company.service.PrinterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PrinterServiceTest {
    private final PrinterService service = new PrinterService();

    @Test
    public void findByAllTest() {
        String sort = "1";
        ResponseEntity<DataDTO<List<Printer>>> all = service.findAll(sort);
        Assertions.assertTrue(all.getData().isSuccess(), "Find all method is not passed!");
    }

    @Test
    public void findByIDTest() {
        Long id = 1L;
        ResponseEntity<DataDTO<Printer>> responseEntity = service.findByID(id);
        Assertions.assertTrue(responseEntity.getData().isSuccess(), "Find by id method is not passed!");
    }

    @Test
    public void findByColorTest() {
        String color = "white";
        ResponseEntity<DataDTO<List<Printer>>> responseEntity = service.findByColor(color);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by color method is not passed!");
    }

    @Test
    public void filterByCostTest() {
        Double max = 25D;
        Double min = 15D;
        ResponseEntity<DataDTO<List<Printer>>> all = service.filterByCost(min, max);
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by cost method is not passed!!");
    }

    @Test
    public void findByWidthAndHeight() {
        Double height = 25D;
        Double width = 15D;
        ResponseEntity<DataDTO<List<Printer>>> all = service.findByWidthAndHeight(height, width);
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by height and width method is not passed!!");
    }

}
