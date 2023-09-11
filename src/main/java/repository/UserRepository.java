package repository;

import java.util.List;
import model.Authorities;
import java.util.ArrayList;
import java.util.Collections;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();
        if (user.equals("администратор") && password.equals("0000")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.equals("менеджер") && password.equals("1111")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE);
        } else if (user.equals("пользователь") && password.equals("2222")) {
            Collections.addAll(authorities, Authorities.READ);
        }
        return authorities;
    }
}