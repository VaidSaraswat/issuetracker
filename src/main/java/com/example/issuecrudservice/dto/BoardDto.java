package com.example.issuecrudservice.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BoardDto {
    private Long boardId;
    private String title;
    private Long ownerId;
}
