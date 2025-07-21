package com.mycompany.sistema_academico.mapper.factory;

import com.mycompany.sistema_academico.mapper.abstract_mapper.CreateMapper;
import com.mycompany.sistema_academico.mapper.abstract_mapper.ResponseMapper;
import com.mycompany.sistema_academico.mapper.abstract_mapper.UpdateMapper;

public interface MapperFactory<T, C, R, U> {

    CreateMapper<T, C> createMapper();
    ResponseMapper<T, R> responseMapper();
    UpdateMapper<T, U> updateMapper();

}
