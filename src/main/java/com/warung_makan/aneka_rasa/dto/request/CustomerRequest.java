package com.warung_makan.aneka_rasa.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest {
    private String name;
    private String phoneNumber;
    private String email;
}
