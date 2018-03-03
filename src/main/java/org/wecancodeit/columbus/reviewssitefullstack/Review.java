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

	@ManyToMany
	private Collection<Tag> tags;
	private String title;
	private String description;
	private String imageUrl;

	public Review() {
	}

	public Review(Category category, String title, String imageUrl, String description, Tag... tags) {
		this.category = category;
		this.title = title;
		this.imageUrl = imageUrl;
		this.description = description;
		this.tags = new HashSet<>(asList(tags));
	}

	// public Review(Category category, String title) {
	// this.category = category;
	// this.title = title;
	// }

	public Collection<Tag> getTags() {
		return tags;
	}

	public String getTitle() {
		return title;
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

	public String getDescription() {
		return description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

}
