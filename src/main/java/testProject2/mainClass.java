package testProject2;

import java.util.Optional;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProcessHandle.allProcesses()
        .forEach(process -> System.out.println(processDetails(process)));
		
		
		System.out.println("Changed Git message");
          
	}
	
	private static String processDetails(ProcessHandle process) {
	    return String.format("%8d %8s %10s %26s %-40s",
	            process.pid(),
	            text(process.parent().map(ProcessHandle::pid)),
	            text(process.info().user()),
	            text(process.info().startInstant()),
	            text(process.info().commandLine()));
	}

	private static String text(Optional<?> optional) {
	    return optional.map(Object::toString).orElse("-");
	}

}
