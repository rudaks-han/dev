package executor;

public interface SystemCmd
{
    String executeSvnLogFile(String revision, String fileUrl, String diffHistoryFileName, String svnLogCmd, String revisionDiffVersion);

    String diffSvnFile(String diffVersion, String fileUrl, String diffFileName, String svnDiffCmd);

    String executeCommand(String command);
}
