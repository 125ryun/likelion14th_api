package likelion_14th.api.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration //스프링의 환경 설정(Configuration)을 담당하는 클래스
public class GoogleTranslateConfig {

    @Value("${google.cloud.credentials.location}")
    private Resource credentialsLocation;

    @Bean
    public Translate translate() throws IOException {

        // Google 서비스 계정 인증 정보 생성
        GoogleCredentials credentials = GoogleCredentials
                .fromStream(credentialsLocation.getInputStream());

        // Translate API 객체 생성
        return TranslateOptions.newBuilder()
                .setCredentials(credentials)
                .build()
                .getService();
    }

}