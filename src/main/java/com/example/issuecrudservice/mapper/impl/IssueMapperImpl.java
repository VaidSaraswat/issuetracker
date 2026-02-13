package com.example.issuecrudservice.mapper.impl;

import com.example.issuecrudservice.dto.IssueDto;
import com.example.issuecrudservice.entities.IssueEntity;
import com.example.issuecrudservice.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class IssueMapperImpl implements Mapper<IssueEntity, IssueDto> {

    private ModelMapper modelMapper;

    public IssueMapperImpl() {

        this.modelMapper = new ModelMapper();
        this.modelMapper.createTypeMap(IssueEntity.class, IssueDto.class).addMappings(mapper -> {
            mapper.map(src -> src.getAssignee().getUserId(), IssueDto::setAssigneeId);
            mapper.map(src -> src.getColumnEntity().getColumnId(), IssueDto::setColumnId);
        });

        this.modelMapper.createTypeMap(IssueDto.class, IssueEntity.class).addMappings(mapper -> {
            mapper.map(IssueDto::getColumnId, (dest, v) -> {
                        dest.getColumnEntity().setColumnId((Long) v);
                    }
            );
            mapper.map(IssueDto::getAssigneeId, (dest, v) -> {
                dest.getAssignee().setUserId((Long) v);
            });
        });
    }

    public IssueDto mapTo(IssueEntity issueEntity) {
        return this.modelMapper.map(issueEntity, IssueDto.class);
    }

    public IssueEntity mapFrom(IssueDto issueDto) {
        return this.modelMapper.map(issueDto, IssueEntity.class);
    }
}
