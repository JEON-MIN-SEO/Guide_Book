package guide_book.KTO_public_api.dto;

import guide_book.KTO_public_api.enums.ProviderEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String userEmail;

    private String password;

    private ProviderEnum provider;

    private String userid;
}
