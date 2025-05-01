package gov.ca.dwr.wresl.xtext.editor.ui.refactoring;

import gov.ca.dwr.wresl.xtext.editor.ui.internal.WreslEditorActivator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.refactoring.impl.AbstractProcessorBasedRenameParticipant;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;


/**
 * Updates references to a LilyPond source file when it is renamed.
 */
@SuppressWarnings("restriction")
public class WreslEditorRenameElementParticipant extends AbstractProcessorBasedRenameParticipant {
	
	@Inject
	private IResourceDescriptions resourceDescriptions;
	
	public static final String ECORE_REFACTORING_PARTICIPANT_SHOW_WARNING_OPTION = "org.eclipse.xtext.xtext.ui.refactoring.EcoreRefactoringParticipant.show.warning.option";

	public WreslEditorRenameElementParticipant(){
		WreslEditorActivator activator = WreslEditorActivator.getInstance();
		activator.getInjector("gov.ca.dwr.wresl.xtext.editor.WreslEditor").injectMembers(this);
	}
	
	

	private ArrayList<URI> findPlatformResourceURI(QualifiedName name, EClass type) {
		ArrayList<URI> URIs=new ArrayList<URI>();
		for (IResourceDescription resourceDescription : resourceDescriptions.getAllResourceDescriptions()) {
			if (Strings.equal("wresl", resourceDescription.getURI().fileExtension())) {
				for (IEObjectDescription eObjectDescription : resourceDescription.getExportedObjectsByType(type)) {
					QualifiedName eObjectDescriptionName=eObjectDescription.getName();
					if (name.getLastSegment().equalsIgnoreCase(eObjectDescriptionName.getLastSegment())) {
						URIs.add(eObjectDescription.getEObjectURI());
					}
				}
			}
		}
		return URIs;
	}

	@Override
	protected List<EObject> getRenamedElementsOrProxies(EObject originalTarget) {
		/*
		if (originalTarget instanceof IdentImpl) {
			String name=((IdentImpl)originalTarget).getName();
			if (!Strings.isEmpty(name)) {
				String packageNsURI = ((IdentImpl)originalTarget).eClass().getEPackage().getNsURI();
				QualifiedName classifierQualifiedName = QualifiedName.create(packageNsURI, name);
				ArrayList<URI> platformResourceURIs = findPlatformResourceURI(classifierQualifiedName, ((IdentImpl)originalTarget).eClass());
				if (platformResourceURIs.size() == 0) {
					return null;
				} else {
					ArrayList<EObject> classifierProxyList=new ArrayList<EObject>();
					for (int i=0; i<platformResourceURIs.size(); i++){
						EObject classifierProxy = EcoreFactory.eINSTANCE.createEObject();
						((InternalEObject) classifierProxy).eSetProxyURI(platformResourceURIs.get(i));
						String optionFlag = FrameworkProperties.getProperty(ECORE_REFACTORING_PARTICIPANT_SHOW_WARNING_OPTION, "true");
						if(optionFlag == null || "true".equalsIgnoreCase(optionFlag))
							getStatus().add(WARNING, 
								"Renaming EClass '{0}' in ecore file. Please rerun the Ecore generator.", ((IdentImpl)originalTarget).eClass());
						classifierProxyList.add(classifierProxy);
					}
					return classifierProxyList;
				}
			}
		}
		*/
		return null;
	}
}
