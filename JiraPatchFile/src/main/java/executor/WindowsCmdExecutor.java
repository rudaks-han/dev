package executor;

import util.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WindowsCmd implements SystemCmd
{
    public String executeSvnLogFile(String revision, String fileUrl, String diffHistoryFileName, String svnLogCmd, String revisionDiffVersion)
    {
        String command = "executor /c cd " + System.getProperty("user.dir") + "/temp && " + svnLogCmd + " " + revisionDiffVersion + ":" + revision + " " + fileUrl + " > " + diffHistoryFileName;
        return Util.executeCommand(command);
    }

    public String diffSvnFile(String diffVersion, String fileUrl, String diffFileName, String svnDiffCmd)
    {
        //String command = SVN_DIFF_CMD + " -r " + diffVersion + " " + fileUrl;
        String command = "executor /c cd " + System.getProperty("user.dir") + "/temp && " + svnDiffCmd + " -r " + diffVersion + " " + fileUrl + " > " + diffFileName;
        return Util.executeCommand(command);
    }

    public String executeCommand(String command)
    {
        StringBuffer output = new StringBuffer();

        Process p;
        try
        {
            Util.debug("[executor] " + command);
            p = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream(), "MS949"));

            String line = "";
            while ((line = reader.readLine())!= null)
            {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
            Util.debug(e.getMessage());
        }

        return output.toString();
    }
}