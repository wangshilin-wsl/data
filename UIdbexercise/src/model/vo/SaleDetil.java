package model.vo;

public class SaleDetil {
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBarcode() {
		return barcode;
	}
	public SaleDetil() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public SaleDetil(String id, String barcode, String product, float price, int totalnumber, String saleperson,
			String saletime) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.product = product;
		this.price = price;
		this.totalnumber = totalnumber;
		this.saleperson = saleperson;
		this.saletime = saletime;
		
	}
	public SaleDetil(String string, String string2, String string3, String valueOf, String valueOf2, String string4,
			String string5) {
		// TODO 自动生成的构造函数存根
		super();
		this.id = string;
		this.barcode = string2;
		this.product = string3;
		this.price = Float.valueOf(valueOf);
		this.totalnumber = Integer.valueOf(valueOf2);
		this.saleperson = string4;
		this.saletime = string5;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public float getPrice() {
		return price;
	}
	public float get() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getTotalnumber() {
		return  totalnumber;
	}
	public void setTotalnumber(int totalnumber) {
		this.totalnumber = totalnumber;
	}
	public String getSaleperson() {
		return saleperson;
	}
	public void setSaleperson(String saleperson) {
		this.saleperson = saleperson;
	}
	public String getSaletime() {
		return saletime;
	}
	public void setSaletime(String saletime) {
		this.saletime = saletime;
	}
	private String barcode;
	private String product;
	private float price;
	private int totalnumber;
	private String saleperson;
	private String saletime;
}
