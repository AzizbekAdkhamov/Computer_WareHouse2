package company.service;


import company.dao.ModemDao;
import company.domain.Modem;
import company.domain.Modem;
import company.dtos.AppErrorDTO;
import company.dtos.DataDTO;
import company.dtos.ResponseEntity;
import company.exceptions.GenericNotFoundException;

import java.util.Comparator;
import java.util.List;

public class ModemService implements BaseService<Modem> {

    private final ModemDao dao = new ModemDao();

    @Override
    public ResponseEntity<DataDTO<List<Modem>>> findAll(String sort) {
        try {
            List<Modem> modems = dao.findAll();
            if (modems.isEmpty()) {
                throw new GenericNotFoundException("Modems not found!");
            }
            switch (sort) {
                case "1" -> modems.sort(Comparator.comparing(Modem::getId));
                case "2" -> modems.sort(Comparator.comparing(Modem::getCost));
            }
            return new ResponseEntity<>(new DataDTO<>(modems));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<Modem>> findByID(Long id) {
        try {
            Modem modem = dao.findAll().stream().filter(modem1 ->
                    modem1.getId().equals(id)).findFirst().orElse(null);
            if (modem == null) {
                throw new GenericNotFoundException("Modem not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(modem), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Modem>>> findByColor(String color) {
        try {
            List<Modem> modems = dao.findAll().stream().filter(modem ->
                    modem.getColor().equals(color)).toList();
            if (modems.isEmpty()) {
                throw new GenericNotFoundException("Modems not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(modems), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Modem>>> findByBranchName(String branchName) {
        try {
            List<Modem> modems = dao.findAll().stream().filter(modem ->
                    modem.getBranchName().equals(branchName)).toList();
            if (modems.isEmpty()) {
                throw new GenericNotFoundException("Modems not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(modems), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Modem>>> findByCost(Double cost) {
        try {
            List<Modem> modems = dao.findAll().stream().filter(modem ->
                    modem.getCost().equals(cost)).toList();
            if (modems.isEmpty()) {
                throw new GenericNotFoundException("Modems not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(modems), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Modem>>> filterByCost(Double min, Double max) {
        try {
            List<Modem> modems = dao.findAll().stream().filter(modem ->
                    modem.getCost() >= min && modem.getCost() <= max).toList();
            if (modems.isEmpty()) {
                throw new GenericNotFoundException("Modems not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(modems), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Modem>>> findByTariffCompanyName(String tariff_company_name) {
        try {
            List<Modem> modems = dao.findAll().stream().filter(modem ->
                    modem.getTariff_company_name().equals(tariff_company_name)).toList();
            if (modems.isEmpty()) {
                throw new GenericNotFoundException("Modems not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(modems), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
    public ResponseEntity<DataDTO<List<Modem>>> findByIsTariff(String isTariff) {
        try {
            List<Modem> modemList = dao.findAll();
            if (modemList.isEmpty()) {
                throw new GenericNotFoundException("Modems not found!");
            }
            switch (isTariff) {
                case "yes" -> {
                    return new ResponseEntity<>(new DataDTO<>(modemList.stream().filter(modem ->
                            modem.getIsTariff().equals(true)).toList()), 200);
                }
                case "no" -> {
                    return new ResponseEntity<>(new DataDTO<>(modemList.stream().filter(modem ->
                            modem.getIsTariff().equals(false)).toList()), 200);
                }
            }
            return new ResponseEntity<>(new DataDTO<>(modemList), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
}
