package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class Base<U> implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@LastModifiedBy
	@Column(name = "update_by")
	protected U updatedBy;

	@CreatedBy
	@Column(name = "created_by")
	protected U createdBy;

	@CreationTimestamp
	@Column(name = "created_at")
	protected Date createdAt;

	@UpdateTimestamp
	@Column(name = "update_at")
	protected Date updatedAt;

}