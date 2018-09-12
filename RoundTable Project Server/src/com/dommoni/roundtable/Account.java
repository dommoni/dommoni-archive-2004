/*
 * Created on Mar 17, 2004
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
public class Account
{
   // system id
   private int id;
   
   // friendly name
   private String name;
   
   // nick name
   private String nickName;
   
   // login name
   private String username;
   
   // top-secret password
   private String password;
   
   // what type of account?
   private int accountType;
   
   // account profile - A blurb about the person (i.e. a bio).
   private String profile;
   
   // isActive - Weather or not this account has been deleted. 
   //Accounts should only be deleted if they arent referenced from anywhere else.
   private boolean isActive;
   
   public int getId()
   {
      return this.id;
   }
   
   public void setId(int _id)
   {
      this.id = _id;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public void setName(String _name)
   {
      this.name = _name;
   }
   
   public String getNickName()
   {
      return this.nickName;
   }
   
   public void setNickName(String _nickName)
   {
      this.nickName = _nickName;
   }
   
   public String getUsername()
   {
      return this.username;
   }
   
   public void setUsername(String _username)
   {
      this.username = _username;
   }
   
   public String getPassword()
   {
      return this.password;
   }
   
   public void setPassword(String _password)
   {
      this.password = _password;
   }
   
   public int getAccountType()
   {
      return this.accountType;
   }
   
   public void setAccountType(int _accountType)
   {
      this.accountType = _accountType;
   }
   
   public String getProfile()
   {
      return this.profile;
   }
   
   public void setProfile(String _profile)
   {
      this.profile = _profile;
   }
   
   public String toString()
   {
      if(name != null)
      {   
         return this.name; 
      } 
      else
      {   
         return super.toString(); 
      } 
   }
}
/*
 * 
 * $Log: Account.java,v $
 * Revision 1.2  2005/03/23 08:56:18  brian
 * Added footer.
 *
 * 
 */
