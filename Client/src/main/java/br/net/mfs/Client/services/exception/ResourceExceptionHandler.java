package br.net.mfs.Client.services.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.net.mfs.Client.resources.exceptions.StandardError;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class )
	public ResponseEntity< StandardError > entityNotFound( EntityNotFoundException e, HttpServletRequest request ){
		
		StandardError error = new StandardError();
		error.setTimestamp( Instant.now() );
		error.setStatus( HttpStatus.NOT_FOUND.value() );
		error.setError( "Resource not Found" );
		error.setMessage( e.getMessage() );
		error.setPath( request.getRequestURI() );
		
		return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( error ) ;
		
	}

}
