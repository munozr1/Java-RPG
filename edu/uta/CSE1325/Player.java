package edu.uta.CSE1325;

import java.util.*;

/**
 * Defines a player object
 */
public class Player {
    private Weapon Weapon;
    private String Name;
    private int Level = 0;
    private int ArmorClass = 15;
    private int Experience = 0;
    private int HealthPoints = 50;
    private int Strength = 0;
    private int Dexterity = 0;
    private int Constitution = 0;
    private Date CreationDate = new Date();

    Player(final Weapon weapon, final String name, final int level, final int ac, final int e, final int hp,
            final int s, final int dex, final int con) {
        this.Weapon = weapon;
        this.Name = name;
        this.Level = level;
        this.ArmorClass = ac;
        this.Experience = e;
        this.HealthPoints = hp;
        this.Strength = s;
        this.Dexterity = dex;
        this.Constitution = con;
    }

    Player(final Weapon weapon, final String name,
            final int s, final int dex, final int con) {
        this.Weapon = weapon;
        this.Name = name;
        this.HealthPoints += returnModifier(con);
        this.Strength = s;
        this.Dexterity += returnModifier(dex);
        this.Constitution += con;
    }

    Player(String name, Weapon weapon) {
        this.Name = name;
        this.Weapon = weapon;
        this.randomizeStats();
    }

    /**
     * Attacks the victim by rolling against thier Armour Class (AC). If the hit
     * roll is equal
     * to or greater than the target's AC value, roll damage.
     * 
     * @param victim
     */
    public void attack(Player victim) {
        int damageToInflict = 0;
        if (GameUtility.rollDice(this.Weapon.getDiceType()) >= victim.ArmorClass) {
            // TODO
            damageToInflict = rollHit();
            victim.takeDamage(damageToInflict);
            System.out.println(this.Name + " hit " + victim.getName() + " for " + damageToInflict + " HP!");
        } else {
            System.out.println(this.Name + " missed!");
        }
    }

    /**
     * Rolls the dice type to determine how much damage the victim will take this
     * turn
     * 
     * @return How much damage the victim will take
     */
    private int rollHit() {
        return GameUtility.rollDice(this.Weapon.getDiceType()) + this.Weapon.getBonus();
    }

    /**
     * Decreases the players HP by the amount of damage taken
     * 
     * @param damage How much damage the player takes (decreased from HP)
     * @return void
     */
    public void takeDamage(int damage) {
        this.HealthPoints -= damage;
    }

    /**
     * Randomizes a charecters stats
     */
    public void randomizeStats() {
        int points = 10;
        Random generator = new Random();
        // set strength
        this.Strength = generator.nextInt(7) + 1;
        points -= this.Strength;
        // set dexterity
        if (points > 0)
            this.Dexterity = generator.nextInt(points) + 1;
        points -= this.Dexterity;
        this.ArmorClass = this.ArmorClass + this.Dexterity;
        // set constitution
        this.Constitution = points;
        // calc modifiers
        this.HealthPoints += returnModifier(this.Constitution);
        this.ArmorClass += returnModifier(this.ArmorClass);

    }

    private int returnModifier(int num) {
        int ret = 0;
        if (num > 5)
            ret = num;
        if (num < 5)
            ret = num * -1;
        return ret;
    }

    /**
     * getter : Gets the Weapon of the player
     * 
     * @return int
     */
    public Weapon getWeapon() {
        return this.Weapon;
    }

    /**
     * getter : Gets the Name of the player
     * 
     * @return String
     */
    public String getName() {
        return this.Name;
    }

    /**
     * getter : Gets the Level of the player
     * 
     * @return int
     */
    public int getLevel() {
        return this.Level;
    }

    /**
     * getter : Gets the ArmorClass of the player
     * 
     * @return int
     */
    public int getArmorClass() {
        return this.ArmorClass;
    }

    /**
     * getter : Gets the Experience of the player
     * 
     * @return int
     */
    public int getExperience() {
        return this.Experience;
    }

    /**
     * getter : Gets the HealthPoints of the player
     * 
     * @return int
     */
    public int getHealthPoints() {
        return this.HealthPoints;
    }

    /**
     * getter : Gets the Strength of the player
     * 
     * @return int
     */
    public int getStrength() {
        return this.Strength;
    }

    /**
     * getter : Gets the Dexterity of the player
     * 
     * @return int
     */
    public int getDexterity() {
        return this.Dexterity;
    }

    /**
     * getter : Gets the Constitution of the player
     * 
     * @return int
     */
    public int getConstitution() {
        return this.Constitution;
    }

    /**
     * getter : Gets the Creation Date of the player
     * 
     * @return int
     */
    public Date getCreationDate() {
        return this.CreationDate;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Name: " + this.Name + '\n' +
                "Level: " + this.Level + '\n' +
                "XP: " + this.Experience + '\n' +
                "HP: " + this.HealthPoints + '\n' +
                "STR: " + this.Strength + '\n' +
                "DEX: " + this.Dexterity + '\n' +
                "CON: " + this.Constitution + '\n' +
                "Creation Date: " + this.CreationDate + '\n';
    }

}
