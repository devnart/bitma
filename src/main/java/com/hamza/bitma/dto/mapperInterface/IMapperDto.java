package com.hamza.bitma.dto.mapperInterface;

import java.util.Collection;
import java.util.List;

public interface IMapperDto<E,D> {

    D convertToDto(E entity, Class<D> dtoClass);

    E convertToEntity(D dto, Class<E> entityClass);

    List<D> convertListToListDto(Collection<E> entityList, Class<D> outCLass);

    List<E> convertListToListEntity(Collection<D> DtoList, Class<E> entityCLass);
}
