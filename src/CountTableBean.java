

import java.util.Map;


public class CountTableBean {
	private String time;
	private int allNum;
	private int newUid;
	private int newPid;
	private int login;
	private float avgACU;
	private int maxPCU;
	private float avgTime;
	private double money;
	private int payPeople;
	private int newPlayPay;
	private double allMoney;
	private int allPayPeople;
	private int fristPay;
	private String sid;
	public static CountTalbeBuilder ctb;
	private CountTableBean(CountTalbeBuilder builder){
		this.time=builder.time;
		this.allNum=builder.allNum;
		this.newUid=builder.newUid;
		this.newPid=builder.newPid;
		this.login=builder.login;
		this.avgACU=builder.avgACU;
		this.maxPCU=builder.maxPCU;
		this.avgTime=builder.avgTime;
		this.money=builder.money;
		this.payPeople=builder.payPeople;
		this.newPlayPay=builder.newPlayPay;
		this.allMoney=builder.allMoney;
		this.allPayPeople=builder.allPayPeople;
		this.fristPay=builder.fristPay;
		this.sid=builder.sid;
	}

	
	public String getTime() {
		return time;
	}
	public String getArppu(){
		try{
			return String.format("%.2f",this.money/this.payPeople);
		}catch (Exception e) {
			return "";
		}
	}
	public String getArppuAll(){
		try{
			return String.format("%.2f",this.allMoney/this.allPayPeople);
		}catch (Exception e) {
			return "";
		}
	}
	public String getArpu(){
		try{
			return String.format("%.2f",this.allMoney/this.allNum);
		}catch (Exception e) {
			return "";
		}
	}
	public String getPermeate(){
		try{
			return String.format("%.2f",(double)this.payPeople/(double)this.login);
		}catch (Exception e) {
			return "";
		}
	}
	public String getConvert(){
		try{
			return String.format("%.2f",(double)this.newPlayPay/(double)this.newPid);
		}catch (Exception e) {
			return "";
		}
	}
	public String getConvertAll(){
		try{
			return String.format("%.2f",(double)this.allPayPeople/(double)this.allNum);
		}catch (Exception e) {
			return "";
		}
	}
	public int getNewPid() {
		return newPid;
	}
	public int getAllNum() {
		return allNum;
	}
	public int getNewUid() {
		return newUid;
	}
	public int getLogin() {
		return login;
	}

	public String getAvgACU() {
		return String.format("%.2f",avgACU);
	}
	public int getMaxPCU() {
		return maxPCU;
	}
	public String getAvgTime() {
		return String.format("%.2f",avgTime);
	}

	public double getMoney() {
		return money;
	}
	public int getPayPeople() {
		return payPeople;
	}
	public int getNewPlayPay() {
		return newPlayPay;
	}
	public int getAllPayPeople() {
		return allPayPeople;
	}
	public int getFristPay() {
		return fristPay;
	}
	public double getAllMoney() {
		return allMoney;
	}
	public String getSid() {
		return sid;
	}
	public static class CountTalbeBuilder{
		private String time;
		private int allNum;
		private int newUid;
		private int newPid;
		private int login;
		private float avgACU;
		private int maxPCU;
		private float avgTime;
		private double money;
		private int payPeople;
		private int newPlayPay;
		private double allMoney;
		private int allPayPeople;
		private int fristPay;
		private String sid;
		
		public CountTalbeBuilder(String time,String sid){
			this.time=time;
			this.sid=sid;
		}
		public CountTalbeBuilder firstInitForDB(Map<String,Object> map){
			this.allNum=Integer.parseInt(map.get("allNum")!=null?map.get("allNum").toString():"0");
			this.allMoney=Double.parseDouble(map.get("allMoney")!=null?map.get("allMoney").toString():"0.0");
			this.allPayPeople=Integer.parseInt(map.get("allPayPeople")!=null?map.get("allPayPeople").toString():"0");
			return this;
		}
		public CountTalbeBuilder setMassageForPayAndCreate(Map<String,Number> map){
			if(map!=null){			
				this.newPid = map.get("create").intValue();
				this.money =map.get("czMoney").doubleValue();
				this.payPeople=map.get("czNum").intValue();
				this.fristPay=map.get("scNum").intValue();
				this.newPlayPay=map.get("newCz").intValue();
				this.newUid = this.newPid;
			}
			return this;
		}
		public CountTalbeBuilder setLogin(Number login) {
			if(login!=null)
				this.login = login.intValue();
			return this;
		}
		
		public CountTalbeBuilder setCU(Number[] cu) {
			if(cu!=null){
				this.avgACU = cu[0].floatValue();
				this.maxPCU = cu[1].intValue();
			}
			return this;
		}
		public CountTalbeBuilder setAvgTime(Number avgTime) {
			if(avgTime!=null)
				this.avgTime = avgTime.floatValue();
			return this;
		}	
		public CountTableBean build(){
			return new CountTableBean(this);
		}
	}
}
