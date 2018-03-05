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
		Category anime = createCategory("Anime Reviews");

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

		reviewRepo.save(new Review(anime, "Fullmetal Alchemist: Brotherhood", "./images/fullmetal.jpg",
				"The Law of Equivalent Exchange: \"In order for something to be obtained, something of equal value must be lost.\" This is law for Alchemist that "
						+ "two Brothers by the names of Edward and Alphonse Elric ignored while trying to bring their Mother back to life. The younger Brother lost his physical"
						+ " body while his old Brother lost his arm saving his brother’s life by placing his spiritual form within a suit of armor. They travel around seeking"
						+ " the philosopher's stone while at the same time unraveling their Countries darkest secrets. Between the search for a serial killer and time, the two"
						+ " brother’s hold onto doubt on whether or not they can fully become human again.",
				tag1, tag2, tag3, tag5, tag7, tag10, tag11, tag16));

		reviewRepo.save(new Review(anime, "Gate: Jieitai Kanochi nite, Kaku Tatakaeri", "./images/gate.jpg",
				"Youji Itami, an Otaku who’s an Office in the JSDF is traveling through Ginza and enroute to a doujin  convention when suddenly a portal leading to another world"
						+ " opens up. With hundreds, if not thousands if medieval troops clad in armor come rushing through to invade Earth. Three months go by and Youji along with a"
						+ " special team is being tasked with exploring the otherside of the Gate to make peace and to learn the ways of the otherside where he comes across a young mage,"
						+ " demi-goddess, an elf and a princess to the other Kingdom. If failure, there will surely be more blood spilled.",
				tag1, tag2, tag7, tag12));

		reviewRepo.save(new Review(anime, "Log Horizon", "./images/log.jpg",
				"Gamers, 30,000 to be more precise are somehow mysteriously trapped within a game called Elder Tails. They cannot die as they’re revived but at what cost? "
						+ "A popular strategist within the game but an anti social in the real world, Shiroe does what he can to maintain order while trying to discover exactly what happened to"
						+ " how not only himself but those trapped with him on how to escape back to the real world. Will Shiroe be able to do it or is there more to it and a reason for"
						+ " these brave adventurers being trapped within Elder Tails?",
				tag1, tag2, tag7, tag8, tag10));

		reviewRepo.save(new Review(anime, "Rurouni Kenshin: Meiji Kenkaku Romantan - Tsuioku-hen",
				"./images/samuraix.jpg",
				"The world is a cruel place. During a brutal war in Japan. It is survival of the fittest. Shinta, a young boy who watched his care takes get slain right before his eyes watch"
						+ " defenselessly as he is capable of doing nothing. At the moment of his own surprise his attackers are cut down and he is saved by a Master Swordsmen. Shinta is now named Kenshin"
						+ " Himura who becomes one of the most deadliest assassins of his time earning him the nickname 'Hitokiri Battousai.' Locked between justice and corruption, Kenshin must find "
						+ "a way to shoulder the weight as the Nation rest falls to him. ",
				tag1, tag5, tag9, tag11, tag13, tag14));

		reviewRepo.save(new Review(anime, "Shokugeki no Souma", "./images/foodwars.jpg",
				"Trained since birth along with being raised in a Diner, Souma Yukihira, is suddenly told by his Father that he will be attending an Elite School that shapes and molds students to be"
						+ " the best Chefs in the world. Through this vigorous training school. As a transfer student, he declares that he will be the top student that paints a target on his back."
						+ " Shokugeki, that is what is used to prove his is better and at this Elite School. Is the only way to move to the top. Yukihira faces many obstacles as he shoots for the top while"
						+ " those who revere his Father are unaware that Yukihira is his son while his son has no idea how famous his Father truly is. ",
				tag6, tag15, tag16));
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