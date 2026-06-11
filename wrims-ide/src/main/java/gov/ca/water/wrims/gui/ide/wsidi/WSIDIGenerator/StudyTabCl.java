package gov.ca.water.wrims.gui.ide.wsidi.WSIDIGenerator;

public interface StudyTabCl
{
	void execute();

	void runForWsi(String studyDvName, String crvName, String crvWsiVar,
			String crvDiVar, String crvMax, String lookupName, String launchName, double offset);
}
