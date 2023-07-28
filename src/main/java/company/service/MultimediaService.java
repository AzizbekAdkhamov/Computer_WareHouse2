package company.service;



import company.dao.MultimediaDao;
import company.dao.MultimediaDao;
import company.domain.Multimedia;
import company.domain.Multimedia;
import company.dtos.AppErrorDTO;
import company.dtos.DataDTO;
import company.dtos.ResponseEntity;
import company.exceptions.GenericNotFoundException;

import java.util.Comparator;
import java.util.List;

public class MultimediaService implements BaseService<Multimedia> {

    private final MultimediaDao dao = new MultimediaDao();

    @Override
    public ResponseEntity<DataDTO<List<Multimedia>>> findAll(String sort) {
        try {
            List<Multimedia> multimedias = dao.findAll();
            if (multimedias.isEmpty()) {
                throw new GenericNotFoundException("Multimedias not found!");
            }
            switch (sort) {
                case "1" -> multimedias.sort(Comparator.comparing(Multimedia::getId));
                case "2" -> multimedias.sort(Comparator.comparing(Multimedia::getCost));
            }
            return new ResponseEntity<>(new DataDTO<>(multimedias));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<Multimedia>> findByID(Long id) {
        try {
            Multimedia multimedia = dao.findAll().stream().filter(multimedia1 ->
                    multimedia1.getId().equals(id)).findFirst().orElse(null);
            if (multimedia == null) {
                throw new GenericNotFoundException("Multimedia not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(multimedia), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Multimedia>>> findByColor(String color) {
        try {
            List<Multimedia> multimedias = dao.findAll().stream().filter(multimedia ->
                    multimedia.getColor().equals(color)).toList();
            if (multimedias.isEmpty()) {
                throw new GenericNotFoundException("Multimedias not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(multimedias), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Multimedia>>> findByBranchName(String branchName) {
        try {
            List<Multimedia> multimedias = dao.findAll().stream().filter(multimedia ->
                    multimedia.getBranchName().equals(branchName)).toList();
            if (multimedias.isEmpty()) {
                throw new GenericNotFoundException("Multimedias not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(multimedias), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Multimedia>>> findByCost(Double cost) {
        try {
            List<Multimedia> multimedias = dao.findAll().stream().filter(multimedia ->
                    multimedia.getCost().equals(cost)).toList();
            if (multimedias.isEmpty()) {
                throw new GenericNotFoundException("Multimedias not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(multimedias), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Multimedia>>> filterByCost(Double min, Double max) {
        try {
            List<Multimedia> multimedias = dao.findAll().stream().filter(multimedia ->
                    multimedia.getCost() >= min && multimedia.getCost() <= max).toList();
            if (multimedias.isEmpty()) {
                throw new GenericNotFoundException("Multimedias not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(multimedias), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Multimedia>>> findByCPUName(String CPUName) {
        try {
            List<Multimedia> multimedias = dao.findAll().stream().filter(multimedia ->
                    multimedia.getCPU_name().equals(CPUName)).toList();
            if (multimedias.isEmpty()) {
                throw new GenericNotFoundException("Multimedias not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(multimedias), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Multimedia>>> findByMemory(Double memory) {
        try {
            List<Multimedia> multimedias = dao.findAll().stream().filter(multimedia ->
                    multimedia.getMemory().equals(memory)).toList();
            if (multimedias.isEmpty()) {
                throw new GenericNotFoundException("Multimedias not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(multimedias), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }




}
