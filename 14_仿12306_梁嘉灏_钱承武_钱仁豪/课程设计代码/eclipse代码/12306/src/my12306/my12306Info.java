package my12306;

public class my12306Info {
	private String username;
	private String name;
	private String time;
	private String start;
	private String arrive;
	private String start_time;
	private String arrive_time;
	private String price;
	private String type;
	
	public my12306Info(String username, String name, String time, String start, String arrive, String start_time, String arrive_time,
			String price, String type) {
		super();
		this.username = username;
		this.name = name;
		this.time = time;
		this.start = start;
		this.arrive = arrive;
		this.start_time = start_time;
		this.arrive_time = arrive_time;
		this.price = price;
		this.type = type;
	}
	
	

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public my12306Info()
	{
		
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getArrive() {
		return arrive;
	}

	public void setArrive(String arrive) {
		this.arrive = arrive;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getArrive_time() {
		return arrive_time;
	}

	public void setArrive_time(String arrive_time) {
		this.arrive_time = arrive_time;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "my12306Info [username=" + username + ", name=" + name + ", time=" + time + ", start=" + start
				+ ", arrive=" + arrive + ", start_time=" + start_time + ", arrive_time=" + arrive_time + ", price="
				+ price + ", type=" + type + "]";
	}

	
}
