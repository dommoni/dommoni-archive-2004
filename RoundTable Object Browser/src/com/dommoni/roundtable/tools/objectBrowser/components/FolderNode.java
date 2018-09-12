package com.dommoni.roundtable.tools.objectBrowser.components;

import javax.swing.tree.DefaultMutableTreeNode;

public class FolderNode extends DefaultMutableTreeNode
{
   public FolderNode(String title)
   {
      super(title);
   }
   
   public boolean isLeaf() 
   {
      return false;
   }
   
   public boolean getAllowsChildren() 
   {
      return true;
   }
}
