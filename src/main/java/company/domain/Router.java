package company.domain;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Router extends BaseDomain {
    private Boolean wireless;
    private Double speed;

    @Builder(builderMethodName = "childBuilder")
    public Router(Long id, String color, Double cost, String branchName, Boolean wireless, Double speed) {
        super(id, color, cost, branchName);
        this.wireless = wireless;
        this.speed = speed;
    }
}
