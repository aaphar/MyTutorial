package collections.sets.hashset.lastChallenge;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// immutable class
public abstract class HeavenlyBody {
    private final double orbitalPeriod;
    private final Key key;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes {
        PLANET,
        DWARF_PLANET,
        MOON,
        STAR,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.key = new Key(name, bodyType);
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        // use and look up the entry
        return new Key(name, bodyType);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        // have subclass that is why use instanceof
        if (obj instanceof HeavenlyBody) {
            // objects are equal if their keys are equal
            Key objKey = ((HeavenlyBody) obj).getKey();
            return this.key.equals(objKey);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Key key = (Key) o;
            return Objects.equals(name, key.name) && bodyType == key.bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + this.bodyType.hashCode() + 57;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }
}
