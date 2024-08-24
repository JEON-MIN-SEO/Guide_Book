package guide_book.KTO_public_api.service;

import guide_book.KTO_public_api.dto.UserDTO;
import guide_book.KTO_public_api.entity.UserEntity;
import guide_book.KTO_public_api.enums.ProviderEnum;
import guide_book.KTO_public_api.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void JoinProcess(UserDTO userDTO) {
        /*
        DBへ同じユーザがあるか確認するメソッドが必要
        UserRepositoryでexistsByメソッドを使う
        */
        if (userRepository.existsByUserEmail(userDTO.getUserEmail())) {
            throw new IllegalArgumentException("すでに存在するEmailです"); // 例外処理または好きな方法で対応
        }


        //DTOをEntityに変換
        UserEntity data = new UserEntity();
        data.setUserEmail(userDTO.getUserEmail());
        data.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        data.setProvider(ProviderEnum.local);
        userRepository.save(data);
    }
}
