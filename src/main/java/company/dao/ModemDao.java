package company.dao;


import company.config.CustomFileReader;
import company.domain.Modem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModemDao implements BaseDao<Modem> {

    private final String modemFile = "src/main/resources/modem.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<Modem> findAll() throws IOException {
        return readModemFile();
    }

    public List<Modem> readModemFile() throws IOException {
        List<Modem> modems = new ArrayList<>();
        List<String> strings = fileReader.readFile(modemFile);
        strings.forEach(s -> modems.add(toModem(s)));
        return modems;
    }

    private Modem toModem(String line) {
        String[] strings = line.split(",");
        return Modem.childBuilder()
                .id(Long.valueOf(strings[0]))
                .color(strings[1])
                .cost(Double.valueOf(strings[2]))
                .branchName((strings[3]))
                .isTariff(Boolean.valueOf(strings[4]))
                .Tariff_company_name((strings[5]))
                .build();
    }
}
