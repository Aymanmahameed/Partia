package model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import utils.Area;
import utils.Gender;


public class Serialization {
	public static void main(String[] args) throws ClassNotFoundException {
		Date d = new Date();
		Customer c = new Customer("432", "32131","2312", "23123",Area.Jerusalem, Gender.M, 0, d);
		Booking b = new Booking("ccc", c, d, 312312);
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("DataBase.ser");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			System.out.println(b);
			objectOutputStream.writeObject(b);

			objectOutputStream.close();
			fileOutputStream.close();

			System.out.println("Standr object serialized successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileInputStream fileInputStream = new FileInputStream("DataBase.ser");
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

			try {
				while (true) {
					
					Booking bb = ((Booking) objectInputStream.readObject());
					System.out.println(bb);
					System.out.println(bb.getCustomer());
					System.out.println("sht4al");
					
				

				}
			} catch (EOFException e) {
				// End of file reached
			}
		} catch (IOException | ClassNotFoundException e) {

			e.printStackTrace();

		}
	}

}
