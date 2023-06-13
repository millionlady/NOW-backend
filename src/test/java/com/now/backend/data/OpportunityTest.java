package com.now.backend.data;

import com.now.backend.models.OpportunityDto;
import com.now.backend.models.entities.Opportunity;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class OpportunityTest {
    private static Long id1 = 1L;
    private static String title1 = "App Developer";
    private static String description1 = "Design and develop the student volunteering app to make it user-friendly and easy to navigate.";
    private static String image1 = "https://buildfire.com/wp-content/uploads/2017/10/become-mobile-app-developer.jpg";

    public static Opportunity opportunity() {
        Opportunity opportunity = new Opportunity();
        opportunity.setId(id1);
        opportunity.setTitle(title1);
        opportunity.setDescription(description1);
        opportunity.setImage(image1);

        return opportunity;
    }

    public static OpportunityDto opportunityDto1() {
        return new OpportunityDto(id1, 1L, title1, description1, "", image1, new Date());
    }

    public static OpportunityDto opportunityDto2() {
        return new OpportunityDto(3L, 1L, "Content Creator", "Create engaging and informative content for the app, including blog posts, news articles, and social media updates.", "https://www.weidert.com/hubfs/content-creator-tips-feature-image.webp", "", new Date());
    }
}
