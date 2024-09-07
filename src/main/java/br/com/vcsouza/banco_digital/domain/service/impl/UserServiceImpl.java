package br.com.vcsouza.banco_digital.domain.service.impl;

import br.com.vcsouza.banco_digital.domain.dto.UserDtoRequest;
import br.com.vcsouza.banco_digital.domain.dto.UserDtoResponse;
import br.com.vcsouza.banco_digital.domain.model.User;
import br.com.vcsouza.banco_digital.domain.repository.UserRepository;
import br.com.vcsouza.banco_digital.domain.service.UserService;
import br.com.vcsouza.banco_digital.domain.service.conversor.UserConvert;
import br.com.vcsouza.banco_digital.infra.exception.BusinessException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserConvert convert;

    @Autowired
    private UserRepository repository;

    @Override
    public UserDtoResponse findById(Long id) {
        var userOptional = repository.findById(id);
        if (userOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        return convert.toDto(userOptional.get());
    }

    @Override
    public User create(UserDtoRequest dto) {
        if (repository.existsByAccountNumber(dto.account().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        var user = convert.toModel(dto);

        repository.save(user);
        return user;
    }

    @Transactional
    @Override
    public UserDtoResponse update(long id, UserDtoRequest dtoRequest) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (!user.getAccount().getNumber().equals(dtoRequest.account().getNumber())) {
                throw new BusinessException("Update account number must be the same.");
            }
            user.update(dtoRequest);
            repository.save(user);
            return convert.toDto(user);
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
