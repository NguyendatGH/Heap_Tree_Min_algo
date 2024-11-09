package modal;

public class Planet {
     String name;
     double mass;
     double equatorialDiameter ;
     double Au ;
     double OrbitalPeriod;

    public Planet(String name, double mass, double equatorialDiameter, double Au, double OrbitalPeriod) {
        this.name = name;
        this.mass = mass;
        this.equatorialDiameter = equatorialDiameter;
        this.Au = Au;
        this.OrbitalPeriod = OrbitalPeriod;
    }

    public String getName() {
        return name;
    }

    public double getMass () {
        return mass;
    }

    public double getEquatorialDiameter() {
        return equatorialDiameter;
    }

    public double getAu(){
         return Au;
    }
    public double OrbitalPeriod() {
         return OrbitalPeriod;
    }


    public void setName(String name){
        this.name = name;
    }
    public void setMass(double mass){
        this.mass = mass;
    }

    public void setEquatorialDiameter(double equatorialDiameter){
        this.equatorialDiameter = equatorialDiameter;
    }

    public void setAu(double Au){
         this.Au = Au;
    }
    public void setOrbitalPeriod(double OrbitalPeriod){
         this.OrbitalPeriod = OrbitalPeriod;
    }
    @Override
    public String toString() {
        return "Name: " + name + "| Mass: " + mass + " | Equatorial Diameter: " + equatorialDiameter + "| Au: " + Au + " | Orbital Period: " + OrbitalPeriod;
    }

}
