package com.warung_makan.aneka_rasa.specification;

import com.warung_makan.aneka_rasa.constant.MenuCategory;
import com.warung_makan.aneka_rasa.dto.request.SearchMenuRequest;
import com.warung_makan.aneka_rasa.entity.Menu;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MenuSpecification {
    public static Specification<Menu> getSpecification(SearchMenuRequest searchMenuRequest) {
        return new Specification<Menu>() {
            @Override
            public Predicate toPredicate(Root<Menu> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (StringUtils.hasText(searchMenuRequest.getName())) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + searchMenuRequest.getName().toLowerCase() + "%" ));
                }

                if (StringUtils.hasText(searchMenuRequest.getCategory())) {
                    try {
                        predicates.add(criteriaBuilder.equal(root.get("category"), MenuCategory.fromValue(searchMenuRequest.getCategory())));
                    }  catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException("Invalid category: " + searchMenuRequest.getCategory());
                    }
                }

                if (Boolean.TRUE.equals(searchMenuRequest.getIsReady())) {
                    predicates.add(criteriaBuilder.equal(root.get("isAvailable"), true));
                    predicates.add(criteriaBuilder.greaterThan(root.get("stock"), 0));
                } else if (Boolean.FALSE.equals(searchMenuRequest.getIsReady())) {
                    criteriaBuilder.equal(root.get("isAvailable"), false);
                    criteriaBuilder.lessThanOrEqualTo(root.get("stock"), 0);
                }

                Long minPrice = searchMenuRequest.getMinPrice();
                Long maxPrice = searchMenuRequest.getMaxPrice();

                if (minPrice != null && maxPrice != null) {
                    predicates.add(criteriaBuilder.between(root.get("price"), minPrice, maxPrice));
                } else if (minPrice != null) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
                } else if (maxPrice != null) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), maxPrice));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
