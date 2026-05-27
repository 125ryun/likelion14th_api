package likelion_14th.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TranslateRequest {

    @NotBlank(message = "원문 언어 코드를 입력해주세요.")
    private String sourceLanguageCode;

    @NotBlank(message = "타겟 언어 코드를 입력해주세요.")
    private String targetLanguageCode;

    @NotEmpty(message = "번역할 내용을 입력해주세요.")
    private List<String> contents;

    public static TranslateRequest of(String source, String target, List<String> contents) {
        return new TranslateRequest(source, target, contents);
    }
}
