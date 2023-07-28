package company.service;

import company.dao.PrinterDao;
import company.domain.Printer;
import company.domain.Printer;
import company.domain.Printer;
import company.dtos.AppErrorDTO;
import company.dtos.DataDTO;
import company.dtos.ResponseEntity;
import company.exceptions.GenericNotFoundException;

import java.util.Comparator;
import java.util.List;

public class PrinterService implements BaseService<Printer> {
    private final PrinterDao dao = new PrinterDao();

    @Override
    public ResponseEntity<DataDTO<List<Printer>>> findAll(String sort) {
        try {
            List<Printer> printers = dao.findAll();
            if (printers.isEmpty()) {
                throw new GenericNotFoundException("Printers not found!");
            }
            switch (sort) {
                case "1" -> printers.sort(Comparator.comparing(Printer::getId));
                case "2" -> printers.sort(Comparator.comparing(Printer::getCost));
            }
            return new ResponseEntity<>(new DataDTO<>(printers));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<Printer>> findByID(Long id) {
        try {
            Printer printer = dao.findAll().stream().filter(printer1 ->
                    printer1.getId().equals(id)).findFirst().orElse(null);
            if (printer == null) {
                throw new GenericNotFoundException("Printer not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(printer), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Printer>>> findByColor(String color) {
        try {
            List<Printer> printers = dao.findAll().stream().filter(printer ->
                    printer.getColor().equals(color)).toList();
            if (printers.isEmpty()) {
                throw new GenericNotFoundException("Printers not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(printers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Printer>>> findByBranchName(String branchName) {
        try {
            List<Printer> printers = dao.findAll().stream().filter(printer ->
                    printer.getBranchName().equals(branchName)).toList();
            if (printers.isEmpty()) {
                throw new GenericNotFoundException("Printers not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(printers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Printer>>> findByCost(Double cost) {
        try {
            List<Printer> printers = dao.findAll().stream().filter(printer ->
                    printer.getCost().equals(cost)).toList();
            if (printers.isEmpty()) {
                throw new GenericNotFoundException("Printers not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(printers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Printer>>> filterByCost(Double min, Double max) {
        try {
            List<Printer> printers = dao.findAll().stream().filter(printer ->
                    printer.getCost() >= min && printer.getCost() <= max).toList();
            if (printers.isEmpty()) {
                throw new GenericNotFoundException("Printers not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(printers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
    public ResponseEntity<DataDTO<List<Printer>>> findByWidthAndHeight(Double width, Double height) {
        try {
            List<Printer> printers = dao.findAll().stream().filter(printer ->
                    printer.getWidth().equals(width) && printer.getHeight().equals(height)).toList();
            if (printers.isEmpty()) {
                throw new GenericNotFoundException("Printer not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(printers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

}
