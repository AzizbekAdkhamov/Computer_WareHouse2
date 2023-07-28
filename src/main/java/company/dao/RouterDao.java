package company.dao;


import company.config.CustomFileReader;
import company.domain.Router;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RouterDao implements BaseDao<Router> {

    private final String routerFile = "src/main/resources/router.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<Router> findAll() throws IOException {
        return readRouterFile();
    }

    public List<Router> readRouterFile() throws IOException {
        List<Router> routers = new ArrayList<>();
        List<String> strings = fileReader.readFile(routerFile);
        strings.forEach(s -> routers.add(toRouter(s)));
        return routers;
    }

    private Router toRouter(String line) {
        String[] strings = line.split(",");
        return Router.childBuilder()
                .id(Long.valueOf(strings[0]))
                .color(strings[1])
                .cost(Double.valueOf(strings[2]))
                .branchName((strings[3]))
                .wireless(Boolean.valueOf(strings[4]))
                .speed(Double.valueOf(strings[5]))
                .build();
    }
}
