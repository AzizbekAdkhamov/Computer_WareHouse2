package company.service;


import company.dtos.DataDTO;
import company.dtos.ResponseEntity;

import java.util.List;

public interface BaseService<T> {
    ResponseEntity<DataDTO<List<T>>> findAll(String sort);

    ResponseEntity<DataDTO<T>> findByID(Long id);

    ResponseEntity<DataDTO<List<T>>> findByColor(String color);

    ResponseEntity<DataDTO<List<T>>> findByBranchName(String branchName);

    ResponseEntity<DataDTO<List<T>>> findByCost(Double cost);

    ResponseEntity<DataDTO<List<T>>> filterByCost(Double min, Double max);


}
