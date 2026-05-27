package likelion_14th.api.controller.translate;

import jakarta.validation.Valid;
import likelion_14th.api.dto.request.TranslateRequest;
import likelion_14th.api.dto.response.TranslationListResponse;
import likelion_14th.api.service.translate.TranslateService;
import likelion_14th.api.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TranslateController {

    private final TranslateService translateService;

    @PostMapping("/translate")
    public ResponseEntity<ApiResponse<TranslationListResponse>> translate(
            @Valid @RequestBody TranslateRequest request
    ) {
        TranslationListResponse response = translateService.translate(request);
        return ResponseEntity.ok(
                ApiResponse.success(
                        200, "번역에 성공했습니다.", response
                )
        );
    }
}
