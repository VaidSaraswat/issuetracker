package com.example.issuecrudservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ColumnDto {
    private Long columnId;
    private String title;
    private float pos;
    private BoardDto board;
}
