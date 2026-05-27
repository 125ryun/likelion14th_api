package likelion_14th.api.dto.request.ai;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AiChatRequest {
    @NotBlank(message = "question은 비어 있을 수 없습니다.")
    private String question;
}
