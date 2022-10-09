package com.nt.test;
import com.nt.WishMessageGenerator;
import java.time.LocalDateTime;

public class DependencyManagementTest
{
    public static void main(String[] args)
    {
        LocalDateTime sysDateTime = LocalDateTime.now();
        WishMessageGenerator timeWish = new WishMessageGenerator();
        timeWish.setLdt(sysDateTime);
        System.out.println(timeWish.generateWishMessage("Gaurav"));
    }
}
