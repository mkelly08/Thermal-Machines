package uia.GIDA.thermalmachines;

import java.io.Serializable;

import android.util.Log;


public class OttoModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private double bore;
	private double stroke;
	private double rc;
	private double n;
	private double pa;
	private double ta;
	private double temp;
	private double pres;
	private double vol;
	private double heat;
	private double volC;
	private double volA;
	private double totalHeat;
	private double mass;
	private double K;
	private double Cp;
	private double Cv;
	private double airR;
	private double pci;
	private double eff;
	private double power;
	
	public final static double RVAL=287;
	public final static double NTOKGF=9.81;
	public final static double CALTOJ=4186;

	
	public OttoModel(){
		this.bore=0;
		this.stroke=0;
		this.rc=0;
		this.n=0;
		this.pa=0;
		this.ta=0;
		this.temp=0;
		this.pres=0;
		this.vol=0;
		this.heat=0;
		this.totalHeat=0;
		this.setMass(0);
		this.setK(1.41);
		this.setCp(0.24); //Kcal
		this.setAirR(14.69);
		this.setPci(44*Math.pow(10, 6));
		this.setCv(this.Cp/this.K);
		this.setEff(1-(1-Math.pow(this.rc, K-1)));
		this.setPower(0);
	}
	
	public void calcAdmition(){
		this.temp=0;
		this.pres=0;
		this.vol=0;
		this.heat=0;
		this.totalHeat=0;
		this.setMass(0);
		this.setK(1.41);
		this.setCp(0.24); //Kcal
		this.setAirR(14.69);
		this.setPci(44*Math.pow(10, 6));
		this.setCv(this.Cp/this.K);
		this.setEff(1-(1-Math.pow(this.rc, K-1)));
		this.setPower(0);
		this.temp=ta;
		this.pres=pa;
		volA=this.stroke*((Math.PI/4)*(Math.pow(this.bore, 2)));
		volC=volA/(this.rc-1);
		this.vol=volC+volA;
		this.heat=0;
		this.totalHeat=this.heat;
	}
	
	public void calcCompression(){
		double pres2,temp2;
		this.calcAdmition();
		pres2=this.pres;
		temp2=this.temp;
		this.vol=this.volC;
		this.pres=pres2*(Math.pow(this.rc, K));
		this.temp=temp2*(Math.pow(this.rc, K-1));
		this.heat=0;
		this.totalHeat+=this.heat;
		this.setEff(1-(temp2/this.temp));
	}
	
	public void calcExplotion(){
		double cc,temp3;
		this.calcCompression();
		temp3=this.temp;
		this.vol=this.volC;
		this.mass=(this.pa*this.volA)/(((RVAL*100)/NTOKGF)*this.ta);
		this.mass=this.mass+(this.mass/this.rc);
		cc=this.mass/(this.airR);
		this.heat=cc*this.pci;//J/Kg K
		this.totalHeat+=this.heat;
		Log.e("mass",""+this.mass);
		this.temp=((this.heat/CALTOJ)/(this.mass*this.Cv))+temp3;
		this.pres=(this.temp/temp3)*this.pres;
	}
	
	public void calcExpantion(){
		this.calcExplotion();
		this.vol=this.volC+this.volA;
		this.pres=this.pres/Math.pow(this.rc, this.K);
		this.temp=this.temp/Math.pow(this.rc,this.K-1);
		this.heat=0;
		this.totalHeat+=this.heat;
	}
	
	public void calcExaustion(){
		double temp4,heat;
		this.calcExpantion();
		temp4=this.temp;
		this.vol=this.volC+this.volA;
		this.pres=this.pa;
		this.temp=this.ta;
		this.heat=this.mass*this.Cv*(this.temp-temp4)*CALTOJ;
		heat=this.totalHeat;
		this.totalHeat=this.totalHeat+this.heat;
		this.setEff(this.totalHeat/heat);
		this.power=this.totalHeat*((this.n*(2*Math.PI))/(60*2));
	}
	
	public double getBore() {
		return bore;
	}
	public void setBore(double bore) {
		this.bore = bore;
	}
	public double getStroke() {
		return stroke;
	}
	public void setStroke(double stroke) {
		this.stroke = stroke;
	}
	public double getN() {
		return n;
	}
	public void setN(double n) {
		this.n = n;
	}
	public double getRc() {
		return rc;
	}
	public void setRc(double rc) {
		this.rc = rc;
	}
	public double getPa() {
		return pa;
	}
	public void setPa(double pa) {
		this.pa = pa;
	}
	public double getTa() {
		return ta;
	}
	public void setTa(double ta) {
		this.ta = ta;
	}
	
	public String toString(){
		return ""+this.bore+" "+this.stroke+" "+this.rc+" "+this.n+" "+this.pa+" "+this.ta;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getPres() {
		return pres;
	}

	public void setPres(double pres) {
		this.pres = pres;
	}

	public double getVol() {
		return vol;
	}

	public void setVol(double vol) {
		this.vol = vol;
	}

	public double getHeat() {
		return heat;
	}

	public void setHeat(double heat) {
		this.heat = heat;
	}

	public double getTotalHeat() {
		return totalHeat;
	}

	public void setTotalHeat(double totalHeat) {
		this.totalHeat = totalHeat;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public double getK() {
		return K;
	}

	public void setK(double k) {
		K = k;
	}

	public double getCp() {
		return Cp;
	}

	public void setCp(double cp) {
		Cp = cp;
	}

	public double getAirR() {
		return airR;
	}

	public void setAirR(double airR) {
		this.airR = airR;
	}

	public double getPci() {
		return pci;
	}

	public void setPci(double pci) {
		this.pci = pci;
	}

	public double getCv() {
		return Cv;
	}

	public void setCv(double cv) {
		Cv = cv;
	}

	public double getEff() {
		return eff;
	}

	public void setEff(double eff) {
		this.eff = eff;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

}
