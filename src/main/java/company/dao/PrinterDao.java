package company.dao;

import company.config.CustomFileReader;
import company.domain.Multimedia;
import company.domain.Printer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrinterDao implements BaseDao<Printer>{
    private final String printerFile = "src/main/resources/printer.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<Printer> findAll() throws IOException {
        return readPrinterFile();
    }

    public List<Printer> readPrinterFile() throws IOException {
        List<Printer> printer = new ArrayList<>();
        List<String> strings = fileReader.readFile(printerFile);
        strings.forEach(s -> printer.add(toPrinter(s)));
        return printer;
    }

    private Printer toPrinter(String line) {
        String[] strings = line.split(",");
        return Printer.childBuilder()
                .id(Long.valueOf(strings[0]))
                .color(strings[1])
                .cost(Double.valueOf(strings[2]))
                .branchName((strings[3]))
                .height(Double.valueOf(strings[4]))
                .width(Double.valueOf(strings[5]))
                .build();
    }
}
