package web.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Beer {
    private Long id;
    private String name;
    private Integer idContainer;
    private int idTypeBeer;
    private float alcoholContent;
    private int ibu;
    private String count;
}
