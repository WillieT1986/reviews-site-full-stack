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

		Tag tag1 = new Tag("Action");
		tag1 = tagRepo.save(tag1);
		Tag tag2 = new Tag("Adventure");
		tag2 = tagRepo.save(tag2);
		Tag tag3 = new Tag("Comedy");
		tag3 = tagRepo.save(tag3);
		Tag tag4 = new Tag("Demons");
		tag4 = tagRepo.save(tag4);
		Tag tag5 = new Tag("Drama");
		tag5 = tagRepo.save(tag5);
		Tag tag6 = new Tag("Ecchi");
		tag6 = tagRepo.save(tag6);
		Tag tag7 = new Tag("Fantasy");
		tag7 = tagRepo.save(tag7);
		Tag tag8 = new Tag("Game");
		tag8 = tagRepo.save(tag8);
		Tag tag9 = new Tag("Historical");
		tag9 = tagRepo.save(tag9);
		Tag tag10 = new Tag("Magic");
		tag10 = tagRepo.save(tag10);
		Tag tag11 = new Tag("Martial Arts");
		tag11 = tagRepo.save(tag11);
		Tag tag12 = new Tag("Military");
		tag12 = tagRepo.save(tag12);
		Tag tag13 = new Tag("Romance");
		tag13 = tagRepo.save(tag13);
		Tag tag14 = new Tag("Samurai");
		tag14 = tagRepo.save(tag14);
		Tag tag13 = new Tag("School");
		tag13 = tagRepo.save(tag13);
		Tag tag14 = new Tag("Shounen");
		tag14 = tagRepo.save(tag14);
		Tag tag15 = new Tag("Super Powers");
		tag15 = tagRepo.save(tag15);

		Review review = reviewRepo.save(new Review("Java One", "imageUrl", "Description", tag1, tag2));

		categoryRepo.save(new Category("Head First Java", review));
		categoryRepo.save(new Category("Head First Design Patterns", review));
	}

}
