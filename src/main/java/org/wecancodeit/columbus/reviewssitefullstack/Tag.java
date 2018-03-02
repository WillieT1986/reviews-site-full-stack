package org.wecancodeit.columbus.reviewssitefullstack;

import javax.persistence.Entity;

@Entity
public class Tag {

	private String name;

	public Tag() {
	}

	public Tag(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
