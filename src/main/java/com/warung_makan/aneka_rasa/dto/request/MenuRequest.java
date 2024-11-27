package com.warung_makan.aneka_rasa.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuRequest {
    private String name;
    private Long price;
    private String category;
    private Integer stock;
}
