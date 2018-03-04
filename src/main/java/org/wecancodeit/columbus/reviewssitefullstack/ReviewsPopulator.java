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
		Category anime = createCategory("Anime");

		Tag tag1 = createTag("Action");
		Tag tag2 = createTag("Adventure");
		Tag tag3 = createTag("Comedy");
		Tag tag4 = createTag("Demons");
		Tag tag5 = createTag("Drama");
		Tag tag6 = createTag("Ecchi");
		Tag tag7 = createTag("Fantasy");
		Tag tag8 = createTag("Game");
		Tag tag9 = createTag("Historical");
		Tag tag10 = createTag("Magic");
		Tag tag11 = createTag("Martial Arts");
		Tag tag12 = createTag("Military");
		Tag tag13 = createTag("Romance");
		Tag tag14 = createTag("Samurai");
		Tag tag15 = createTag("School");
		Tag tag16 = createTag("Shounen");
		Tag tag17 = createTag("Super Powers");

		reviewRepo.save(
				new Review(anime, "D.Gray-man", "imageUrl", "Description1", tag1, tag2, tag3, tag4, tag16, tag17));
		reviewRepo
				.save(new Review(anime, "Anime Two", "imageUrl", "Description2", tag1, tag2, tag3, tag7, tag10, tag16));
		reviewRepo.save(new Review(anime, "Anime Three", "imageUrl", "Description3", tag1, tag2, tag3, tag5, tag7,
				tag10, tag11, tag16));
		reviewRepo.save(new Review(anime, "Anime Four", "imageUrl", "Description4", tag1, tag2, tag7, tag12));
		reviewRepo.save(new Review(anime, "Anime Five", "imageUrl", "Description5", tag1, tag2, tag7, tag8, tag10));
		reviewRepo.save(
				new Review(anime, "Anime Six", "imageUrl", "Description6", tag1, tag5, tag9, tag11, tag13, tag14));
		reviewRepo.save(new Review(anime, "Anime Seven", "imageUrl", "Description7", tag6, tag15, tag16));
	}

	private Tag createTag(String name) {
		Tag t = new Tag(name);
		return tagRepo.save(t);
	}

	private Category createCategory(String catName) {
		Category c = new Category(catName);
		return categoryRepo.save(c);
	}
}