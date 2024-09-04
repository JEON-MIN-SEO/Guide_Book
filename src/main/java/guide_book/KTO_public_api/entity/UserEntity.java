package guide_book.KTO_public_api.entity;

import guide_book.KTO_public_api.enums.ProviderEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "user_email")
    private String userEmail;

    @Column(name = "password")
    private String password;

    @Column(name = "line_user_id")
    private String lineUserId;

    @Column(name = "provider")
    private ProviderEnum provider;
}
