package com.warung_makan.aneka_rasa.util;

import com.warung_makan.aneka_rasa.dto.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity<CommonResponse<T>> buildResponse(HttpStatus status, String message, T data) {
        CommonResponse<T> response = new CommonResponse<>(status.value(), message, data);

        return ResponseEntity.status(status).body(response);
    }
}
