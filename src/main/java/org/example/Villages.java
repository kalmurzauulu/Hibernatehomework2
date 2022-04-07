package org.example;

import javax.persistence.*;

@Entity
@Table(name = "villages")
public class Villages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String villagesName;
    String villagesMayor;
    int villagesPopulation;
    int villagesArea;

    public Villages() {
    }

    public Villages(String villagesName, String villagesMayor, int villagesPopulation, int villagesArea) {
        this.villagesName = villagesName;
        this.villagesMayor = villagesMayor;
        this.villagesPopulation = villagesPopulation;
        this.villagesArea = villagesArea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVillagesName() {
        return villagesName;
    }

    public void setVillagesName(String villagesName) {
        this.villagesName = villagesName;
    }

    public String getVillagesMayor() {
        return villagesMayor;
    }

    public void setVillagesMayor(String villagesMayor) {
        this.villagesMayor = villagesMayor;
    }

    public int getVillagesPopulation() {
        return villagesPopulation;
    }

    public void setVillagesPopulation(int villagesPopulation) {
        this.villagesPopulation = villagesPopulation;
    }

    public int getVillagesArea() {
        return villagesArea;
    }

    public void setVillagesArea(int villagesArea) {
        this.villagesArea = villagesArea;
    }

    @Override
    public String toString() {
        return "Villages{" +
                "id=" + id +
                ", villagesName='" + villagesName + '\'' +
                ", villagesMayor='" + villagesMayor + '\'' +
                ", villagesPopulation=" + villagesPopulation +
                ", villagesArea=" + villagesArea +
                '}';
    }
}
