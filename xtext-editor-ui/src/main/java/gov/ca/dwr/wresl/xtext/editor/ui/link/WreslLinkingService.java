package gov.ca.dwr.wresl.xtext.editor.ui.link;

import java.util.Collections;
import java.util.List;

import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Declaration;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorFactory;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorFactoryImpl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;

public class WreslLinkingService extends DefaultLinkingService{

    @Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
		List<EObject> list = super.getLinkedObjects(context, ref, node);
	    if ( list.isEmpty()) {
	    	final String crossRefString = getCrossRefNodeAsString(node).toLowerCase();
	    	URI contextUri = context.eResource().getURI();
	    	String[] segments = contextUri.segments();
	    	if (segments.length<2){
	    		return list;
	    	}
	        URI uri = URI.createPlatformResourceURI(segments[1]+"/src-gen/"+crossRefString+".wresl");
	        ResourceSet resourceSet = context.eResource().getResourceSet();
	        Resource resource = resourceSet.getResource(uri, false);
	        if ( resource ==null){          
	        	resource = resourceSet.createResource(uri);
	        	WreslEditorFactory f = WreslEditorFactoryImpl.eINSTANCE;
			    Declaration declare = (Declaration) f.create(WreslEditorPackage.Literals.DECLARATION);
			    declare.setName(crossRefString);
			    resource.getContents().add(declare);
  
			    /*
		    	try {
		    		resource.save(null);
		    	} catch (IOException e) {
		    		e.printStackTrace();
		    	}
		    	*/

			    IEObjectDescription eObjectDescription = EObjectDescription.create(crossRefString, declare);
			    list = Collections.singletonList(eObjectDescription.getEObjectOrProxy());
	        }else{
	        	EList<EObject> contents = resource.getContents();
	        	if (contents.size()>0){
	        		EObject o=contents.get(0);
	        		IEObjectDescription eObjectDescription = EObjectDescription.create(crossRefString, o);
	        		list = Collections.singletonList(eObjectDescription.getEObjectOrProxy());
	        	}
	        }
	    }
	    return list;
	}
}
