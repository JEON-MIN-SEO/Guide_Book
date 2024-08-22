package guide_book.KTO_public_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

@Configuration
@EnableWebSecurity //ウェブ セキュリティ設定を有効にする　
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((auth)->auth //requestMatchers()는 특정주소를 의미
                        .requestMatchers("/", "/login").permitAll()
                        //permitAll()はみんなに接続を許可します
                        .requestMatchers("/home/**","bookMark/**","guideBook/**").authenticated()
                        //authenticated()はログイン後に接続できます
                        .anyRequest().authenticated());
                        //.anyRequest()は他に設定できなかった他の経路を設定します
                        //.requestMatchers("/home/**")で**はワイルドカードを意味し/home/　後に来るURL全てを意味します
                        //hasRole("ADMIN", "USER')など（）中に色んな役割を入れて接触許可を許します

                        //注意！！！　設定の動作順序は上から下なので注意が必要
        return http.build();
    }
}