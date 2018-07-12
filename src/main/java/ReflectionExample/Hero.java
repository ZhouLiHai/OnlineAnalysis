package ReflectionExample;

import java.util.Objects;

public class Hero {
	private String name;
	private int level;
	private double damage;

	public Hero() {
		System.out.println("default construct method.");
	}

	static {
		System.out.println("static initialized.");
	}

	public Hero(String name, int level, double damage) {
		this.name = name;
		this.level = level;
		this.damage = damage;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Hero hero = (Hero) o;
		return level == hero.level && Double.compare(hero.damage, damage) == 0 && Objects.equals(name, hero.name);
	}

	@Override
	public String toString() {
		return "Hero{" + "name='" + name + '\'' + ", level=" + level + ", damage=" + damage + '}';
	}

	@Override
	public int hashCode() {

		return Objects.hash(name, level, damage);
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}
}
