package com.mycompany.sistema_academico.mapper;

public interface Mapper<T, K> {

    T toEntity(K k);

    K toDTO(T t);
}
