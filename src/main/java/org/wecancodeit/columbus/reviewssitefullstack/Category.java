package org.wecancodeit.columbus.reviewssitefullstack;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private long id;

	@OneToMany(mappedBy = "category")
	private Collection<Review> reviews;
	private String name;

	public Category() {
	}

	public Category(String name, Review reviews) {
		this.name = name;
		this.reviews = new HashSet<>(asList(reviews));
	}

	public Collection<Review> getReviews() {
		return reviews;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Category) obj).id;
	}

}
