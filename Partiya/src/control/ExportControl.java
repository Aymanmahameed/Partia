package control;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import entity.Consts;



public class ExportControl {
	private static ExportControl instance;

	private ExportControl() {
		
	}

	public static ExportControl getInstance() {
		if (instance == null)
			instance = new ExportControl();
		return instance;
	}
	
	 public void exportParticipantToXML() {
		 try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);

						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_PARTICIPANTINPARTY);

						ResultSet rs = stmt.executeQuery())

				{
	                
	                // create document object.
	                Document doc = DocumentBuilderFactory.newInstance()
	                        .newDocumentBuilder().newDocument();
	                
	                // push root element into document object.
	                Element rootElement = doc.createElement("Participant_info");
	                rootElement.setAttribute("exportDate", LocalDateTime.now().toString());
	                doc.appendChild(rootElement);
	                
	                while (rs.next()) {     // run on all customer records..
	                    // create customer element.
	                    Element participant = doc.createElement("Participant");
	                    
	                    // assign key to customer.
	                    Attr attr = doc.createAttribute("ParticipantID");
	                    attr.setValue(rs.getString(1));
	                    participant.setAttributeNode(attr);
	                    
	                    // push elements to customer.
	                    for (int i = 2; i <= rs.getMetaData().getColumnCount(); i++) {
	                        Element element = doc.createElement(
	                                rs.getMetaData().getColumnName(i)); // push element to doc.
	                        rs.getObject(i); // for wasNull() check..
	                        element.appendChild(doc.createTextNode(
	                                rs.wasNull() ? "" : rs.getString(i)));  // set element value.
	                        participant.appendChild(element);  // push element to customer.
	                    }
	                    
	                    // push customer to document's root element.
	                    rootElement.appendChild(participant);
	                }
	                
	                // write the content into xml file
	                
	                DOMSource source = new DOMSource(doc);
	                File file = new File("xml/Locations.xml");
	                file.getParentFile().mkdir(); // create xml folder if doesn't exist.
	                StreamResult result = new StreamResult(file);
	                TransformerFactory factory = TransformerFactory.newInstance();
	                
	                // IF CAUSES ISSUES, COMMENT THIS LINE.
	                factory.setAttribute("indent-number", 2);
	                //
	                
	                Transformer transformer = factory.newTransformer();
	                
	                // IF CAUSES ISSUES, COMMENT THESE 2 LINES.
	                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	                //
	                
	                transformer.transform(source, result);
	                
	                System.out.println("Participant data exported successfully!");
	            } catch (SQLException | NullPointerException | ParserConfigurationException
	                    | TransformerException e) {
	                e.printStackTrace();
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
}
