package notepad.util;

import notepad.ui.EditorWindow;

import org.fife.print.RPrintUtilities;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;

import java.awt.Graphics;
import java.awt.print.Printable;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PrintText {

    private EditorWindow editorWindow;
    private PrinterJob printerJob;
    private PrintRequestAttributeSet attributeSet;
    private PageFormat pageFormat;

    public PrintText (EditorWindow editorWindow){
        this.editorWindow = editorWindow;
        printerJob = PrinterJob.getPrinterJob();
        attributeSet = new HashPrintRequestAttributeSet();
    }

    private RSyntaxTextArea getTextArea(){
        int index = editorWindow.getSelectedIndex();
        return editorWindow.getTextEditor(index).getTextArea();
    }

    public void pageSetup(){
        pageFormat =  printerJob.pageDialog(attributeSet);
    }

    public void print() throws PrinterException{
        printerJob = PrinterJob.getPrinterJob();
        pageFormat = printerJob.pageDialog(attributeSet);

        RSyntaxTextArea textArea = getTextArea();
        printerJob.setPrintable(new NotepadPrintable(textArea), pageFormat);

        boolean result = printerJob.printDialog(attributeSet);
        if (result)
            printerJob.print();
    }

    public void printNow() throws PrinterException{
        printerJob = PrinterJob.getPrinterJob();

        RSyntaxTextArea textArea = getTextArea();
        if (pageFormat == null)
            printerJob.setPrintable(new NotepadPrintable(textArea), printerJob.defaultPage());
        else
            printerJob.setPrintable(new NotepadPrintable(textArea), pageFormat);

        printerJob.print();
    }

    class NotepadPrintable implements  Printable{

        private RSyntaxTextArea textArea;
        private int[] pageBreak;

        public NotepadPrintable(RSyntaxTextArea textArea){
            this.textArea = textArea;
        }

        private void initPageBreak(PageFormat pageFormat) {
            if (pageBreak == null){
                int linesPerPage = (int) pageFormat.getImageableHeight() / textArea.getLineHeight();
                int numBreaks = (textArea.getLineCount() - 1) / linesPerPage;

                pageBreak = new int[numBreaks];
                for (int i = 0; i < numBreaks; i++)
                    pageBreak[i] = (i + 1) * linesPerPage;
            }
        }
        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

            initPageBreak(pageFormat);
            if (pageIndex > pageBreak.length)
                return NO_SUCH_PAGE;

            RPrintUtilities.printDocumentMonospacedWordWrap(graphics, textArea.getDocument(), 10,
                    pageIndex, pageFormat, textArea.getTabSize());

            return PAGE_EXISTS;
        }
    }
}
