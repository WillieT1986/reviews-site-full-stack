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

	// @Resource
	// private TagRepository tagRepo;

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
		Category category = new Category("Category Name");
		categoryRepo.save(category);
		long categoryId = category.getId();

		Review first = new Review("foo", category);
		reviewRepo.save(first);

		Review second = new Review("bar", category);
		reviewRepo.save(second);

		entityManager.flush();
		entityManager.clear();

		category = categoryRepo.findOne(categoryId);
		assertThat(category.getReviews(), containsInAnyOrder(first, second));
	}
}
