package untitled12.Exceptions;

public class NothingToTransportException extends RuntimeException {
    public NothingToTransportException(String trainName) {
        super("Nothing to transport in train with name: " + trainName);
    }
}
