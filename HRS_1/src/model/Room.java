package model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

public abstract class Room implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int runningNumber =1;
    private String roomNumber;
    private double dailyPrice;
    private int floor;
    private double avgDailyCost;
    private double roomGrade;
    private int maxPopulationCapacity;
    private int size;
    private boolean isBooked;


	public Room(double dailyPrice, int floor, double avgDailyCost, double roomGrade,
			int maxPopulationCapacity, int size) {
		super();
		this.roomNumber = String.valueOf(runningNumber++);
		this.dailyPrice = dailyPrice;
		this.floor = floor;
		this.avgDailyCost = avgDailyCost;
		this.roomGrade = roomGrade;
		this.maxPopulationCapacity = maxPopulationCapacity;
		this.size = size;
		this.isBooked = false;
	}

	 public static void writeserNum() throws IOException{
	    	try {
				FileOutputStream fileOutputStream = new FileOutputStream("RoomNum.ser");
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
				
				objectOutputStream.writeObject(runningNumber);

				objectOutputStream.close();
				fileOutputStream.close();

				System.out.println("running object serialized successfully.");
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	 
	 public static void readserNum() {
	    	try (FileInputStream fileInputStream = new FileInputStream("RoomNum.ser");
					ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

				try {
					while (true) {
						int readNum = ((int) objectInputStream.readObject());
						Room.runningNumber=readNum;
						
					
					}
				} catch (EOFException e) {
					// End of file reached
				}
			} catch (IOException | ClassNotFoundException e) {

				e.printStackTrace();

			}
	    }


	public boolean isBooked() {
		return isBooked;
	}




	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}




	public static int getRunningNumber() {
		return runningNumber;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	@SuppressWarnings("static-access")
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber + (this.runningNumber-1);
	}




	public double getDailyPrice() {
		return dailyPrice;
	}




	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}


	public int getFloor() {
		return floor;
	}




	public void setFloor(int floor) {
		this.floor = floor;
	}




	public double getAvgDailyCost() {
		return avgDailyCost;
	}




	public void setAvgDailyCost(double avgDailyCost) {
		this.avgDailyCost = avgDailyCost;
	}




	public double getRoomGrade() {
		return roomGrade;
	}




	public void setRoomGrade(double roomGrade) {
		this.roomGrade = roomGrade;
	}




	public int getMaxPopulationCapacity() {
		return maxPopulationCapacity;
	}




	public void setMaxPopulationCapacity(int maxPopulationCapacity) {
		this.maxPopulationCapacity = maxPopulationCapacity;
	}




	public int getSize() {
		return size;
	}




	public void setSize(int size) {
		this.size = size;
	}




	@Override
	public String toString() {
		return "[roomNumber=" + roomNumber + ", dailyPrice=" + dailyPrice + ", floor=" + floor + ", avgDailyCost="
				+ avgDailyCost + ", roomGrade=" + roomGrade + ", maxPopulationCapacity=" + maxPopulationCapacity
				+ ", size=" + size + ", isBooked=" + isBooked ;
	}






	@Override
	public int hashCode() {
		return Objects.hash(avgDailyCost, dailyPrice, floor, isBooked, maxPopulationCapacity, roomGrade, roomNumber,
				size);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Double.doubleToLongBits(avgDailyCost) == Double.doubleToLongBits(other.avgDailyCost)
				&& Double.doubleToLongBits(dailyPrice) == Double.doubleToLongBits(other.dailyPrice)
				&& floor == other.floor && isBooked == other.isBooked
				&& maxPopulationCapacity == other.maxPopulationCapacity
				&& Double.doubleToLongBits(roomGrade) == Double.doubleToLongBits(other.roomGrade)
				&& Objects.equals(roomNumber, other.roomNumber) && size == other.size;
	}




	abstract public void describeSpecialProperties();




}
