package mk.finki.ukim.mk.laboratoriska.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "eshop_user")
public class User {
    @Id
    private String username;
    private String password;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<ShoppingCart> carts;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.carts = new ArrayList<>();
    }

    public User() {

    }
}
