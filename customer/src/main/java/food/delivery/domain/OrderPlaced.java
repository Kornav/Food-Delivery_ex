package food.delivery.domain;

import food.delivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String userId;
    private String orderId;
    private String storeId;
    private String menuId;
    private String qty;
    private String status;
}
