
package service;

import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Mata
 */

@Path("/RestFulService/{rec}")
public class RestService {
  @GET
  public String doGET(@PathParam("rec") String rec)throws ParserConfigurationException, SAXException, IOException {
      String rezultat = "Prevod: " + Parser.Parse(rec);
      return rezultat;
  }
   
    
}
