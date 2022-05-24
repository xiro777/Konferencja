package Konferencja.services;

import Konferencja.db_classes.User;
import Konferencja.repositories.EventRepository;
import Konferencja.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final static String USER_NOT_FOUND_MESSAGE =
            "User with email %s not found!";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            return userRepository.findByEmail(email).
                    orElseThrow
                            (()->new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE,email)));

    }

    public String singUpUser(User user){
        boolean user_exists =  userRepository.findByEmail(user.getEmail())
                .isPresent();
        if(user_exists)
        {
            throw new IllegalStateException("Email already taken!");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        // TODO: Send confirmation token

        return "";
    }

}
