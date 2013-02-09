/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filerunner;

import dota2patcher.Dota2PatcherUI;
import dota2patcher.Dota2PatcherUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 *
 * @author maz
 */
class StreamGobbler extends Thread
{
    Dota2PatcherUI ui;
    InputStream is;
    String type;
    
    StreamGobbler(InputStream is, String type)
    {
        this.is = is;
        this.type = type;
    }
    
    public void run()
    {
        try
        {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line=null;
            while ( (line = br.readLine()) != null)
                if (type == "OUTPUT"){
                    System.out.println(line); 
                } else {
                    System.out.println("[" + type + "]" + line); 
                }
            } catch (IOException ioe)
              {
                ioe.printStackTrace();  
              }
    }
}

