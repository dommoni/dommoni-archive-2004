/*
 * Created on Feb 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.licensing;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.CRC32;

import com.dommoni.roundtable.projectServer.utils.DebugUtils;
import com.dommoni.roundtable.projectServer.utils.PrintUtils;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class LicenseFileReader
{
   // TODO: MAKE THIS NATIVE CODE!!!
   private final static int MODE_PRODUCT = 100;
   private final static int MODE_TRIAL = 125;
   
   private License license = null;
   private long crc = -1;
   
   public LicenseFileReader()
   {  
      int posID = 200;
      int posCompany = 400;
      int posContact = 800;
      int posUsers = 1200;
      int posMode = 1600;
      int posStartDay = 2000;
      int posDays = 3200;
      
      try
      {
         license = new License();
         
         File licenseDir = new File("license");
         File licenseFile = null;
         File[] files = licenseDir.listFiles();
         
         licenseFile = files[0];
         PrintUtils.println("LicenseFileReader - Loading File: " + licenseFile.getAbsolutePath() +"\\"+licenseFile.getName());
         FileInputStream fis = new FileInputStream(licenseFile);
         byte[] fbuf = new byte[(int)licenseFile.length()];
         fis.read(fbuf);
         
         CRC32 crc32 = new CRC32();
         crc32.update(fbuf);
         crc = crc32.getValue();
         license.setFileCRC(crc);
         
         // Company
         int lenCompany = (int)fbuf[posCompany -1];
         byte[] chCompany = new byte[lenCompany];
         System.arraycopy(fbuf, posCompany, chCompany, 0, lenCompany);
         license.setCompany(new String(chCompany));
         
         // Contact
         int lenContact = (int)fbuf[posContact -1];
         byte[] chContact = new byte[lenContact];
         System.arraycopy(fbuf, posContact, chContact, 0, lenContact);
         license.setContact(new String(chContact));
         
         // Users
         byte users = (byte)fbuf[posUsers];
         license.setUsers(users);
         
         // Mode
         license.setMode(fbuf[posMode]);
         
         if(license.getMode() == MODE_TRIAL)
         {   
         	byte[] ar = new byte[8];
         	ar[0] = fbuf[posStartDay];
         	ar[1] = fbuf[posStartDay + 1];
         	ar[2] = fbuf[posStartDay + 2];
         	ar[3] = fbuf[posStartDay + 3];
         	ar[4] = fbuf[posStartDay + 4];
         	ar[5] = fbuf[posStartDay + 5];
         	ar[6] = fbuf[posStartDay + 6];
         	ar[7] = fbuf[posStartDay + 7];
         	
         	/*ar[7] = fbuf[posStartDay];
         	ar[6] = fbuf[posStartDay + 1];
         	ar[5] = fbuf[posStartDay + 2];
         	ar[4] = fbuf[posStartDay + 3];
         	ar[3] = fbuf[posStartDay + 4];
         	ar[2] = fbuf[posStartDay + 5];
         	ar[1] = fbuf[posStartDay + 6];
         	ar[0] = fbuf[posStartDay + 7];*/
         	
         	int end = fbuf[posStartDay + 8];
         	
         	ByteArrayInputStream bais = new ByteArrayInputStream(ar);
         	DataInputStream dis = new DataInputStream(bais);
         	
         	license.setStartDay(dis.readLong());
         	license.setDays(fbuf[posDays]);
         }
      }
      catch(Exception e)
      {
         license = null;
         e.printStackTrace();
      }
   }
   
   public License getLicense()
   {
      return this.license;
   }
   
   public long getCRC()
   {
      return this.crc;
   }
}
/*
 * 
 * $Log: LicenseFileReader.java,v $
 * Revision 1.2  2005/03/23 07:34:51  brian
 * Added start-day.
 *
 * 
 */
