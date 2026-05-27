package likelion_14th.api.dto.response.translate;

import com.google.cloud.translate.Translation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TranslationListResponse {

    private List<TranslationResponse> translations;

    public static TranslationListResponse from(List<Translation> googleTranslations) {

        List<TranslationResponse> responseList = googleTranslations.stream()
                .map(t -> new TranslationResponse(t.getTranslatedText()))
                .toList();

        return new TranslationListResponse(responseList);
    }
}
