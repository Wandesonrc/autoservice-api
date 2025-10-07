package com.autoservice.api.autoservice.service;

import com.autoservice.api.autoservice.dto.OrdemServicoDTO;
import com.autoservice.api.autoservice.model.OrdemServico;

public interface ConverteTo<T, A> {

    A converteToBack(T t);
    T converteToFront(A a);


}
