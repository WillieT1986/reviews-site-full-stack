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

	public Review() {

	}

	public Review(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	// @Override
	// public int hashCode() {
	// return ((Long) id).hashCode();
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj) {
	// return true;
	// }
	// if (obj == null || getClass() != obj.getClass()) {
	// return false;
	// }
	// return id == ((Review) obj).id;
	// }

}
