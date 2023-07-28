package company.service;

import company.dao.ServerDao;
import company.domain.Server;
import company.domain.Server;
import company.dtos.AppErrorDTO;
import company.dtos.DataDTO;
import company.dtos.ResponseEntity;
import company.exceptions.GenericNotFoundException;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

public class ServerService implements BaseService<Server> {
    private final ServerDao dao = new ServerDao();

    @Override
    public ResponseEntity<DataDTO<List<Server>>> findAll(String sort) {
        try {
            List<Server> servers = dao.findAll();
            if (servers.isEmpty()) {
                throw new GenericNotFoundException("Servers not found!");
            }
            switch (sort) {
                case "1" -> servers.sort(Comparator.comparing(Server::getId));
                case "2" -> servers.sort(Comparator.comparing(Server::getCost));
            }
            return new ResponseEntity<>(new DataDTO<>(servers));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<Server>> findByID(Long id) {
        try {
            Server server = dao.findAll().stream().filter(server1 ->
                    server1.getId().equals(id)).findFirst().orElse(null);
            if (server == null) {
                throw new GenericNotFoundException("Server not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(server), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Server>>> findByColor(String color) {
        try {
            List<Server> servers = dao.findAll().stream().filter(server ->
                    server.getColor().equals(color)).toList();
            if (servers.isEmpty()) {
                throw new GenericNotFoundException("Servers not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(servers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Server>>> findByBranchName(String branchName) {
        try {
            List<Server> servers = dao.findAll().stream().filter(server ->
                    server.getBranchName().equals(branchName)).toList();
            if (servers.isEmpty()) {
                throw new GenericNotFoundException("Servers not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(servers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Server>>> findByCost(Double cost) {
        try {
            List<Server> servers = dao.findAll().stream().filter(server ->
                    server.getCost().equals(cost)).toList();
            if (servers.isEmpty()) {
                throw new GenericNotFoundException("Servers not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(servers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Server>>> filterByCost(Double min, Double max) {
        try {
            List<Server> servers = dao.findAll().stream().filter(server ->
                    server.getCost() >= min && server.getCost() <= max).toList();
            if (servers.isEmpty()) {
                throw new GenericNotFoundException("Servers not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(servers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Server>>> findByCreationDate(Timestamp creationDate) {
        try {
            List<Server> servers = dao.findAll().stream().filter(server ->
                    server.getCreation_date().equals(creationDate)).toList();
            if (servers.isEmpty()) {
                throw new GenericNotFoundException("Servers not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(servers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Server>>> findByCapacity(Double capacity) {
        try {
            List<Server> servers = dao.findAll().stream().filter(server ->
                    server.getCapacity().equals(capacity)).toList();
            if (servers.isEmpty()) {
                throw new GenericNotFoundException("Servers not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(servers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

}

