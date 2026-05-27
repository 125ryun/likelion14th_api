package likelion_14th.api.service.translate;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translation;
import likelion_14th.api.dto.request.TranslateRequest;
import likelion_14th.api.dto.response.TranslationListResponse;
import likelion_14th.api.exception.translate.GoogleTranslateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TranslateService {

    //Config 클래스의 Bean 가져오기
    private final Translate translate;

    public TranslationListResponse translate(TranslateRequest request) {

        try {

            List<Translation> translationList = translate.translate(
                    request.getContents(), // 번역할 문장의 리스트
                    Translate.TranslateOption.sourceLanguage(request.getSourceLanguageCode()), // 원문 언어
                    Translate.TranslateOption.targetLanguage(request.getTargetLanguageCode()), // 요청 언어
                    Translate.TranslateOption.format("text") // 내가 보내는 데이터 형식
            );

            //API로부터 답을 받아 응답으로 변환
            return TranslationListResponse.from(translationList);

        } catch (Exception e) {

            throw new GoogleTranslateException("번역 호출 중 오류 발생");

        }
    }

}
