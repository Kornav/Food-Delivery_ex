package food.delivery.infra;

import food.delivery.domain.*;
import food.delivery.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderStatusViewHandler {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            OrderStatus orderStatus = new OrderStatus();
            // view 객체에 이벤트의 Value 를 set 함
            orderStatus.setOrderId(orderPlaced.getOrderId());
            orderStatus.setStoreId(orderPlaced.getStoreId());
            orderStatus.setStatus("주문됨");
            // view 레파지 토리에 save
            orderStatusRepository.save(orderStatus);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderAccepted_then_UPDATE_1(@Payload OrderAccepted orderAccepted) {
        try {
            if (!orderAccepted.validate()) return;
                // view 객체 조회

                List<OrderStatus> orderStatusList = orderStatusRepository.findByOrderId(orderAccepted.getOrderId());
                for(OrderStatus orderStatus : orderStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderStatus.setStatus("접수됨");
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderRejected_then_UPDATE_2(@Payload OrderRejected orderRejected) {
        try {
            if (!orderRejected.validate()) return;
                // view 객체 조회

                List<OrderStatus> orderStatusList = orderStatusRepository.findByOrderId(orderRejected.getOrderId());
                for(OrderStatus orderStatus : orderStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderStatus.setStatus("거절됨");
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookingStart_then_UPDATE_3(@Payload CookingStart cookingStart) {
        try {
            if (!cookingStart.validate()) return;
                // view 객체 조회

                List<OrderStatus> orderStatusList = orderStatusRepository.findByOrderId(cookingStart.getOrderId());
                for(OrderStatus orderStatus : orderStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderStatus.setStatus("요리중");
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

