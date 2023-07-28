package company.controller;

public interface BaseController {
    void showAll(String sort);

    void findByID();

    void findByColor();

    void findByCost();

    void findByBranchName();

    void filterByCost();
}
