package mk.finki.ukim.mk.laboratoriska.model;

import lombok.Data;

@Data
public class Order {

    private String balloonColor;
    private String balloonSize;
    private String clientName;
    private String clientAddress;
    private Long orderId;

    public Order(String balloonColor, String balloonSize, String clientName, String clientAddress) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
    }
}
