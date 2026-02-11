package com.example.issuecrudservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class IssueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueId;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity assignee;
    
    @ManyToOne
    @JoinColumn(name = "column_id")
    private ColumnEntity columnEntity;
}
