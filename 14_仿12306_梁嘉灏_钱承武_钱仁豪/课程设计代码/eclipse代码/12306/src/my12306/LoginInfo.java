package my12306;

public class LoginInfo {
	private String zhanghao;
	private String mima;
	public String getZhanghao() {
		return zhanghao;
	}
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	public String getMima() {
		return mima;
	}
	public void setMima(String mima) {
		this.mima = mima;
	}
	@Override
	public String toString() {
		return "LoginInfo [zhanghao=" + zhanghao + ", mima=" + mima + "]";
	}
	public LoginInfo(String zhanghao, String mima) {
		super();
		this.zhanghao = zhanghao;
		this.mima = mima;
	}
	

}
