package com.onegeneration.anything.itemservice.entity;

public enum Cardinality {
	NORTH_EAST("NE"), SOUTH_WEST("SW"), SOUTH_EAST("SE"), NORTH_WEST("NW");

	private String cardinality;

	private Cardinality(String cardinality) {
		this.cardinality = cardinality;
	}

	public String getCardinality() {
		return cardinality;
	}
}
