package mk.finki.ukim.mk.laboratoriska.bootstrap;

import lombok.Getter;
import mk.finki.ukim.mk.laboratoriska.model.Balloon;
import mk.finki.ukim.mk.laboratoriska.model.Manufacturer;
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
    public static List<Manufacturer> manufacturersList = new ArrayList<>();
    @PostConstruct
    public void init(){
        Manufacturer manufacturer1 = new Manufacturer("Manufacturer1","MKD","adresa1");
        Manufacturer manufacturer2 = new Manufacturer("Manufacturer2","MKD","adresa2");
        Manufacturer manufacturer3 = new Manufacturer("Manufacturer3","MKD","adresa3");
        Manufacturer manufacturer4 = new Manufacturer("Manufacturer4","MKD","adresa4");
        Manufacturer manufacturer5 = new Manufacturer("Manufacturer5","MKD","adresa5");
        balloonList.add(new Balloon("Red","Red Balloon",manufacturer1));
        balloonList.add(new Balloon("Green","Green Balloon",manufacturer2));
        balloonList.add(new Balloon("Blue","Blue Balloon",manufacturer3));
        balloonList.add(new Balloon("Yellow","Yellow Balloon",manufacturer4));
        balloonList.add(new Balloon("Cyan","Cyan Balloon",manufacturer5));
        balloonList.add(new Balloon("Purple","Purple Balloon",manufacturer1));
        balloonList.add(new Balloon("Orange","Orange Balloon",manufacturer2));
        balloonList.add(new Balloon("Black","Black Balloon",manufacturer3));
        balloonList.add(new Balloon("White","White Balloon",manufacturer4));
        balloonList.add(new Balloon("Gray","Gray Balloon",manufacturer5));
        manufacturersList.add(manufacturer1);
        manufacturersList.add(manufacturer2);
        manufacturersList.add(manufacturer3);
        manufacturersList.add(manufacturer4);
        manufacturersList.add(manufacturer5);


    }

}
