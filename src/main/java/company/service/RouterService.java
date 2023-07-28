package company.service;


import company.dao.RouterDao;
import company.dao.RouterDao;
import company.domain.Router;
import company.domain.Router;
import company.domain.Router;
import company.dtos.AppErrorDTO;
import company.dtos.DataDTO;
import company.dtos.ResponseEntity;
import company.exceptions.GenericNotFoundException;

import java.util.Comparator;
import java.util.List;

public class RouterService implements BaseService<Router> {

    private final RouterDao dao = new RouterDao();

    @Override
    public ResponseEntity<DataDTO<List<Router>>> findAll(String sort) {
        try {
            List<Router> routers = dao.findAll();
            if (routers.isEmpty()) {
                throw new GenericNotFoundException("Routers not found!");
            }
            switch (sort) {
                case "1" -> routers.sort(Comparator.comparing(Router::getId));
                case "2" -> routers.sort(Comparator.comparing(Router::getCost));
            }
            return new ResponseEntity<>(new DataDTO<>(routers));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<Router>> findByID(Long id) {
        try {
            Router router = dao.findAll().stream().filter(router1 ->
                    router1.getId().equals(id)).findFirst().orElse(null);
            if (router == null) {
                throw new GenericNotFoundException("Router not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(router), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Router>>> findByColor(String color) {
        try {
            List<Router> routers = dao.findAll().stream().filter(router ->
                    router.getColor().equals(color)).toList();
            if (routers.isEmpty()) {
                throw new GenericNotFoundException("Routers not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(routers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Router>>> findByBranchName(String branchName) {
        try {
            List<Router> routers = dao.findAll().stream().filter(router ->
                    router.getBranchName().equals(branchName)).toList();
            if (routers.isEmpty()) {
                throw new GenericNotFoundException("Routers not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(routers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Router>>> findByCost(Double cost) {
        try {
            List<Router> routers = dao.findAll().stream().filter(router ->
                    router.getCost().equals(cost)).toList();
            if (routers.isEmpty()) {
                throw new GenericNotFoundException("Routers not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(routers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Router>>> filterByCost(Double min, Double max) {
        try {
            List<Router> routers = dao.findAll().stream().filter(router ->
                    router.getCost() >= min && router.getCost() <= max).toList();
            if (routers.isEmpty()) {
                throw new GenericNotFoundException("Routers not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(routers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Router>>> findBySpeed(Double speed) {
        try {
            List<Router> routers = dao.findAll().stream().filter(router ->
                    router.getSpeed().equals(speed)).toList();
            if (routers.isEmpty()) {
                throw new GenericNotFoundException("Routers not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(routers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
    public ResponseEntity<DataDTO<List<Router>>> findByWireless(String isWireless) {
        try {
            List<Router> routerList = dao.findAll();
            if (routerList.isEmpty()) {
                throw new GenericNotFoundException("Routers not found!");
            }
            switch (isWireless) {
                case "yes" -> {
                    return new ResponseEntity<>(new DataDTO<>(routerList.stream().filter(router ->
                            router.getWireless().equals(true)).toList()), 200);
                }
                case "no" -> {
                    return new ResponseEntity<>(new DataDTO<>(routerList.stream().filter(router ->
                            router.getWireless().equals(false)).toList()), 200);
                }
            }
            return new ResponseEntity<>(new DataDTO<>(routerList), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
}
