package food.delivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class OrderStatus {

    private Long id;
    private String orderId;
    private String storeId;
    private String status;
}


