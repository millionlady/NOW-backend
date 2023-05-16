package com.now.backend.data;

import com.now.backend.models.MyWorksDto;
import com.now.backend.models.entities.MyWorks;
public class MyWorksTest {
    private static String opportunity1 = "Desing1";
    private static String organization1 = "MOP";
    private static String dateCreated1 = "03.01.2023";
    private static int pts1 = 50;
    private static String status1 = "APPROVED";


    public static MyWorks myWorks() {
        MyWorks myWork = new MyWorks();
        myWork.setOpportunity(opportunity1);
        myWork.setOrganization(organization1);
        myWork.setDateCreated(dateCreated1);
        myWork.setPts(pts1);
        myWork.setStatus(status1);

        return myWork;
    }

    public static MyWorksDto myWorksDto() {
        return new MyWorksDto(opportunity1, organization1, dateCreated1, pts1, status1);
    }

    public static MyWorksDto myWorksDto2() {
        return new MyWorksDto("Desing2", "MOP", "03.01.2023", 50, "APPROVED");
    }
}
