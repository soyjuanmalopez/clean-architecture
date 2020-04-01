package com.d4i.sample.movie.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CATEGORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity implements Serializable {

	private static final long serialVersionUID = 4471777119419172870L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySeq")
	@SequenceGenerator(name = "categorySeq", sequenceName = "category_id_seq", allocationSize=1)
	private Long id;

	@Column(name = "NAME", unique = true)
	private String name;

	@Column(name = "AVAILABLE", unique = true)
	private Boolean available;

}
