package com.greatlearning.employeemanagment.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	private String username;
	private String password;
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH},fetch = FetchType.EAGER)
	
//	@JoinTable(
//			name ="users_role",
//			joinColumns = @JoinColumn(name ="user_id"),
//			inverseJoinColumns = @JoinColumn(name="role_id")
//			)
	
	@JoinColumn( name = "role_id", nullable=false, referencedColumnName = "role_id")
	private Role roles;
	
	@JsonBackReference
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Employee employee;
	
}
