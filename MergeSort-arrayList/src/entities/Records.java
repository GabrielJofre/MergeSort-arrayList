package entities;

public class Records {
	private Integer rg;
	private String name;
	private String data;

	public Records(Integer rg, String name, String data) {
		this.rg = rg;
		this.name = name;
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getRg() {
		return rg;
	}

	public String toString() {
		return rg + ", " + name + ", " + data;
	}

}
