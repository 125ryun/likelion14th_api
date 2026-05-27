package likelion_14th.api.controller.ai;

import jakarta.validation.Valid;
import likelion_14th.api.dto.request.ai.AiChatRequest;
import likelion_14th.api.dto.response.ai.AiChatResponse;
import likelion_14th.api.global.response.ApiResponse;
import likelion_14th.api.service.ai.AiServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/ai")
@RequiredArgsConstructor
public class AiControllerV2 {

    private final AiServiceV2 aiServiceV2;

    @PostMapping("/chat-client")
    public ResponseEntity<ApiResponse<AiChatResponse>> chatClient(
            @Valid @RequestBody AiChatRequest request) {
        AiChatResponse response = aiServiceV2.generateText(request);
        return ResponseEntity.ok(ApiResponse.success(200, "V2 호출에 성공했습니다.", response));
    }

}
