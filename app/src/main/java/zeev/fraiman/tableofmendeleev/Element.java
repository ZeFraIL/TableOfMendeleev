package zeev.fraiman.tableofmendeleev;

import java.util.ArrayList;

public class Element {
    private String name;
    private String appearance;
    private double atomic_mass;
    private double boil;
    private String category;
    private String color;
    private double density;
    private String discovered_by;
    private double melt;
    private double molar_heat;
    private String named_by;
    private int number;
    private int period;
    private String phase;
    private String summary;
    private String symbol;
    private int xpos;
    private int ypos;
    private ArrayList<Integer> shells;
    private String electron_configuration;
    private String electron_configuration_semantic;
    private double electron_affinity;
    private double electronegativity_pauling;
    private ArrayList<Double> ionization_energies;

    // Constructor
    public Element() {
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public double getAtomic_mass() {
        return atomic_mass;
    }

    public void setAtomic_mass(double atomic_mass) {
        this.atomic_mass = atomic_mass;
    }

    public double getBoil() {
        return boil;
    }

    public void setBoil(double boil) {
        this.boil = boil;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public String getDiscovered_by() {
        return discovered_by;
    }

    public void setDiscovered_by(String discovered_by) {
        this.discovered_by = discovered_by;
    }

    public double getMelt() {
        return melt;
    }

    public void setMelt(double melt) {
        this.melt = melt;
    }

    public double getMolar_heat() {
        return molar_heat;
    }

    public void setMolar_heat(double molar_heat) {
        this.molar_heat = molar_heat;
    }

    public String getNamed_by() {
        return named_by;
    }

    public void setNamed_by(String named_by) {
        this.named_by = named_by;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public ArrayList<Integer> getShells() {
        return shells;
    }

    public void setShells(ArrayList<Integer> shells) {
        this.shells = shells;
    }

    public String getElectron_configuration() {
        return electron_configuration;
    }

    public void setElectron_configuration(String electron_configuration) {
        this.electron_configuration = electron_configuration;
    }

    public String getElectron_configuration_semantic() {
        return electron_configuration_semantic;
    }

    public void setElectron_configuration_semantic(String electron_configuration_semantic) {
        this.electron_configuration_semantic = electron_configuration_semantic;
    }

    public double getElectron_affinity() {
        return electron_affinity;
    }

    public void setElectron_affinity(double electron_affinity) {
        this.electron_affinity = electron_affinity;
    }

    public double getElectronegativity_pauling() {
        return electronegativity_pauling;
    }

    public void setElectronegativity_pauling(double electronegativity_pauling) {
        this.electronegativity_pauling = electronegativity_pauling;
    }

    public ArrayList<Double> getIonization_energies() {
        return ionization_energies;
    }

    public void setIonization_energies(ArrayList<Double> ionization_energies) {
        this.ionization_energies = ionization_energies;
    }
}