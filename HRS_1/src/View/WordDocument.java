package View;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import model.Booking;
import model.Hotel;

public class WordDocument {

	

	public static void main(String[] args) {
		  List<Booking> transactions = new ArrayList<>(); 
		  for(Booking b : Hotel.getInstance().getAllBookings().values()) {
			  transactions.add(b);
		  }
		  XWPFDocument document = new XWPFDocument();
		  
		  XWPFParagraph generalParagraph = document.createParagraph();
	        XWPFRun generalRun = generalParagraph.createRun();
	        generalRun.setText("all bookings in the hotel:\n");
	        
	        for (Booking transaction : transactions) {
	            addTransactionDetails(document, transaction.getRoomNumber(), transaction.getTotalCost());
	        }
	        
	        try {
	            FileOutputStream outputStream = new FileOutputStream("TransactionDocument.docx");
	            document.write(outputStream);
	            outputStream.close();
	            System.out.println("Document created successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		  
	}
	private static void addTransactionDetails(XWPFDocument document, String transactionNumber, Double profit) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();

        run.setText("Transaction Number: " + transactionNumber);
        run.addBreak();
        run.setText("Profit: " + profit + " ₪");
        run.addBreak();
    }
	
	
	
	

}
