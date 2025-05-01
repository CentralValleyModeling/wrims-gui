package wrimsv2.commondata.wresldata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class ModelDataSet {
	
	// / weight table   // <objName,  <itemName, value>>
	public ArrayList<String> wtList = new ArrayList<String>();
//	public ArrayList<String> wtList_global = new ArrayList<String>();
//	public ArrayList<String> wtList_local = new ArrayList<String>();
	public Map<String, WeightElement> wtMap = new HashMap<String, WeightElement>();

	// / external function structure
	public ArrayList<String> exList = new ArrayList<String>();
	public ArrayList<String> exList_global = new ArrayList<String>();
	public ArrayList<String> exList_local = new ArrayList<String>();
	public Map<String, External> exMap = new HashMap<String, External>();
	
	
//    //  / sv, ts, and dv list
//	public ArrayList<String> svTsDvList = new ArrayList<String>();	
//	
//	//  / sv and ts list
//	public ArrayList<String> svTsList = new ArrayList<String>();
	
	// / svar timeseries data structure
	public ArrayList<String> tsList = new ArrayList<String>();
	public ArrayList<String> tsList_global = new ArrayList<String>();
	public ArrayList<String> tsList_local = new ArrayList<String>();
	public Map<String, Timeseries> tsMap = new HashMap<String, Timeseries>();
	
	// / svar data structure
	public Set<String> svSet_unknown = new HashSet<String>();
	public ArrayList<String> svList = new ArrayList<String>();
	public ArrayList<String> svList_global = new ArrayList<String>();
	public ArrayList<String> svList_local = new ArrayList<String>();
	public Map<String, Svar> svMap = new HashMap<String, Svar>();

	// / dvar data structure
	public ArrayList<String> dvList = new ArrayList<String>();
	public ArrayList<String> dvList_global = new ArrayList<String>();
	public ArrayList<String> dvList_local = new ArrayList<String>();
	public Map<String, Dvar> dvMap = new HashMap<String, Dvar>();

	// / alias data structure
	public Set<String> asSet_unknown = new HashSet<String>();
	public ArrayList<String> asList = new ArrayList<String>();
	public ArrayList<String> asList_global = new ArrayList<String>();
	public ArrayList<String> asList_local = new ArrayList<String>();
	public Map<String, Alias> asMap = new HashMap<String, Alias>();

	// / goal data structure
	public ArrayList<String> gList = new ArrayList<String>();
	public ArrayList<String> gList_global = new ArrayList<String>();
	public ArrayList<String> gList_local = new ArrayList<String>();
	public Map<String, Goal> gMap = new HashMap<String, Goal>();
	
	public ArrayList<String> incFileList=new ArrayList<String>();
	public ArrayList<String> incFileList_global=new ArrayList<String>();
	public ArrayList<String> incFileList_local=new ArrayList<String>();
 
}

