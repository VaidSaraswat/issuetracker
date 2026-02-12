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
    }
    public IssueDto mapTo(IssueEntity issueEntity) {
        return this.modelMapper.map(issueEntity, IssueDto.class);
    }

    public IssueEntity mapFrom(IssueDto issueDto) {
        return this.modelMapper.map(issueDto, IssueEntity.class);
    }
}
