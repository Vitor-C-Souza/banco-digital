package br.com.vcsouza.banco_digital.domain.service.conversor;

import br.com.vcsouza.banco_digital.domain.dto.UserDtoRequest;
import br.com.vcsouza.banco_digital.domain.dto.UserDtoResponse;
import br.com.vcsouza.banco_digital.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConvert {

    public UserDtoResponse toDto(User user) {
        return new UserDtoResponse(user);
    }

    public User toModel(UserDtoRequest dto) {
        return new User(dto);
    }
}
