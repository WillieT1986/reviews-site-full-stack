package org.wecancodeit.columbus.reviewssitefullstack;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private Category category;
	private String name;

	@ManyToMany
	private Collection<Tag> tags;

	public Review() {
	}

	public Review(String name, Tag... tags) {
		this.name = name;
		this.tags = new HashSet<>(asList(tags));
	}

	public Review(String name, Category category) {
		this.name = name;
		this.category = category;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
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
		return id == ((Review) obj).id;
	}

}
