package com.webbanmatkinh.dto;

public class BillDTO extends AbstractDTO<BillDTO> {
	private Long userId;
	// tong tien = sub + tax + shipping
	private double total;
	
	private double subtotal;
	private double tax;
	private double shipping;
	
	public BillDTO() {
		super();
	}

	public BillDTO(Long userId, double total, double subtotal, double tax,
			double shipping) {
		super();
		this.userId = userId;
		this.total = total;	
		this.subtotal = subtotal;
		this.tax = tax;
		this.shipping = shipping;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public double getTotal() {
		// total = subtotal + tax + shipping.
		return tax + shipping + subtotal;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getShipping() {
		return shipping;
	}

	public void setShipping(double shipping) {
		this.shipping = shipping;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}
