/*
 * Created on Aug 6, 2004
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
public class AccountProfile
{
   private int accountId;
   
   // Misc Information
   private String profileText;
   private byte image[];
   
   // Contact information
   public String mailingAddress;
   public String city;
   public String state;
   public String zip;
   
   public String homePhoneNumber;
   public String workPhoneNumber;
   public String mobilePhoneNumber;
   public String faxNumber;
   public String emailAddress;
   
   public int getAccountId()
   {
      return this.accountId;
   }
   
   public void setAccountId(int _accountId)
   {
      this.accountId = _accountId;
   }
   
   public String getProfileText()
   {
      return this.profileText;
   }
   
   public void setProfileText(String _profileText)
   {
      this.profileText = _profileText;
   }
   
   public byte[] getImage()
   {
      return this.image;
   }
   
   public void setImage(byte[] _image)
   {
      this.image = _image;
   }
   
   public String getMailingAddress()
   {
      return this.mailingAddress;
   }
   
   public void setMailingAddress(String _mailingAddress)
   {
      this.mailingAddress = _mailingAddress;
   }
   
   public String getCity()
   {
      return this.city;
   }
   
   public void setCity(String _city)
   {
      this.city = _city;
   }
   
   public String getState()
   {
      return this.state;
   }
   
   public void setState(String _state)
   {
      this.state = _state;
   }
   
   public String getZip()
   {
      return this.zip;
   }
   
   public void setZip(String _zip)
   {
      this.zip = _zip;
   }
   
   public String getHomePhoneNumber()
   {
      return this.homePhoneNumber;
   }
   
   public void setHomePhoneNumber(String _homePhoneNumber)
   {
      this.homePhoneNumber = _homePhoneNumber;
   }
   
   public String getWorkPhoneNumber()
   {
      return workPhoneNumber;
   }
   
   public void setWorkPhoneNumber(String _workPhoneNumber)
   {
      this.workPhoneNumber = _workPhoneNumber;
   }
   
   public String getMobilePhoneNumber()
   {
      return mobilePhoneNumber;
   }
   
   public void setMobilePhoneNumber(String _mobilePhoneNumber)
   {
      this.mobilePhoneNumber = _mobilePhoneNumber;
   }
   
   public String getFaxNumber()
   {
      return this.faxNumber;
   }
   
   public void setFaxNumber(String _faxNumber)
   {
      this.faxNumber = _faxNumber;
   }
   
   public String getEmailAddress()
   {
      return this.emailAddress;
   }
   
   public void setEmailAddress(String _emailAddress)
   {
      this.emailAddress = _emailAddress;
   }
}
/*
 * 
 * $Log: AccountProfile.java,v $
 * Revision 1.2  2005/03/23 08:56:40  brian
 * Added footer.
 *
 * 
 */