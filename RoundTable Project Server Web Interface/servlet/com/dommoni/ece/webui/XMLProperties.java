/*
 * $Header: /DCVS/RoundTable\040Project\040Server\040Web\040Interface/servlet/com/dommoni/ece/webui/XMLProperties.java,v 1.1.1.1 2005/03/14 21:26:32 Brian Abbott Exp $
 *
 * @author $Author: Brian Abbott $
 * @version CVS $Revision: 1.1.1.1 $
 *
 * Copyright (c) 2003 AwarePoint Corporation. All rights reserved.
 * AWAREPOINT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.dommoni.ece.webui;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.StringTokenizer;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * The simple XML properties.
 */
public class XMLProperties
{
   /**
    * The XML properties file.
    */
   protected File file = null;

   /**
    * The XML document tree of the document.
    */
   protected Document domTree = null;

   /**
    * The defualt values come from here.
    */
   protected XMLProperties parent = null;

   /**
    * Constructs a properties from a file.
    */
   public XMLProperties(File file) throws IOException
   {
      this.file = file;

      if (this.file != null)
         loadProperties();
   }

   /**
    * Constructs a properties from an input stream.
    */
   public XMLProperties(InputStream ins) throws IOException
   {
      this.file = null;
      loadProperties(ins);
   }

   /**
    * Constructs a properties from a file, with defaults from parent.
    */
   public XMLProperties(File file, XMLProperties parent) throws IOException
   {
      this.file = file;

      if (this.file != null)
         loadProperties();

      this.parent = parent;
   }

   /**
    * Empty properties
    */
   public XMLProperties() throws IOException
   {
      this.file = null;

      DocumentFactory docFactory = DocumentFactory.getInstance();

      domTree = docFactory.createDocument();
      domTree.addElement("properties");
   }

   /**
    * Empty properties, with defaults from parent.
    */
   public XMLProperties(XMLProperties parent) throws IOException
   {
      this.file = null;

      DocumentFactory docFactory = DocumentFactory.getInstance();

      domTree = docFactory.createDocument();
      domTree.addElement("properties");

      this.parent = parent;
   }

   /**
    * Set the file.
    */
   public void setFile(File file)
   {
      this.file = file;
   }

   /**
    * Initializes the properties with the given file.
    */
   public void loadProperties() throws IOException
   {
      try
      {
         SAXReader reader = new SAXReader("org.apache.xerces.parsers.SAXParser");
         reader.setValidation(false);
         domTree = reader.read(new FileInputStream(this.file));
      }
      catch (Exception e)
      {
         throw new IOException("Error in file: " + e.getMessage());
      }
   }

   /**
    * Initializes the properties with the given file.
    */
   public void loadProperties(InputStream ins) throws IOException
   {
      try
      {
         SAXReader reader = new SAXReader("org.apache.xerces.parsers.SAXParser");
         reader.setValidation(false);
         domTree = reader.read(ins);
      }
      catch (Exception e)
      {
         throw new IOException(e.getMessage());
      }
   }

   /**
    * Saves the properties.
    */
   public void saveProperties() throws IOException
   {
      if (this.file == null)
         return;

      if (!this.file.exists())
         this.file.getParentFile().mkdirs();

      if (domTree == null)
         throw new IOException("The document is undefined.");

      BufferedOutputStream bouts = new BufferedOutputStream(new FileOutputStream(this.file));

      OutputFormat format = OutputFormat.createPrettyPrint();
      format.setLineSeparator("\r\n");
      XMLWriter writer = new XMLWriter(bouts, format);
      writer.write(this.domTree);
      bouts.close();
   }

   /**
    * Gets a property based on an XPATH location relative
    * to the root node.
    */
   public String getProperty(String xpath)
   {
      String result = null;

      Node node = this.domTree.getRootElement().selectSingleNode(xpath);
      if (node != null)
         result = node.getText();
      else if (this.parent != null)
         result = this.parent.getProperty(xpath);

      return result;
   }

   /**
    * Gets a property based on an XPATH location relative
    * to the root node.
    */
   public String getProperty(String xpath, String defaultValue)
   {
      String value = getProperty(xpath);
      if (value != null)
         return value;
      else
         return defaultValue;
   }

   /**
    * Gets a list of properties based on an XPATH location relative
    * to the root node.
    */
   public String[] getProperties(String xpath)
   {
      String[] result = null;
      List nodes = this.domTree.getRootElement().selectNodes(xpath);
      if (nodes != null && nodes.size() > 0)
      {
         result = new String[nodes.size()];
         for (int i = 0; i < nodes.size(); i++)
         {
            result[i] = ((Node) nodes.get(i)).getText();
         }
      }
      else if (this.parent != null)
         result = this.parent.getProperties(xpath);

      if (result == null)
         result = new String[0];

      return result;
   }

   /**
    * Sets a property based on an XPATH location relative
    * to the root node.
    */
   public void setProperty(String xpath, String value)
   {
      Element el = getElementAtPath(xpath);
      el.setText(value);
   }

   /**
    * Sets a list of properties based on an XPATH location relative
    * to the root node.
    */
   public void setProperties(String xpath, String[] values)
   {
      int pos = xpath.lastIndexOf("/");
      String parent = xpath.substring(0, pos);
      String child = xpath.substring(pos + 1, xpath.length());

      Element el = getElementAtPath(parent);
      el.elements().clear();
      for (int i = 0; i < values.length; i++)
      {
         Element newElement = el.addElement(child);
         newElement.setText(values[i]);
      }
   }

   /**
    * Gets a property based on an XPATH location relative
    * to the root node.
    */
   public boolean getBoolean(String xpath)
   {
      return Boolean.valueOf(getProperty(xpath)).booleanValue();
   }

   /**
    * Sets a property based on an XPATH location relative
    * to the root node.
    */
   public void setBoolean(String xpath, boolean value)
   {
      setProperty(xpath, String.valueOf(value));
   }

   /**
    * This returns the element specified in the xpath, creating any
    * elements if necessary.
    */
   protected Element getElementAtPath(String xpath)
   {
      StringTokenizer st = new StringTokenizer(xpath, "/");
      xpath = null;
      Element element = this.domTree.getRootElement();
      while (st.hasMoreTokens())
      {
         xpath = st.nextToken();
         Element nextElement = element.element(xpath);
         if (nextElement == null)
            nextElement = element.addElement(xpath);
         element = nextElement;
      }
      return element;
   }

   /**
    * Get the root element of the DOM 
    */
   protected Element getRootElement()
   {
      return this.domTree.getRootElement();
   }
}