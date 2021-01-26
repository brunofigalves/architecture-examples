package pt.sample.exceptions;

public class SampleServiceException extends Exception {

    public SampleServiceException() {
    }

    public SampleServiceException(String message) {
        super(message);
    }
}
