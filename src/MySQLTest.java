import characters.Hero;

import java.sql.*;
import java.util.ArrayList;

public class MySQLTest {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/dungeons-and-dragons";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {


        try {
            // Establishing a connection
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            System.out.println("Connection established successfully!");

            conn.close(); // Close the connection
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    public static void getHeroes() {
        ArrayList<Hero> heroes = new ArrayList<>();
        String query = "SELECT * FROM hero";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("List of Heroes:");
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


    public static void createHero(Hero hero) {
        String query = "INSERT INTO Hero (Type, Name, HealthLevel, StrengthLevel, WeaponSpell, Shield) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, hero.getType());
            stmt.setString(2, hero.getName());
            stmt.setInt(3, hero.getHp());
            stmt.setInt(4, hero.getAttack());
            stmt.setString(5, hero.getOffensiveGear().toString());
            stmt.setString(6, hero.getDefensiveGear().toString());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new hero was created successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error creating hero: " + e.getMessage());
        }
    }

    public static void editHero(Hero hero) {
        String query = "UPDATE Hero SET Type = ?, Name = ?, HealthLevel = ?, StrengthLevel = ?, WeaponSpell = ?, Shield = ? WHERE Id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, hero.getType());
            stmt.setString(2, hero.getName());
            stmt.setInt(3, hero.getHp());
            stmt.setInt(4, hero.getAttack());
            stmt.setString(5, hero.getOffensiveGear().toString());
            stmt.setString(6, hero.getDefensiveGear().toString());

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
