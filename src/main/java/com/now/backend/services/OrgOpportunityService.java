package com.now.backend.services;

import com.now.backend.models.Opportunity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrgOpportunityService {

    public Opportunity createOpportunity(Opportunity opportunity) {
        opportunity.setId(5);
        opportunity.setTitle("Marketing Specialist");
        opportunity.setDescription("Develop marketing campaigns to promote the app to the student community, such as through social media, email marketing, and event sponsorships.");
        opportunity.setImage("https://img.freepik.com/premium-vector/marketing-specialist-typographic-header-advertising-marketing-concept-business-strategy-communucation-with-customer-isolated-flat-vector-illustration_613284-2135.jpg?w=2000");
        return opportunity;
    }
    public List<Opportunity> getOpportunity() {
        List<Opportunity> opportunityList = new ArrayList<>();
        Opportunity appDeveloper = new Opportunity(1, "App Developer", "Design and develop the student volunteering app to make it user-friendly and easy to navigate.", "https://buildfire.com/wp-content/uploads/2017/10/become-mobile-app-developer.jpg");
        opportunityList.add(appDeveloper);
        Opportunity contentCreator = new Opportunity(2, "Content Creator", "Create engaging and informative content for the app, including blog posts, news articles, and social media updates.", "https://www.weidert.com/hubfs/content-creator-tips-feature-image.webp");
        opportunityList.add(contentCreator);

        return opportunityList;
    }

    public Opportunity getOpportunityId(int id) {
        return new Opportunity(id, "App Developer", "Design and develop the student volunteering app to make it user-friendly and easy to navigate.", "https://buildfire.com/wp-content/uploads/2017/10/become-mobile-app-developer.jpg");
    }
}
