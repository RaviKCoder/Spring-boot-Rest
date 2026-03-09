package com.ravi.advice;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
	private String message;
	private Integer statusCode;
	private String path;
	private LocalDateTime timestamp;

}
