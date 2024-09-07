package br.com.vcsouza.banco_digital.domain.model;

import br.com.vcsouza.banco_digital.domain.dto.UserDtoRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "tb_user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Feature> features;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> news;

    public User(UserDtoRequest dto) {
        this.name = dto.name();
        this.account = dto.account();
        this.card = dto.card();
        this.features = dto.features();
        this.news = dto.news();
    }


    public void update(UserDtoRequest dto) {
        this.name = dto.name();
        this.account = dto.account();
        this.card = dto.card();
        this.features = dto.features();
        this.news = dto.news();
    }
}
