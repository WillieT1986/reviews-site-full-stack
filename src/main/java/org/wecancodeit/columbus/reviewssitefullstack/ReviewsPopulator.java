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

		Tag tag1 = new Tag("Java");
		tag1 = tagRepo.save(tag1);
		Tag tag2 = new Tag("TDD");
		tag1 = tagRepo.save(tag2);

		Review review = reviewRepo.save(new Review("Java One", "imageUrl", "Description", tag1, tag2));

		categoryRepo.save(new Category("Head First Java", review));
		categoryRepo.save(new Category("Head First Design Patterns", review));
	}

}
