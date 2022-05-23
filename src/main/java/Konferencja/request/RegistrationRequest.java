package Konferencja.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest  {
    private final String first_name;
    private final String last_name;
    private final String password;
    private final String email;
}
