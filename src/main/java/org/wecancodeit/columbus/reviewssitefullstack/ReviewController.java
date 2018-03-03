package org.wecancodeit.columbus.reviewssitefullstack;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller
public class ReviewController {

	@Resource
	ReviewRepository reviewRepo = new ReviewRepository();
}
