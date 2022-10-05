/*
Target Class
============

Objective:
To inject dependent class (java.time.LocalDateTime) instance without Spring Framework
(i.e., using HAS-A property)

 */

package com.nt;
import java.time.LocalDateTime;

public class WishMessageGenerator
{
    // Has-A property, i.e., instance created
    private LocalDateTime ldt;

    public LocalDateTime getLdt()
    {
        return ldt;
    }

    public void setLdt(LocalDateTime ldt)
    {
        System.out.println("WishMessageGenerator.setLdt called");
        this.ldt = ldt;
    }

    public String generateWishMessage(String userName)
    {
        System.out.println("WishMessageGenerator.generateWishMessage() called");
        int hour = ldt.getHour();
        if(hour<12)
            return "Good morning:: "+ userName;
        else if(hour<16)
            return "Good afternoon:: "+ userName;
        else if(hour<20)
            return "Good evening:: "+ userName;
        else
            return "Good night:: "+ userName;
    }
}
