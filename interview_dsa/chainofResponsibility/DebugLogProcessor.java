package chainofResponsibility;

public class DebugLogProcessor extends LogProcessor{
    DebugLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void log(int logLevel, String message) {
        if(logLevel == DEBUG){
            System.out.println("INFO: "+message);
        }
        super.log(logLevel, message);
    }
}
