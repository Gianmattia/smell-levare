package logic.bean;

public class PlaceBean {

	protected String name;
	private int capacity;
	protected String address;
	private String free; //free is used to get who has booked this place
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String isFree() {
		return free;
	}
	public void setFree(String free) {
		this.free = free;
	}
}
