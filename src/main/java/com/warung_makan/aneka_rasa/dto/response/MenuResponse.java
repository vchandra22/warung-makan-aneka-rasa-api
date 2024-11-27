package com.warung_makan.aneka_rasa.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuResponse {
    private String id;
    private String name;
    private Long price;
    private Integer stock;
    private String category;
}
