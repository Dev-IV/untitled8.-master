package untitled12.Exceptions;

public class NotEnoughPowerInLocomotiveException extends RuntimeException {


public NotEnoughPowerInLocomotiveException(String nameOfLocomotive){
        super("Train cannot start moving, the locomotive with name: "+nameOfLocomotive+" does not have enough power");
        }
        }

