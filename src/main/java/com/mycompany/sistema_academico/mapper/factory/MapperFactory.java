package com.mycompany.sistema_academico.mapper.factory;

import com.mycompany.sistema_academico.mapper.abstract_mapper.CriacaoMapper;
import com.mycompany.sistema_academico.mapper.abstract_mapper.RespostaMapper;

public interface MapperFactory<T, C, R, U> {

    CriacaoMapper<T, C> criarCriacaoMapper();
    RespostaMapper<T, R> criarRespostaMapper();

}
