package BookManagement;

public class Book {
	private String Id;
	private String Title;
	private String author;
	private String publishyear;
	private String status;
	
	public Book(String id, String title, String author, String publishyear, String status) {
		Id = id;
		Title = title;
		this.author = author;
		this.publishyear = publishyear;
		this.status = status;
	}


	public String getId() {
		return Id;
	}

	public String getTitle() {
		return Title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublishyear() {
		return publishyear;
	}

	public String getStatus() {
		return status;
	}

	public void setId(String id) {
		Id = id;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublishyear(String publishyear) {
		this.publishyear = publishyear;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Book [Id=" + Id + ", Title=" + Title + ", author=" + author + ", publishyear=" + publishyear
				+ ", status=" + status + "]";
	}
	
}
