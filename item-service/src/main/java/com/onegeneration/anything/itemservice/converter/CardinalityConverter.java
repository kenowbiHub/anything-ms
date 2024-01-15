package com.onegeneration.anything.itemservice.converter;

import java.util.stream.Stream;

import com.onegeneration.anything.itemservice.entity.Cardinality;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CardinalityConverter implements AttributeConverter<Cardinality, String> {

	@Override
	public String convertToDatabaseColumn(Cardinality cardinality) {
		 if (cardinality == null) {
	            return null;
	        }
	        return cardinality.getCardinality();
	}

	@Override
	public Cardinality convertToEntityAttribute(String cardinality) {
		if (cardinality == null) {
            return null;
        }
        return Stream.of(Cardinality.values())
          .filter(c -> c.getCardinality().equals(cardinality))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
	}

}
