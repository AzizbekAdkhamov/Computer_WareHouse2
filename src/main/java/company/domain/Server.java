package company.domain;

import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Server extends BaseDomain{
    private Double capacity;
    private Timestamp creation_date;

    @Builder(builderMethodName = "childBuilder")
    public Server(Long id, String color, Double cost, String branchName, Double capacity, Timestamp creation_date) {
        super(id, color, cost, branchName);
        this.capacity = capacity;
        this.creation_date = creation_date;
    }
}
