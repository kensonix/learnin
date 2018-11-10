package chapter12.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException extends Exception{
	private static final long serialVersionUID = 1L;
	private static Logger  logger = Logger.getLogger("LoggingException");
	public LoggingException(){
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}

public class LoggingExceptions extends Exception {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args){
		try{
			throw new LoggingException();
		}catch(LoggingException e){
			System.err.println("Caught " + e);
		}
		
		try{
			throw new LoggingException();
		}catch(LoggingException e){
			System.err.println("Caught "+ e);
		}
	}
}
