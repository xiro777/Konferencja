package Konferencja.db_classes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @Id
    @SequenceGenerator(name = "token_generator", sequenceName = "token_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_generator")
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "User_id"
    )
    private User user;

    public ConfirmationToken(String token, LocalDateTime createAt, LocalDateTime expiresAt,User user) {
        this.token = token;
        this.createAt = createAt;
        this.expiresAt = expiresAt;
        this.user = user;
    }
}
