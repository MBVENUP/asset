package com.sprint1.assets.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {
	
	@ExceptionHandler(NotFoundException.class)
	public @ResponseBody ErrorInfo NotFoundExceptionHandler(NotFoundException n, HttpServletRequest req) {
		ErrorInfo er = new ErrorInfo(LocalDateTime.now(), n.getMessage(), req.getRequestURI());
		return er;
	}

}