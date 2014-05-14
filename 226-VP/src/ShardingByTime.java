/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Rupesh
 */
public class ShardingByTime {

    /**
     * @param args the command line arguments
     */
   public static void insertData(Weather dataobj, Session session)
			throws Exception {
		try {
			session.merge(dataobj);
		} 
                catch (Exception e) 
                {
			throw e;
		}
	}
        
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
		BufferedReader br = null;
		String dataFile = "src/demo2.csv";
		String str;
		int counter = 0;
		long startTime = System.currentTimeMillis();
		SessionFactory sessionFact = hibernateShardUtil.getSessionFactory();
		Session session = sessionFact.openSession();

		try {
			br = new BufferedReader(new FileReader(dataFile));
 
			int batchSize=100;

			while ((str = br.readLine()) != null) {
				Weather dataobj = new Weather();
				StringTokenizer st = new StringTokenizer(str, ",");
				//Ignore/Filter first few LOC.
				if (st.toString().isEmpty()
						|| st.toString().contains("PARM = MNET;SLAT;")
						|| st.toString().contains(" STN  YYMMDD/HHMM"))
					continue;

				dataobj.setSTN(getnextToken(st));
				dataobj.setDATE(getnextToken(st));
				dataobj.setMNET(getnextToken(st));
				dataobj.setSLAT(getnextToken(st));
				dataobj.setSLON(getnextToken(st));
				dataobj.setSELV(getnextToken(st));
				dataobj.setTMPF(getnextToken(st));
				dataobj.setSKNT(getnextToken(st));
				dataobj.setDRCT(getnextToken(st));
				dataobj.setGUST(getnextToken(st));
				dataobj.setPMSL(getnextToken(st));
				dataobj.setALTI(getnextToken(st));
				dataobj.setDWPF(getnextToken(st));
				dataobj.setRELH(getnextToken(st));
				dataobj.setWTHR(getnextToken(st));
				dataobj.setP24I(getnextToken(st));
				try {
					insertData(dataobj,session);
					if (counter++ % batchSize == 0) {
						session.flush();
						session.clear();
					}
				} catch (ConstraintViolationException e) {
					continue;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
        		}
		}

		finally {

			if (session != null) {
				session.flush();
				session.clear();
			}
			System.out.println(counter + " number of rows inserted in "
					+ (System.currentTimeMillis() - startTime));
			if (br != null)
				br.close();
		}
	}

	static String getnextToken(StringTokenizer str) {
		if (str.hasMoreTokens())
			return str.nextToken();
		else
			return null;

	}        
}

