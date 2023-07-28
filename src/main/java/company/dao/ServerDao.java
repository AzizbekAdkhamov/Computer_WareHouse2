package company.dao;

import company.config.CustomFileReader;
import company.domain.Router;
import company.domain.Server;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ServerDao implements BaseDao<Server> {

    private final String serverFile = "src/main/resources/server.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<Server> findAll() throws IOException {
        return readServerFile();
    }

    public List<Server> readServerFile() throws IOException {
        List<Server> servers = new ArrayList<>();
        List<String> strings = fileReader.readFile(serverFile);
        strings.forEach(s -> servers.add(toServer(s)));
        return servers;
    }

    private Server toServer(String line) {
        String[] strings = line.split(",");
        return Server.childBuilder()
                .id(Long.valueOf(strings[0]))
                .color(strings[1])
                .cost(Double.valueOf(strings[2]))
                .branchName((strings[3]))
                .capacity(Double.valueOf(strings[4]))
                .creation_date(Timestamp.valueOf(strings[5]))
                .build();
    }
}
