package com.webbanmatkinh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "slider")
public class SliderEntity extends BaseEntity{
	@Column(name = "image" , columnDefinition = "NVARCHAR(50) NOT NULL")
	private String image;
	
	@Column(name = "caption" , columnDefinition = "NVARCHAR(300) NOT NULL")
	private String caption;
	
	@Column(name = "content" , columnDefinition = "NVARCHAR(500) NOT NULL")
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
