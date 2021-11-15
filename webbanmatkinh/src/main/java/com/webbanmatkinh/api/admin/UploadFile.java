package com.webbanmatkinh.api.admin;

import org.springframework.stereotype.Component;

@Component
public class UploadFile {
	private String basePath;

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
}
