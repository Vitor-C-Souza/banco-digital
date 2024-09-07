package br.com.vcsouza.banco_digital.domain.dto;

import br.com.vcsouza.banco_digital.domain.model.Account;
import br.com.vcsouza.banco_digital.domain.model.Card;
import br.com.vcsouza.banco_digital.domain.model.Feature;
import br.com.vcsouza.banco_digital.domain.model.News;

import java.util.List;

public record UserDtoRequest(
        String name,
        Account account,
        Card card,
        List<Feature> features,
        List<News> news
) {}
