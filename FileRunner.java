/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filerunner;

import com.jidesoft.utils.StringUtils;
import java.io.FileOutputStream;

/**
 *
 * @author maz
 */
public class FileRunner {
    
    private String[] args;
    
    public FileRunner(String args[]){
        this.args = args;

    }

    public void run()
    {       
        try
        {            
            String[] cmd = new String[3];
            cmd[0] = "cmd.exe" ;
            cmd[1] = "/C" ;
            cmd[2] = args[0];

            Runtime rt = Runtime.getRuntime();
            System.out.println("Execing " + StringUtils.stringList(args));
            Process proc = rt.exec(args);
            // any error message?
            StreamGobbler errorGobbler = new 
                StreamGobbler(proc.getErrorStream(), "ERROR");            
            
            // any output?
            StreamGobbler outputGobbler = new 
                StreamGobbler(proc.getInputStream(), "OUTPUT");
                
            // kick them off
            errorGobbler.start();
            outputGobbler.start();
                                    
            // any error???
            int exitVal = proc.waitFor();
            System.out.println("ExitValue: " + exitVal);        
        } catch (Throwable t)
          {
            t.printStackTrace();
          }
    }
}
