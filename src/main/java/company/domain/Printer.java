package company.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Printer extends BaseDomain{
    private Double height;
    private Double width;

    @Builder(builderMethodName = "childBuilder")
    public Printer(Long id, String color, Double cost, String branchName, Double height, Double width) {
        super(id, color, cost, branchName);
        this.height = height;
        this.width = width;
    }
}
