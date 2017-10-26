/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.br.tesouraria.util;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.br.tesouraria.view.manterDizimosModelView;

/**
 *
 * @author Danilo
 */
public class TimeLookup {
    
   static TimeLookup instance = new TimeLookup();
   public static TimeLookup getInstance() {return instance;}
   public TimeLookup(){}
    
	// List of time servers: http://tf.nist.gov/service/time-servers.html
	// Do not query time server more than once every 4 seconds
	public static final String TIME_SERVER = "time-a.nist.gov";

	public manterDizimosModelView pegarTempo(String dataLancDiz ) throws UnknownHostException, IOException{
		NTPUDPClient timeClient = new NTPUDPClient();
		InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
		TimeInfo timeInfo = timeClient.getTime(inetAddress);
		long returnTime = timeInfo.getReturnTime();
		Date time = new Date(returnTime);
                manterDizimosModelView dat = new manterDizimosModelView();
                dat.setDataLancDiz(TIME_SERVER);
                return dat;
        }
}
