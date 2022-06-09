package com.capgemini.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "billionaires")
public class Billionaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	@NotNull(message = "The firstName is mandatory")
	@NotBlank(message = "The firstName should not be blank")
	private String firstName;

	@Column(name = "last_name")
	@NotNull(message = "The lastName is mandatory")
	@NotBlank(message = "The lastName should not be blank")
	private String lastName;

	@Column(name = "career")
	@NotNull(message = "The career is mandatory")
	@NotBlank(message = "The career should not be blank")
	private String career;

}
