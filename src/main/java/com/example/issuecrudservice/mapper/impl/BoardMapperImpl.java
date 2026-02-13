package com.example.issuecrudservice.mapper.impl;

import com.example.issuecrudservice.dto.BoardDto;
import com.example.issuecrudservice.entities.BoardEntity;
import com.example.issuecrudservice.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BoardMapperImpl implements Mapper<BoardEntity, BoardDto> {

    private ModelMapper modelMapper;

    public BoardMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.createTypeMap(BoardEntity.class, BoardDto.class)
                .addMappings(mapper ->
                        mapper.map(src -> src.getOwner().getUserId(), BoardDto::setOwnerId)
                );
        this.modelMapper.createTypeMap(BoardDto.class, BoardEntity.class)
                .addMappings(mapper ->
                        mapper.map(BoardDto::getOwnerId, (dest, v) -> dest.getOwner().setUserId((Long) v))
                );
    }

    @Override
    public BoardDto mapTo(BoardEntity boardEntity) {
        return modelMapper.map(boardEntity, BoardDto.class);
    }

    @Override
    public BoardEntity mapFrom(BoardDto boardDto) {
        return modelMapper.map(boardDto, BoardEntity.class);
    }
}
