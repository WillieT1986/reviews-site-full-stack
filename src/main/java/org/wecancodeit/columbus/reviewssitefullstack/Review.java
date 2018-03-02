package org.wecancodeit.columbus.reviewssitefullstack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	public Review(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
