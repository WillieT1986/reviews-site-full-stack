package org.wecancodeit.columbus.reviewssitefullstack;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewsPopulator implements CommandLineRunner {

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception {

		Tag java = new Tag("Java");
		java = tagRepo.save(java);
		Tag tdd = new Tag("TDD");
		java = tagRepo.save(tdd);

		Review review = reviewRepo.save(new Review("Java One", "Description", java, tdd));

		categoryRepo.save(new Category("Head First Java", review));
		categoryRepo.save(new Category("Head First Design Patterns", review));
	}

}
