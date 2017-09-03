package com.adelacebal.fullstackappangularspringboot.model.response;

public class ReservationResponse {
	
	private Long id;
	private Integer roomNumber;
	private Integer price;
	private Links link;
	
	
	public ReservationResponse() {
		super();
	}

	public ReservationResponse(Integer roomNumber, Integer price) {
		super();
		this.roomNumber = roomNumber;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Links getLink() {
		return link;
	}
	public void setLink(Links link) {
		this.link = link;
	}
	
	
	
}
