package collections.sets.hashset;

import java.util.HashSet;
import java.util.Set;

// immutable class
public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    @Override
    // if we type HeavenlyBody as parameter, we just overload method, not override, cus we are changing the type of parameter
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());

        // checking if it is a subclass's object
        // actually we not need to check, cus we declared HeavenlyBody class final
        // that is mean we cannot extend it
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        System.out.println("hashcode called");
        // String class has hashCode method.
        // We generated hashCode method for only name
        return this.name.hashCode() + 57;
    }
}
