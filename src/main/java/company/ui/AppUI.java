package company.ui;



import company.controller.*;
import company.utils.BaseUtils;

import java.util.Objects;

public class AppUI {

    private final RouterController routerController = new RouterController();
    private final ModemController modemController = new ModemController();
    private final MultimediaController multimediaController = new MultimediaController();
    private final PrinterController printerController = new PrinterController();
    private final ServerController serverController = new ServerController();

    public void run() {
        BaseUtils.println("\n\n1 -> Router");
        BaseUtils.println("2 -> Modem");
        BaseUtils.println("3 -> Multimedia");
        BaseUtils.println("4 -> Printer");
        BaseUtils.println("5 -> Server");
        BaseUtils.println("q -> Quit");

        BaseUtils.print("-- Select operation: ");
        switch (BaseUtils.readText()) {
            case "1" -> routerUI();
            case "2" -> modemUI();
            case "3" -> multimediaUI();
            case "4" -> printerUI();
            case "5" -> serverUI();
            case "q" -> System.exit(0);
            default -> BaseUtils.println("Wrong choice!");
        }
        run();
    }

    public String baseUI() {
        BaseUtils.println("1 -> Show all");
        BaseUtils.println("2 -> Find by id");
        BaseUtils.println("3 -> Find by color");
        BaseUtils.println("4 -> Find by cost");
        BaseUtils.println("5 -> Filter by cost");
        BaseUtils.println("6 -> Find by branchName");
        BaseUtils.println("0 -> Back");

        BaseUtils.print("Select operation: ");
        return BaseUtils.readText();
    }

    private void routerUI() {
        BaseUtils.println("\n\n7 -> Find by speed");
        BaseUtils.println("8 -> Find by wireless");
        switch (baseUI()) {
            case "1" -> showAllRouter();
            case "2" -> routerController.findByID();
            case "3" -> routerController.findByColor();
            case "4" -> routerController.findByCost();
            case "5" -> routerController.filterByCost();
            case "6" -> routerController.findByBranchName();
            case "7" -> routerController.findBySpeed();
            case "8" -> routerController.findByWireless();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        routerUI();
    }

    private String showUI() {
        BaseUtils.println("\n\n1 -> Sort by id");
        BaseUtils.println("2 -> Sort by cost");
        BaseUtils.println("0 -> Back");

        BaseUtils.print("-- Select operation: ");
        return BaseUtils.readText();
    }

    private void showAllRouter() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            routerUI();
        }
        routerController.showAll(operation);
        showAllRouter();
    }

    private void modemUI() {
        BaseUtils.println("\n\n7 -> Find by Tariff");
        BaseUtils.println("8 -> Find by Tariff_Company_name");
        switch (baseUI()) {
            case "1" -> showAllModem();
            case "2" -> modemController.findByID();
            case "3" -> modemController.findByColor();
            case "4" -> modemController.findByCost();
            case "5" -> modemController.filterByCost();
            case "6" -> modemController.findByBranchName();
            case "7" -> modemController.findByIsTariff();
            case "8" -> modemController.findBytariff_company_name();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        modemUI();
    }

    private void showAllModem() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            modemUI();
        }
        modemController.showAll(operation);
        showAllModem();
    }

    private void multimediaUI() {
        BaseUtils.println("\n\n7 -> Find by CPU_Name");
        BaseUtils.println("8 -> Find by Memory");
        switch (baseUI()) {
            case "1" -> showAllMultimedia();
            case "2" -> multimediaController.findByID();
            case "3" -> multimediaController.findByColor();
            case "4" -> multimediaController.findByCost();
            case "5" -> multimediaController.filterByCost();
            case "6" -> multimediaController.findByBranchName();
            case "7" -> multimediaController.findByCPUName();
            case "8" -> multimediaController.findByMemory();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        multimediaUI();
    }

    private void showAllMultimedia() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            multimediaUI();
        }
        multimediaController.showAll(operation);
        showAllMultimedia();
    }

    private void printerUI() {
        BaseUtils.println("\n\n7 -> Find by height and width");
        switch (baseUI()) {
            case "1" -> showAllPrinter();
            case "2" -> printerController.findByID();
            case "3" -> printerController.findByColor();
            case "4" -> printerController.findByCost();
            case "5" -> printerController.filterByCost();
            case "6" -> printerController.findByBranchName();
            case "7" -> printerController.findByHeightAndWidth();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        printerUI();
    }

    private void showAllPrinter() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            printerUI();
        }
        printerController.showAll(operation);
        showAllPrinter();
    }

    private void serverUI() {
        BaseUtils.println("\n\n7 -> Find by CreationDate");
        BaseUtils.println("8 -> Find by Capacity");
        switch (baseUI()) {
            case "1" -> showAllServer();
            case "2" -> serverController.findByID();
            case "3" -> serverController.findByColor();
            case "4" -> serverController.findByCost();
            case "5" -> serverController.filterByCost();
            case "6" -> serverController.findByBranchName();
            case "7" -> serverController.findByCreationDate();
            case "8" -> serverController.findByCapacity();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        serverUI();
    }

    private void showAllServer() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            serverUI();
        }
        serverController.showAll(operation);
        showAllServer();
    }


}
