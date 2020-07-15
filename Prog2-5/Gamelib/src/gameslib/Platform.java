package gameslib;

import java.util.Objects;

public class Platform implements Comparable<Platform>{
    private final String name;
    private final String company;

    public Platform(String name, String company) {
        if(name == null || company == null || company.equals("") || name.equals(""))
            throw new IllegalArgumentException();
        this.name = name;
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Platform platform = (Platform) o;
        return Objects.equals(name, platform.name) &&
                Objects.equals(company, platform.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company);
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public int compareTo(Platform platform) {
        if (platform == null)
            throw new IllegalArgumentException("other platform must not be null");

        int result = name.compareTo(platform.name);

        if (result == 0)
            result = company.compareTo(platform.company);

        return result;
    }
}
