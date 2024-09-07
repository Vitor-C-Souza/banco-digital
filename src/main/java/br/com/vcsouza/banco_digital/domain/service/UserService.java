package br.com.vcsouza.banco_digital.domain.service;

import br.com.vcsouza.banco_digital.domain.dto.UserDtoRequest;
import br.com.vcsouza.banco_digital.domain.dto.UserDtoResponse;
import br.com.vcsouza.banco_digital.domain.model.User;

public interface UserService {
    UserDtoResponse findById(Long id);

    User create(UserDtoRequest dto);

    UserDtoResponse update(long id, UserDtoRequest dtoRequest);

    void delete(Long id);
}
