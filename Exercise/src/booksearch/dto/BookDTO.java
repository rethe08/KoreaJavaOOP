package booksearch.dto;

public class BookDTO {
	
	//DTO의 목적 - 이 프로그램에서 단위로 사용할 instance(여기선 책 한권에 대한 data)
	//DTO를 만들때에는 DB Table 명세표를 보고 만든다.
	
	private String bisbn;
	private String btitle;
	//private String bdate;
	//private String bpage;
	//private String bprice;
	private String bauthor;
	
	public BookDTO() {
		// TODO Auto-generated constructor stub
	}

	
	
	public String getBisbn() {
		return bisbn;
	}



	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}



	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	
	

}
