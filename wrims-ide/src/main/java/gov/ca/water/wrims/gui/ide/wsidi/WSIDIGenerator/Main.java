package gov.ca.water.wrims.gui.ide.wsidi.WSIDIGenerator;

/*
 * Interface class to Main.py for GraalPy support
 */
public interface Main {
	void runWSIDI(String studyDvName, String lookupName,
			String launchName, double offset,
			String externalPath, String configFilePath);
}
