package com.intern.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchAccountReq {
	
	// region -- Fields --

	@JsonProperty("owner")
	private String owner;
	@JsonProperty("name")
	private String name;

	// end

	// region -- Get set --

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// end

	// region -- Methods --

	public SearchAccountReq() {
		super();
	}

	// end
}
