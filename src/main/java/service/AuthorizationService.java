package service;

import java.util.List;
import model.Authorities;
import repository.UserRepository;
import exception.UnauthorizedUser;
import exception.InvalidCredentials;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("Имя пользователя или пароль отсутствуют");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Пользователь неизвестен " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {

        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {

        return str == null || str.isEmpty();
    }
}