package Test;

public class DocumentCounter implements AbstractDocumentCounter{

    public DocumentCounter(int increment) {
        this.increment = increment;
    }
    private int count = 0;
    private int increment;

    @Override
    public String getNewDocumentName() {
        return null;
    }

    @Override
    public int getAndIncrement() {
        this.count += this.increment;
        return this.count;
    }

    public static class DocumentNameCreator extends DocumentCounter {
        private String prefix;

        public DocumentNameCreator(int increment, String prefix) {
            super(increment);
            this.prefix = prefix;
        }

        public String getNewDocumentName() {
            return prefix + getAndIncrement();
        }
    }
}

interface AbstractDocumentCounter{
    String getNewDocumentName();
    int getAndIncrement();
 }