package mk.finki.ukim.mk.laboratoriska.bootstrap;

import lombok.Getter;
import mk.finki.ukim.mk.laboratoriska.model.Balloon;
import mk.finki.ukim.mk.laboratoriska.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Balloon> balloonList = new ArrayList<>(10);
    public static List<Order> orderList = new ArrayList<>();
    @PostConstruct
    public void init(){
        balloonList.add(new Balloon("Red","Red Balloon"));
        balloonList.add(new Balloon("Green","Green Balloon"));
        balloonList.add(new Balloon("Blue","Blue Balloon"));
        balloonList.add(new Balloon("Yellow","Yellow Balloon"));
        balloonList.add(new Balloon("Cyan","Cyan Balloon"));
        balloonList.add(new Balloon("Purple","Purple Balloon"));
        balloonList.add(new Balloon("Orange","Orange Balloon"));
        balloonList.add(new Balloon("Black","Black Balloon"));
        balloonList.add(new Balloon("White","White Balloon"));
        balloonList.add(new Balloon("Gray","Gray Balloon"));
    }

}
