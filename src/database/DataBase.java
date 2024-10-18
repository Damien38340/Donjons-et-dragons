package database;

import characters.Hero;
import characters.Warrior;
import characters.Wizard;

import java.sql.*;

public class DataBase {

    private final String DB_URL = "jdbc:mysql://localhost:3306/dungeons-and-dragons";
    private final String USER = "root";
    private final String PASSWORD = "";


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public void getHeroes() {
        String query = "SELECT * FROM hero";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\nList of Heroes:\n");
            while (rs.next()) {
                // Retrieve values from the ResultSet
                int id = rs.getInt("Id");
                String type = rs.getString("Type");
                String name = rs.getString("Name");
                int healthLevel = rs.getInt("HealthLevel");
                int strengthLevel = rs.getInt("StrengthLevel");
                String weaponOrSpell = rs.getString("WeaponSpell");
                String shield = rs.getString("Shield");

                // Print hero details
                System.out.printf("ID: %d, Type: %s, Name: %s, Health Level: %d, Strength Level: %d, Weapon/Spell: %s, Shield: %s%n",
                        id, type, name, healthLevel, strengthLevel, weaponOrSpell, shield);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving heroes: " + e.getMessage());
        }
    }

    public Hero getHeroById(int heroId, Hero player) {
        String query = "SELECT * FROM hero WHERE Id = ?";  // SQL query to get a hero by ID

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, heroId);  // Set the hero ID parameter
            ResultSet rs = stmt.executeQuery();

            // If the hero exists, return the corresponding Hero object
            if (rs.next()) {
                String type = rs.getString("Type");
                String name = rs.getString("Name");
                int healthLevel = rs.getInt("HealthLevel");
                int strengthLevel = rs.getInt("StrengthLevel");
                int id = rs.getInt("Id");

                // Create and return the Hero object
                if (type.equalsIgnoreCase("warrior")) {
                    return player = new Warrior(name, type, healthLevel, strengthLevel, id);
                }
                return player = new Wizard(name, type, healthLevel, strengthLevel, id);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving hero: " + e.getMessage());
        }
        // Return null if no hero is found
        return null;
    }

    public Hero getHeroByName(String heroName, Hero player) {
        String query = "SELECT * FROM hero WHERE Name = ?";  // SQL query to get a hero by Name

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, heroName); // Set the hero name parameter
            ResultSet rs = stmt.executeQuery();

            // If the hero exists, return the corresponding Hero object
            if (rs.next()) {
                String type = rs.getString("Type");
                String name = rs.getString("Name");
                int healthLevel = rs.getInt("HealthLevel");
                int strengthLevel = rs.getInt("StrengthLevel");
                int id = rs.getInt("Id");

                // Create and return the Hero object
                if (type.equalsIgnoreCase("warrior")) {
                    return player = new Warrior(name, type, healthLevel, strengthLevel, id);
                }
                return player = new Wizard(name, type, healthLevel, strengthLevel, id);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving hero: " + e.getMessage());
        }
        // Return null if no hero is found
        return null;
    }


    public void createHero(Hero hero) {
        String query = "INSERT INTO Hero (Type, Name, HealthLevel, StrengthLevel, WeaponSpell, Shield) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, hero.getType());
            stmt.setString(2, hero.getName());
            stmt.setInt(3, hero.getHp());
            stmt.setInt(4, hero.getAttack());
            stmt.setString(5, hero.getOffensiveGear() != null ? hero.getOffensiveGear().getName() : null);
            stmt.setString(6, hero.getDefensiveGear() != null ? hero.getDefensiveGear().getName() : null);


            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new hero was created successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error creating hero: " + e.getMessage());
        }
    }

    public void editHero(Hero hero) {
        String query = "UPDATE Hero SET Type = ?, Name = ?, HealthLevel = ?, StrengthLevel = ?, WeaponSpell = ?, Shield = ? WHERE Id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, hero.getType());
            stmt.setString(2, hero.getName());
            stmt.setInt(3, hero.getHp());
            stmt.setInt(4, hero.getAttack());
            stmt.setString(5, hero.getOffensiveGear() != null ? hero.getOffensiveGear().getName() : null);
            stmt.setString(6, hero.getDefensiveGear() != null ? hero.getDefensiveGear().getName() : null);
            stmt.setInt(7, hero.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Hero updated successfully!");
            } else {
                System.out.println("Hero not found");
            }

        } catch (SQLException e) {
            System.out.println("Error updating hero: " + e.getMessage());
        }
    }
}
