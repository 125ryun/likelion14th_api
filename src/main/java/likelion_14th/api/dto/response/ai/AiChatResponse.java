package likelion_14th.api.dto.response.ai;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class AiChatResponse {
    private String answer;

    public static AiChatResponse from(String answer) {
        return new AiChatResponse(answer);
    }
}
