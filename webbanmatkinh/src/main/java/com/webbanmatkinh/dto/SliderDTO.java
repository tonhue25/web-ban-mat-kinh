package com.webbanmatkinh.dto;

public class SliderDTO extends AbstractDTO<SliderDTO>{
	private String image;
	private String caption;
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
