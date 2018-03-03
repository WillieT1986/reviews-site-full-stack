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

		// Default Tags for current Anime listed in this review. Is there a better way
		// for this???
		Tag tag1 = tagRepo.save(new Tag("Action"));

		Tag tag2 = createTag("Adventure");

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

		Tag tag15 = new Tag("School");
		tag15 = tagRepo.save(tag15);

		Tag tag16 = new Tag("Shounen");
		tag16 = tagRepo.save(tag16);

		Tag tag17 = new Tag("Super Powers");
		tag17 = tagRepo.save(tag17);

		// How to remove the yellow lines from review and anime???
		reviewRepo.save(new Review("Anime One", "imageUrl", "Description", tag1, tag2));

		categoryRepo.save(new Category("Anime", "Description of Anime Goes Here..."));
	}

	private Tag createTag(String name) {
		Tag t = new Tag(name);
		return tagRepo.save(t);
	}
}