package chainofResponsibility;

public class ErrorLogProcessor extends LogProcessor  {
    ErrorLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void log(int logLevel, String message) {
        if(logLevel == ERROR){
            System.out.println("INFO: "+message);
        }
        super.log(logLevel, message);
    }
}
