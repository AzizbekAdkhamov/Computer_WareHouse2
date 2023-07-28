package company.domain;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Multimedia extends BaseDomain {
    private String CPU_name;
    private Double memory;


    @Builder(builderMethodName = "childBuilder")
    public Multimedia(Long id, String color, Double cost, String branchName, String CPU_name, Double memory) {
        super(id, color, cost, branchName);
        this.CPU_name = CPU_name;
        this.memory = memory;
    }
}
