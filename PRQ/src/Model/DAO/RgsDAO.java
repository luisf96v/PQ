/*
 *  PRQ PROYECT 
 *   Made by: Luis Fernando V�squez Quir�s 
 *      - Github: luisf96v
 *      - Email  : luis96v@gmail.com 
 */
package Model.DAO;

import Model.Entities.Rgs;
import java.sql.SQLException;
import java.util.List;
import org.joda.time.DateTime;

public interface RgsDAO {

    public List<Rgs> getOutHourNull() throws SQLException;

    public List<Rgs> rgsBtwDates(DateTime start, DateTime end) throws SQLException;

    public DateTime inRgs(String mat, int type) throws SQLException;

    public boolean outRgs(String mat, DateTime out, int tot, String fac) throws SQLException;

    public Rgs findRGS(String mat) throws SQLException;

    public void updateRGS(Rgs rgs) throws SQLException;

    public void deleteRGS(Rgs rgs) throws SQLException;

    public List<String> findValues(String key);

    public String findValue(String key);

    public void updateValue(String key, String value) throws SQLException;

    public void updateValue(int key, String value) throws SQLException;

    public String billHeader() throws SQLException;
}
