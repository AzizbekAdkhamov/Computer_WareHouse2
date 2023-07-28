package company;


import company.ui.AppUI;
import company.utils.BaseUtils;

public class Main {
    static AppUI appUI = new AppUI();

    public static void main(String[] args) {
        BaseUtils.println("\n\n*************** Project: Computer Equipments Warehouse *****************");
        BaseUtils.println("--------------- Author:  ---------------");
        BaseUtils.println("--------------- Email: @gmail.com ---------------");
        BaseUtils.println("--------------- Creation date: since 19/07/23 16:35 ---------------");
        BaseUtils.println("--------------- Version: version-0.0.1 ---------------");
        appUI.run();
    }
}