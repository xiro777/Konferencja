package Konferencja.services;

import Konferencja.db_classes.User;
import Konferencja.db_classes.UserRole;
import Konferencja.request.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final UserService userService;
    private final EmailValidator emailValidator;
    public String register(RegistrationRequest request)
    {

        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail)
        {
            throw new IllegalStateException("Email not valid!");
        }
        return userService.singUpUser(
                new User(
                        request.getFirst_name(),
                        request.getLast_name(),
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.USER)
        );
    }
}
