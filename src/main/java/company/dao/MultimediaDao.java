package company.dao;


import company.config.CustomFileReader;
import company.domain.Multimedia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MultimediaDao implements BaseDao<Multimedia> {

    private final String multimediaFile = "src/main/resources/multimedia.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<Multimedia> findAll() throws IOException {
        return readMultimediaFile();
    }

    public List<Multimedia> readMultimediaFile() throws IOException {
        List<Multimedia> multimedia = new ArrayList<>();
        List<String> strings = fileReader.readFile(multimediaFile);
        strings.forEach(s -> multimedia.add(toMultimedia(s)));
        return multimedia;
    }

    private Multimedia toMultimedia(String line) {
        String[] strings = line.split(",");
        return Multimedia.childBuilder()
                .id(Long.valueOf(strings[0]))
                .color(strings[1])
                .cost(Double.valueOf(strings[2]))
                .branchName((strings[3]))
                .CPU_name((strings[4]))
                .memory(Double.valueOf(strings[5]))
                .build();
    }
}
