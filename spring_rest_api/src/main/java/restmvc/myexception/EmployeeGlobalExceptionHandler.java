package restmvc.myexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<EmployeeIncorrectData> handleExceptionEmployee(NoSuchEmloyeeException exception) {

		EmployeeIncorrectData data = new EmployeeIncorrectData();
		data.setInfo(exception.getMessage());

		return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler
	public ResponseEntity<EmployeeIncorrectData> handleExceptionEmployee(Exception exception) {

		EmployeeIncorrectData data = new EmployeeIncorrectData();
		data.setInfo(exception.getMessage());

		return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);

	}
}
