package br.com.vcsouza.banco_digital.domain.service.impl;

import br.com.vcsouza.banco_digital.domain.dto.UserDtoRequest;
import br.com.vcsouza.banco_digital.domain.model.Account;
import br.com.vcsouza.banco_digital.domain.model.User;
import br.com.vcsouza.banco_digital.domain.repository.UserRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    private UserDtoRequest dtoRequest;

    private User user;
    private Account account;

}