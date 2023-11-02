package com.sx.model.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = -385319221260674974L;
	private String msg;
	
	public CustomException(String message) {
		super(message);
	}
}
