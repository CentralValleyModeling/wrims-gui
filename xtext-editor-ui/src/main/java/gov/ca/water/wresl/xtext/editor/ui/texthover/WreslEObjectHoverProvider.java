package gov.ca.water.wresl.xtext.editor.ui.texthover;

import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.AliasImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ConstDefImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.DeclarationImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.DvarDefImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ExternalDefImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.GoalImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.IdentImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.SvarDefImpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

import gov.ca.water.wrims.gui.ide.debugger.core.DebugCorePlugin;

public class WreslEObjectHoverProvider extends DefaultEObjectHoverProvider {
	
	@Override
	protected String getFirstLine(EObject o) {
		String hoverText;
		if (o instanceof DeclarationImpl){
			hoverText=((DeclarationImpl) o).getName();
			DebugCorePlugin.hoverText=hoverText;
			return hoverText;
		}else if (o instanceof AliasImpl){
			hoverText=((AliasImpl) o).getRef().getName();
			DebugCorePlugin.hoverText=hoverText;
			return hoverText;
		}else if (o instanceof GoalImpl){
			hoverText=((GoalImpl) o).getName();
			DebugCorePlugin.hoverText=hoverText;
			return hoverText;
		}else if (o instanceof IdentImpl){
			hoverText=((IdentImpl) o).getName();
			DebugCorePlugin.hoverText=hoverText;
			return hoverText;
		}else if (o instanceof SvarDefImpl){
			hoverText=((SvarDefImpl) o).getRef().getName();;
			DebugCorePlugin.hoverText=hoverText;
			return hoverText;
		}else if (o instanceof DvarDefImpl){
			hoverText=((DvarDefImpl) o).getRef().getName();
			DebugCorePlugin.hoverText=hoverText;
			return hoverText;
		}else if (o instanceof ConstDefImpl){
			hoverText=((ConstDefImpl) o).getRef().getName();
			DebugCorePlugin.hoverText=hoverText;
			return hoverText;
		}else if (o instanceof ExternalDefImpl){
			hoverText=((ExternalDefImpl) o).getRef().getName();
			return hoverText;
		}else{
			DebugCorePlugin.hoverText="";
			return o.toString();
		}
	}
}
