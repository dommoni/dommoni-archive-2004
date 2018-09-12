/*
 * Created on May 1, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AccountContact
{
   // account contact types.
   public static final int EMAIL = 0x01;
   
   private int accountId;
   //private String imAddress;
   private String phoneNumber;
   private String officeAddress;
   private String city;
   private String state;
   private String zip;
   
   public int getAccountId()
   {
      return this.accountId;
   }
   
   public void setAccountId(int accountId)
   {
      this.accountId = accountId;
   }
   
   /*public String getImAddress()
   {
      return this.imAddress;
   }
   
   public void setImAddress(String imAddress)
   {
      this.imAddress = imAddress;
   }*/
   
   public String getPhoneNumber()
   {
      return this.phoneNumber;
   }
   
   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }
   
   public String getOfficeAddress()
   {
      return this.officeAddress;
   }
   
   public void setOfficeAddress(String officeAddress)
   {
      this.officeAddress = officeAddress;
   }
   
   public String getCity()
   {
      return this.city;
   }
   
   public void setCity(String city)
   {
      this.city = city;
   }
   
   public String getState()
   {
      return this.state;
   }
   
   public void setState(String state)
   {
      this.state = state;
   }
   
   public String getZip()
   {
      return this.zip;
   }
   
   public void setZip(String zip)
   {
      this.zip = zip;
   }
}
/*
 * 
 * $Log: AccountContact.java,v $
 * Revision 1.2  2005/03/23 08:56:28  brian
 * Added footer.
 *
 * 
 */