/*
 *  PRQ PROYECT 
 *   Made by: Luis Fernando V�squez Quir�s 
 *      - Github: luisf96v
 *      - Email  : luis96v@gmail.com 
 */
package Model.Imp;

import Model.DAO.RgsDAO;
import Model.Entities.Rgs;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;

public final class RgsImp extends DB implements RgsDAO {

    public RgsImp() throws ClassNotFoundException, SQLException {
        super();
    }

    public RgsImp(String link, String user, String pass) throws ClassNotFoundException, SQLException {
        super(link, user, pass);
    }

    @Override
    public List<Rgs> getOutHourNull() throws SQLException {
        ResultSet rs = this.executeRS("{CALL PRQ.RGS_OH_NULL()}");
        ArrayList<Rgs> list = new ArrayList<>();

        while (rs.next()) {
            list.add(
                    new Rgs(
                            rs.getString("MAT"),
                            new DateTime(rs.getTimestamp("IH")),
                            rs.getInt("TP"),
                            rs.getInt("ID")
                    )
            );
        }
        return list;
    }

    @Override
    public List<Rgs> rgsBtwDates(DateTime start, DateTime end) throws SQLException {
        String querry = this.rgsBtw
                .replace("date1", start.toString())
                .replace("date2", end.toString());

        ResultSet rs = this.executeRS(querry);
        ArrayList<Rgs> list = new ArrayList<>();

        while (rs.next()) {
            list.add(
                    new Rgs(
                            rs.getInt("TP"),
                            rs.getDouble("TTL")
                    )
            );
        }
        return list;
    }

    @Override
    public DateTime inRgs(String mat, int type) throws SQLException {
        String querry = this.inRgs
                .replace("{mat}", mat)
                .replace("{type}", String.valueOf(type));
        try {
            ResultSet rs = this.executeRS(querry);
            if (rs.next()) {
                return new DateTime(rs.getTimestamp("IH"));
            }
            throw new SQLException("Error in database.");
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1644) {
                return null;
            }
            throw ex;
        }
    }

    @Override
    public boolean outRgs(String mat, DateTime out, int tot, String fac) throws SQLException {
        String querry = this.outRgs
                .replace("{mat}", mat)
                .replace("{out}", out.toString("yyyy-MM-dd  HH:mm:ss"))
                .replace("{tot}", String.valueOf(tot))
                .replace("{fac}", fac);
        try {
            this.execute(querry);
            return true;
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1644) {
                return false;
            }
            throw ex;
        }
    }

    @Override
    public List<String> findValues(String key) {
        try {
            ResultSet rs = this.executeRS(findKeyValues.replace("{key}", key));
            ArrayList<String> list = new ArrayList();

            while (rs.next()) {
                list.add(rs.getString("descr"));
            }

            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RgsImp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String findValue(String key) {
        try {
            ResultSet rs = this.executeRS(findKeyValues.replace("{key}", key));
            if (rs.next()) {
                return rs.getString("DESCR");
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(RgsImp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String billHeader() throws SQLException {
        ResultSet rs = this.executeRS("{CALL PRQ.GET_BILL()}");
        if (rs.next()) {
            String fac = rs.getString("DESCR");
            String[] split = fac.split(" - ");
            this.execute(
                    new StringBuilder()
                            .append("{CALL PRQ.UPDATE_BILL('")
                            .append(analizeLetter(split[1], split[0].charAt(0)))
                            .append(" - ")
                            .append(analizeNumber(split[1]))
                            .append("')}")
                            .toString()
            );
            return fac;
        }
        return null;
    }

    @Override
    public Rgs findRGS(String mat) throws SQLException {
        ResultSet rs = this.executeRS("{CALL PRQ.FIND_RGS('{mat}')}".replace("{mat}", mat));
        rs.next();
        return new Rgs(
                rs.getString("MAT"),
                new DateTime(rs.getTimestamp("IH")),
                rs.getInt("TP"),
                rs.getInt("ID")
        );
    }

    @Override
    public void updateRGS(Rgs rgs) throws SQLException {
        this.execute("{CALL PRQ.UPDATE_RGS({id},'{mat}')}"
                .replace("{id}", String.valueOf(rgs.getNum()))
                .replace("{mat}", rgs.getMatricula())
        );
    }

    @Override
    public void deleteRGS(Rgs rgs) throws SQLException {
        this.execute("{CALL PRQ.DELETE_RGS({id})}"
                .replace("{id}", String.valueOf(rgs.getNum()))
        );
    }

    @Override
    public void updateValue(String key, String value) throws SQLException {
        this.execute("{CALL PRQ.UPDATE_KEY('{KEY}','{VALUE}')}"
                .replace("{KEY}", key)
                .replace("{VALUE}", value)
        );
    }
    
    
    @Override
    public void updateValue(int key, String value) throws SQLException {
       this.execute("{CALL PRQ.UPDATE_KEY_ID({KEY},'{VALUE}')}"
                .replace("{KEY}", String.valueOf(key))
                .replace("{VALUE}", value)
        );
    }

    private char analizeLetter(String i, char c) {
        if (i.equals("999")) {
            if (c == 'Z') {
                return 'A';
            }
            return (char) (c + 1);
        }
        return c;

    }

    private String analizeNumber(String i) {
        if (i.equals("999")) {
            return "001";
        }
        return String.format("%03d", Integer.valueOf(i) + 1);
    }

    private final String inRgs = "{CALL PRQ.IN_RGS('{mat}',{type})}";
    private final String outRgs = "{CALL PRQ.OUT_RGS('{mat}','{out}',{tot},'{fac}')}";
    private final String rgsBtw = "{CALL PRQ.RGS_BTW_DATES({date1},{date2})}";
    private final String findKeyValues = "{CALL PRQ.FIND_KEYVALUES('{key}')}";
}
