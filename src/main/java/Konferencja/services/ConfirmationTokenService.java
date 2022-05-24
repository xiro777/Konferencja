package Konferencja.services;

import Konferencja.db_classes.ConfirmationToken;
import Konferencja.repositories.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token)
    {
        confirmationTokenRepository.save(token);
    }
}
