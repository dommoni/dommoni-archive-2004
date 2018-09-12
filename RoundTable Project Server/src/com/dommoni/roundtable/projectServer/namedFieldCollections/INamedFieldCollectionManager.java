package com.dommoni.roundtable.projectServer.namedFieldCollections;

import com.dommoni.roundtable.NamedFieldCollection;
import com.dommoni.roundtable.NamedFieldTemplate;

public interface INamedFieldCollectionManager
{
   public int addNamedFieldCollection(Object parentObject, NamedFieldCollection namedFieldCollection) 
   throws Exception;
   
//   public int addNamedFieldCollectionFromTemplate(Object parentObject, NamedFieldTemplate template)
//   throws Exception;
   
   public void dropNamedFieldCollection(int namedFieldCollectionId) 
   throws Exception;
   
   public void modifyNamedFieldCollection(NamedFieldCollection namedFieldCollection) 
   throws Exception;
   
   public NamedFieldCollection getNamedFieldCollection(int namedFieldCollectionId) 
   throws Exception;
   
   public NamedFieldCollection getNamedFieldCollectionForObject(Object parentObject, String collectionName) 
   throws Exception;
   
   public NamedFieldCollection[] getAllNamedFieldCollectionsForObject(Object parentObject) 
   throws Exception;
}
/*
 *
 * $Log: INamedFieldCollectionManager.java,v $
 * Revision 1.1  2005/10/17 03:25:10  brian
 * Initial Revision.
 *
 *
 */