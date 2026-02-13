package com.example.issuecrudservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class IssueDto {
    private Long issueId;
    private String title;
    private String description;
    private Long assigneeId;
    private Long columnId;
}
