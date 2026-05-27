package likelion_14th.api.service.ai;

import likelion_14th.api.dto.request.ai.AiChatRequest;
import likelion_14th.api.dto.response.ai.AiChatResponse;
import likelion_14th.api.exception.ai.AiResponseException;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AiServiceV2 {

    private final ChatClient chatClient;

    public AiChatResponse generateText(AiChatRequest request) {
        try {
            String answer = chatClient.prompt()
                    .user(request.getQuestion())
                    .call()
                    .content();
            return AiChatResponse.from(answer);
        } catch (Exception e) {
            throw new AiResponseException("AI 응답 처리 중 오류 발생");
        }
    }
}
