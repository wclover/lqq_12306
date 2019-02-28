package my12306;

public class trainInfo {
	private String checi;
	private String date;
	private String start;
	private String stat_time;
//	private String take;
	private String arrive;
	private String arrive_time;
	private String type;
	private String yideng;
	private String erdeng;
	private String wuzuo;
	private String price;
	public trainInfo(String checi, String date, String start, String stat_time, String arrive, String arrive_time,
			String type, String yideng, String erdeng, String wuzuo, String price) {
		super();
		this.checi = checi;
		this.date = date;
		this.start = start;
		this.stat_time = stat_time;
//		this.take = take;
		this.arrive = arrive;
		this.arrive_time = arrive_time;
		this.type = type;
		this.yideng = yideng;
		this.erdeng = erdeng;
		this.wuzuo = wuzuo;
		this.price = price;
	}

	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDate()
	{
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public trainInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCheci() {
		return checi;
	}
	public void setCheci(String checi) {
		this.checi = checi;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getStat_time() {
		return stat_time;
	}
	public void setStat_time(String stat_time) {
		this.stat_time = stat_time;
	}
//	public String getTake() {
//		return take;
//	}
//	public void setTake(String take) {
//		this.take = take;
//	}
	public String getArrive() {
		return arrive;
	}
	public void setArrive(String arrive) {
		this.arrive = arrive;
	}
	public String getArrive_time() {
		return arrive_time;
	}
	public void setArrive_time(String arrive_time) {
		this.arrive_time = arrive_time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getYideng() {
		return yideng;
	}
	public void setYideng(String yideng) {
		this.yideng = yideng;
	}
	public String getErdeng() {
		return erdeng;
	}
	public void setErdeng(String erdeng) {
		this.erdeng = erdeng;
	}
	public String getWuzuo() {
		return wuzuo;
	}
	public void setWuzuo(String wuzuo) {
		this.wuzuo = wuzuo;
	}


	@Override
	public String toString() {
		return "trainInfo [checi=" + checi + ", date=" + date + ", start=" + start
				+ ", stat_time=" + stat_time + ", arrive=" + arrive + ", arrive_time=" + arrive_time + ", type=" + type
				+ ", yideng=" + yideng + ", erdeng=" + erdeng + ", wuzuo=" + wuzuo + ", price=" + price + "]";
	}
	
}
