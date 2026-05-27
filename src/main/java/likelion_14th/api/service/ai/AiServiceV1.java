package likelion_14th.api.service.ai;

import likelion_14th.api.dto.request.ai.AiChatRequest;
import likelion_14th.api.dto.response.ai.AiChatResponse;
import likelion_14th.api.exception.ai.AiResponseException;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AiServiceV1 {

    //OpenAI의 LLM 구현 클래스를 이용해서 ChatModel 빈 생성
    private final ChatModel chatModel;

    //SystemMessage에 넣을 텍스트
    private static final String DEFAULT_SYSTEM_PROMPT =
            "사용자 질문에 대해 한국어로 답변을 해야 합니다.";

    // 동기 + 블로킹 방식
    public AiChatResponse generateText(AiChatRequest request) {

        // SystemMessage 생성
        SystemMessage systemMessage = SystemMessage.builder()
                .text(DEFAULT_SYSTEM_PROMPT)
                .build();

        // UserMessage 생성
        UserMessage userMessage = UserMessage.builder()
                .text(request.getQuestion())
                .build();

        // 프롬프트 생성
        Prompt prompt = Prompt.builder()
                .messages(systemMessage, userMessage)
                .build();

        // LLM 호출
        ChatResponse chatResponse= chatModel.call(prompt);
        AssistantMessage assistantMessage =
                chatResponse.getResult().getOutput();

        //예외 처리
        if (assistantMessage == null || assistantMessage.getText() == null) {
            throw new AiResponseException("AI 응답 처리 중 오류 발생");
        }

        // AiChatResponse로 변환 후 반환
        return AiChatResponse.from(assistantMessage.getText());
    }
}
