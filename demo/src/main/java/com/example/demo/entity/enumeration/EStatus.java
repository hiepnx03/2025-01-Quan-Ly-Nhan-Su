package com.example.demo.entity.enumeration;

import lombok.Getter;

@Getter
public enum EStatus {
	INACTIVE(0),
	ACTIVE(1);

	private final Integer name;

	EStatus(Integer name) {
		this.name = name;
	}
}
