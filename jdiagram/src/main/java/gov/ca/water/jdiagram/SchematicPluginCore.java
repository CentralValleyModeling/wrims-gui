package gov.ca.water.jdiagram;

import com.mindfusion.diagramming.Diagram;
import com.mindfusion.diagramming.DiagramItem;
import com.mindfusion.pdf.PageSizesEnum;
import java.util.ArrayList;

public class SchematicPluginCore {
	
	public static String twFile="twSchematic.prf";
	
	public static String selDate="";
	
	public static int selIndex=-1;
	
	public static boolean showMagnifier=false;
	
	public static boolean zoomToRect=false;
	
	public static PageSizesEnum pageSize;
	
	public static ArrayList<DiagramItem> copiedItems = new ArrayList<DiagramItem>();
	
	public static Diagram copyDiagram = null;
	
	public static boolean isTAFMonthly = true;
}
