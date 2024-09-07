package br.com.vcsouza.banco_digital.domain.dto;

import br.com.vcsouza.banco_digital.domain.model.*;

import java.util.List;

public record UserDtoResponse(
        String name,
        Account account,
        Card card,
        List<Feature> features,
        List<News> news
) {
    public UserDtoResponse(User user) {

        this(
                user.getName(),
                user.getAccount(),
                user.getCard(),
                user.getFeatures(),
                user.getNews()
        );
    }
}
