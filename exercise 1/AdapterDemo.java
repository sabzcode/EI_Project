class OldPrinter {
    public void printText(String text) {
        System.out.println("[OldPrinter] Printing: " + text);
    }
}

interface NewPrinter {
    void printDocument(String doc);
}

class PrinterAdapter implements NewPrinter {
    private OldPrinter oldPrinter;
    public PrinterAdapter(OldPrinter oldPrinter) { this.oldPrinter = oldPrinter; }
    public void printDocument(String doc) { oldPrinter.printText(doc); }
}

public class AdapterDemo {
    public static void main(String[] args) {
        OldPrinter oldPrinter = new OldPrinter();
        NewPrinter adapter = new PrinterAdapter(oldPrinter);

        adapter.printDocument("Hello via Adapter!");
    }
}