/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

/**
 *
 * @author R.Vishnupriya
 */
public class Weather implements Serializable{
    private String MNET;
    private String SLAT;
    private String SLON;
    private String SELV;
    private String TMPF;
    private String SKNT;
    private String GUST;
    private String DRCT;    
    private String PMSL;
    private String ALTI;
    private String DWPF;
    private String RELH;
    private String WTHR;
    private String P24I;
    private String DATE;  
    private String STN;

    public String getMNET() {
        return MNET;
    }

    public void setMNET(String MNET) {
        this.MNET = MNET;
    }

    public String getSLAT() {
        return SLAT;
    }

    public void setSLAT(String SLAT) {
        this.SLAT = SLAT;
    }

    public String getSLON() {
        return SLON;
    }

    public void setSLON(String SLON) {
        this.SLON = SLON;
    }

    public String getSELV() {
        return SELV;
    }

    public void setSELV(String SELV) {
        this.SELV = SELV;
    }

    public String getTMPF() {
        return TMPF;
    }

    public void setTMPF(String TMPF) {
        this.TMPF = TMPF;
    }

    public String getSKNT() {
        return SKNT;
    }

    public void setSKNT(String SKNT) {
        this.SKNT = SKNT;
    }

    public String getGUST() {
        return GUST;
    }

    public void setGUST(String GUST) {
        this.GUST = GUST;
    }

    public String getDRCT() {
        return DRCT;
    }

    public void setDRCT(String DRCT) {
        this.DRCT = DRCT;
    }

    public String getPMSL() {
        return PMSL;
    }

    public void setPMSL(String PMSL) {
        this.PMSL = PMSL;
    }

    public String getALTI() {
        return ALTI;
    }

    public void setALTI(String ALTI) {
        this.ALTI = ALTI;
    }

    public String getDWPF() {
        return DWPF;
    }

    public void setDWPF(String DWPF) {
        this.DWPF = DWPF;
    }

    public String getRELH() {
        return RELH;
    }

    public void setRELH(String RELH) {
        this.RELH = RELH;
    }

    public String getWTHR() {
        return WTHR;
    }

    public void setWTHR(String WTHR) {
        this.WTHR = WTHR;
    }

    public String getP24I() {
        return P24I;
    }

    public void setP24I(String P24I) {
        this.P24I = P24I;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getSTN() {
        return STN;
    }

    public void setSTN(String STN) {
        this.STN = STN;
    }
        
}
