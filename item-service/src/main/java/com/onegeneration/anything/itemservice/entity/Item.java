package com.onegeneration.anything.itemservice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.onegeneration.anything.itemservice.model.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// uuid
	@Column(unique = true, nullable = false)
	private String itemId;
	private BigDecimal price;
	@Column(nullable = false)
	private String categoryId;
	private String name;
	private String description;
	private LocalDateTime createdAt;
	// Unidirectional
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address location;
	@Enumerated(EnumType.STRING)
	private ItemStatus status;
	@Column(nullable = false)
	private String ownerId;
	@Transient
	private Category category;
	
}
