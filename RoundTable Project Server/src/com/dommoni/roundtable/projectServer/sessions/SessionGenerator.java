/*
 * $Header: /DCVS/RoundTable\040Project\040Server/src/com/dommoni/roundtable/projectServer/sessions/SessionGenerator.java,v 1.1.1.1 2005/03/14 21:02:40 Brian Abbott Exp $
 *
 * $Author: Brian Abbott $
 * $Revision: 1.1.1.1 $
 *
 * Copyright (c) 2003 Dommoni Corporation. All rights reserved.
 * DOMMONI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.dommoni.roundtable.projectServer.sessions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SessionGenerator
{
   /**
    * The default message digest algorithm to use if we cannot use
    * the requested one.
    */
   protected static final String DEFAULT_ALGORITHM = "MD5";

   /**
    * The number of random bytes to include when generating a
    * session identifier.
    */
   protected static final int SESSION_ID_BYTES = 16;

   private MessageDigest digest;
   private SecureRandom random;

   protected synchronized void getRandomBytes(byte bytes[])
   {
      if (random == null)
      {
         random = new SecureRandom();
      } 
      random.nextBytes(bytes);
   }

   protected synchronized MessageDigest getDigest()
   {
      if (digest == null)
      {
         try
         {
            digest = MessageDigest.getInstance(DEFAULT_ALGORITHM);
         }
         catch (NoSuchAlgorithmException e)
         {
            e.printStackTrace();
         }
      }
      return (this.digest);
   }

   /**
    * Generate and return a new session identifier.
    */
   public synchronized String generateSessionId()
   {
      byte bytes[] = new byte[SESSION_ID_BYTES];
      getRandomBytes(bytes);
      bytes = getDigest().digest(bytes);

      // Render the result as a String of hexadecimal digits
      StringBuffer result = new StringBuffer();
      for (int i = 0; i < bytes.length; i++)
      {
         byte b1 = (byte) ((bytes[i] & 0xf0) >> 4);
         byte b2 = (byte) (bytes[i] & 0x0f);
         if (b1 < 10)
            result.append((char) ('0' + b1));
         else
            result.append((char) ('A' + (b1 - 10)));
         if (b2 < 10)
            result.append((char) ('0' + b2));
         else
            result.append((char) ('A' + (b2 - 10)));
      }
      return (result.toString());
   }
}