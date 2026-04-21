package chainofResponsibility;

public class main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logProcessor.log(LogProcessor.ERROR,"Exception occurred");
        logProcessor.log(LogProcessor.DEBUG,"Need to debug this");
        logProcessor.log(LogProcessor.INFO,"Just fr info");
    }
}
