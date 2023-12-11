package ru.kfu.kafkaWebSite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageableListDto<T> {

    private Long totalItems;
    private Integer totalPages;
    private List<T> data;

    public static <T> PageableListDto<T> from(Page<T> page) {
        return new PageableListDto<>(page.getTotalElements(), page.getTotalPages(), page.getContent());
    }
}
