package org.wecancodeit.columbus.reviewssitefullstack;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JpaMappingTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private TagRepository tagRepo;

	@Test
	public void shouldSaveAndLoadReview() {
		Review review = new Review("Review Name");
		review = reviewRepo.save(review);
		long reviewId = review.getId();

		entityManager.flush();
		entityManager.clear();

		review = reviewRepo.findOne(reviewId);
		assertThat(review.getName(), is("Review Name"));
	}

	@Test
	public void shouldSaveReviewToCategoryRelationship() {
		Category category = new Category("Category Name", null);
		categoryRepo.save(category);
		long categoryId = category.getId();

		Review first = new Review("foo", category);
		first = reviewRepo.save(first);

		Review second = new Review("bar", category);
		second = reviewRepo.save(second);

		entityManager.flush();
		entityManager.clear();

		category = categoryRepo.findOne(categoryId);
		assertThat(category.getReviews(), containsInAnyOrder(first, second));
	}

	@Test
	public void shouldSaveAndLoadTag() {
		Tag tag = tagRepo.save(new Tag("Tag Name"));
		long tagId = tag.getId();

		entityManager.flush();
		entityManager.clear();

		tag = tagRepo.findOne(tagId);
		assertThat(tag.getName(), is("Tag Name"));
	}

	@Test
	public void shouldEstablishReviewToTagRelationships() {
		Tag java = tagRepo.save(new Tag("Java"));
		Tag ruby = tagRepo.save(new Tag("Ruby"));

		Review review = new Review("Review Name", java, ruby);
		review = reviewRepo.save(review);
		long reviewName = review.getId();

		review = reviewRepo.findOne(reviewName);
		assertThat(review.getTags(), containsInAnyOrder(java, ruby));
	}

	@Test
	public void shouldEstablishTagToReviewsRelationship() {
		Tag tag = tagRepo.save(new Tag("Ruby"));
		long tagId = tag.getId();

		Review reviewNameOne = new Review("reviewNameOne", tag);
		reviewNameOne = reviewRepo.save(reviewNameOne);

		Review reviewNameTwo = new Review("reviewNameTwo", tag);
		reviewNameTwo = reviewRepo.save(reviewNameTwo);

		entityManager.flush();
		entityManager.clear();

		tag = tagRepo.findOne(tagId);
		assertThat(tag.getReviews(), containsInAnyOrder(reviewNameOne, reviewNameTwo));
	}

}
