package company.domain;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Modem extends BaseDomain {
    private Boolean isTariff;
    private String Tariff_company_name;

    @Builder(builderMethodName = "childBuilder")
    public Modem(Long id, String color, Double cost, String branchName, Boolean isTariff, String Tariff_company_name) {
        super(id, color, cost, branchName);
        this.isTariff = isTariff;
        this.Tariff_company_name = Tariff_company_name;
    }
}
