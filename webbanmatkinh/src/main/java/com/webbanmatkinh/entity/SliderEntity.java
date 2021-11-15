package com.webbanmatkinh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "slider")
public class SliderEntity extends BaseEntity{
	@Column(name = "image")
	private String image;
	
	@Column(name = "caption")
	private String caption;
	
	@Column(name = "content")
	private String content;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
