package ru.bellintegrator.practice.advice;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.practice.exception.CustomErrorException;
import ru.bellintegrator.practice.message.Response;
import ru.bellintegrator.practice.message.ResponseError;

@RestControllerAdvice
public class WebRestControllerAdvice {
	@ExceptionHandler(CustomErrorException.class)
	public Response handleResponseException(CustomErrorException ex) {
		Response error = new ResponseError(ex.getMessage());
		return error;
	}

}