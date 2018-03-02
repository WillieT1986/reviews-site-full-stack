package org.wecancodeit.columbus.reviewssitefullstack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private long id;
	private Review review;
	private String name;

	public Category() {

	}

	public Category(String name, Review review) {
		this.name = name;
		this.review = review;
	}

	public long getId() {
		return id;
	}

	public Review review() {
		return review;
	}

}
