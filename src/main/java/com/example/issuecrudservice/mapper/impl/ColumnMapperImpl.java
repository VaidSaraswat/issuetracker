package com.example.issuecrudservice.mapper.impl;

import com.example.issuecrudservice.dto.BoardDto;
import com.example.issuecrudservice.dto.ColumnDto;
import com.example.issuecrudservice.entities.BoardEntity;
import com.example.issuecrudservice.entities.ColumnEntity;
import com.example.issuecrudservice.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ColumnMapperImpl implements Mapper<ColumnEntity, ColumnDto> {

    private ModelMapper modelMapper;

    public ColumnMapperImpl(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
        this.modelMapper.createTypeMap(ColumnEntity.class, ColumnDto.class)
                .addMappings(mapper ->
                        mapper.map(src -> src.getBoardEntity().getBoardId(), ColumnDto::setBoardId)
                );
        this.modelMapper.createTypeMap(ColumnDto.class, ColumnEntity.class)
                .addMappings(mapper ->
                        mapper.map(
                                ColumnDto::getBoardId,
                                (dest, v) -> dest.getBoardEntity().setBoardId((Long) v)
                        )
                );
    }

    @Override
    public ColumnDto mapTo(ColumnEntity columnEntity) {
        return modelMapper.map(columnEntity, ColumnDto.class);
    }

    @Override
    public ColumnEntity mapFrom(ColumnDto columnDto) {
        return modelMapper.map(columnDto, ColumnEntity.class);
    }
}
