package br.com.vcsouza.banco_digital.domain.service.conversor;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.math.BigDecimal;

public class BigDecimalDeserializer extends JsonDeserializer<BigDecimal> {
    @Override
    public BigDecimal deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {
        return new BigDecimal(jp.getText());
    }
}
