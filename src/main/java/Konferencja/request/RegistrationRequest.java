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
    public final String first_name;
    public final String last_name;
    public final String password;
    public final String email;

}
