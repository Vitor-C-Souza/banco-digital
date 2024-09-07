package br.com.vcsouza.banco_digital.controller;

import br.com.vcsouza.banco_digital.domain.dto.UserDtoRequest;
import br.com.vcsouza.banco_digital.domain.dto.UserDtoResponse;
import br.com.vcsouza.banco_digital.domain.model.User;
import br.com.vcsouza.banco_digital.domain.service.conversor.UserConvert;
import br.com.vcsouza.banco_digital.domain.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl service;

    @Autowired
    private UserConvert convert;

    @PostMapping
    public ResponseEntity<UserDtoResponse> createUser(@RequestBody UserDtoRequest dto, UriComponentsBuilder uri){
        User user = service.create(dto);

        URI endereco = uri.path("user/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(endereco).body(convert.toDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoResponse> findUser(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDtoResponse> updateUser(@PathVariable Long id, @RequestBody UserDtoRequest dto){
        UserDtoResponse updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
