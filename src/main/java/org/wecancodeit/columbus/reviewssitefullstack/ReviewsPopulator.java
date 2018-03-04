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

		reviewRepo.save(new Review(anime, "D.Gray-man", "./images/dman.jpg",
				"The Millenium Earl, a master of exploits while utilizing the souls of the dead trapped within Akuma plots the Destruction of the"
						+ " World. Under General Cross, the main protagonist Allen Walker uses his anti-Akuma weapon known as an innocence to fight against"
						+ " the Millenium Earls’ Akuma in order to release their souls and free them from their entrapment so they may live in peace once"
						+ " and for all. At the same time, Allen Walker along with his friends must all land together in order to prevent the Destruction"
						+ " of the World.",
				tag1, tag2, tag3, tag4, tag16, tag17));
		reviewRepo.save(new Review(anime, "Fairy Tail (2014)", "./images/fairy.jpg",
				"The #1 Wizard Guild isn’t only known for being Destructive but also known for their kindness and being humble towards the people. "
						+ "They love a good fight as they go all out destroying their enemies more than what they need to. Natsu Dragneel along with the Ice Making "
						+ "Wizard Gray Fullbuster have just devastated the Championship and as they draw nearer to victory. It is all abruptly ended by a "
						+ "Dark Wizard in the shadows. A Gate the brings Dragons from the past lay waste to the lands as these two young Wizards along with their "
						+ "Guild save the Kingdom from complete annihilation.",
				tag1, tag2, tag3, tag7, tag10, tag16));
		reviewRepo.save(new Review(anime, "Anime Three", "./images/", "Description3", tag1, tag2, tag3, tag5, tag7,
				tag10, tag11, tag16));
		reviewRepo.save(new Review(anime, "Anime Four", "./images/", "Description4", tag1, tag2, tag7, tag12));
		reviewRepo.save(new Review(anime, "Anime Five", "./images/", "Description5", tag1, tag2, tag7, tag8, tag10));
		reviewRepo.save(
				new Review(anime, "Anime Six", "./images/", "Description6", tag1, tag5, tag9, tag11, tag13, tag14));
		reviewRepo.save(new Review(anime, "Anime Seven", "./images/", "Description7", tag6, tag15, tag16));
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