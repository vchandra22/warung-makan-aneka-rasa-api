package com.warung_makan.aneka_rasa.dto.request;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SearchMenuRequest extends PagingRequest{
    private String name;
    private String category;
    private Long minPrice;
    private Long maxPrice;
    private Boolean isReady;
}
