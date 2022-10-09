/*
Target Class
============

Objective:
To inject dependent class (java.time.LocalDateTime) instance without Spring Framework
(i.e., using HAS-A property) to the target class (com.nt.sbeans.WishMessageGenerator).

 */

package com.nt.sbeans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("wmg")
public class WishMessageGenerator
{
    private LocalDateTime ldt;

    public LocalDateTime getLdt()
    {
        return ldt;
    }

    @Autowired
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
