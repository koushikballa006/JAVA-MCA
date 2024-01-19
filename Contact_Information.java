import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Contact_Information extends JFrame {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ESECOMP";
    private static final String USERNAME = "koushik";
    private static final String PASSWORD = "8008";

    private JTable contactTable;
    private DefaultTableModel tableModel;

    public Contact_Information() {
        setTitle("Contact Information Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        contactTable = null;
        tableModel = null;
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton addButton = new JButton("Add Contact Information");
        addButton.setBounds(10, 20, 200, 25);
        panel.add(addButton);

        JButton displayButton = new JButton("Display Contact Information");
        displayButton.setBounds(10, 60, 200, 25);
        panel.add(displayButton);

        JButton updateButton = new JButton("Update Contact Information");
        updateButton.setBounds(10, 100, 200, 25);
        panel.add(updateButton);

        JButton deleteButton = new JButton("Delete Contact Information");
        deleteButton.setBounds(10, 140, 200, 25);
        panel.add(deleteButton);

        JButton searchButton = new JButton("Search Contact");
        searchButton.setBounds(10, 180, 150, 25);
        panel.add(searchButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(10, 220, 80, 25);
        panel.add(exitButton);

        // Updated table placement
        createTableAndModel(panel);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addContactInfo();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (contactTable == null) {
                    createTableAndModel(panel);
                }
                displayContactInfo();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateContactInfo();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteContactInfo();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchContact();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void createTableAndModel(JPanel panel) {
        String[] columnNames = { "ID", "Name", "Email", "Phone Number" };
        tableModel = new DefaultTableModel(columnNames, 0);

        contactTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(contactTable);
        scrollPane.setBounds(220, 20, 350, 300);
        panel.add(scrollPane);
    }

    private void addContactInfo() {
        String name = JOptionPane.showInputDialog("Enter name:");
        String email = JOptionPane.showInputDialog("Enter email:");
        String phoneNumber = JOptionPane.showInputDialog("Enter phone number:");

        String insertSQL = "INSERT INTO contact_info (name, email, phone_number) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phoneNumber);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Contact information added successfully!");
                displayContactInfo();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add contact information.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void displayContactInfo() {
        String selectSQL = "SELECT * FROM contact_info";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectSQL)) {

            tableModel.setRowCount(0);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                tableModel.addRow(new Object[] { id, name, email, phoneNumber });
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateContactInfo() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the contact information to update:"));
        String newEmail = JOptionPane.showInputDialog("Enter new email:");
        String newPhoneNumber = JOptionPane.showInputDialog("Enter new phone number:");

        String updateSQL = "UPDATE contact_info SET email = ?, phone_number = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            preparedStatement.setString(1, newEmail);
            preparedStatement.setString(2, newPhoneNumber);
            preparedStatement.setInt(3, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Contact information updated successfully!");
                displayContactInfo();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update contact information. ID not found.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteContactInfo() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the contact information to delete:"));

        String deleteSQL = "DELETE FROM contact_info WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Contact information deleted successfully!");
                displayContactInfo();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete contact information. ID not found.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void searchContact() {
        String searchName = JOptionPane.showInputDialog("Enter the name to search:");
        String selectSQL = "SELECT * FROM contact_info WHERE name = ?";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

            preparedStatement.setString(1, searchName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phone_number");

                    String contactInfo = "ID: " + id + "\nName: " + name + "\nEmail: " + email + "\nPhone Number: "
                            + phoneNumber;
                    JOptionPane.showMessageDialog(this, contactInfo, "Contact Information",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Contact not present.");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Contact_Information().setVisible(true);
            }
        });
    }
}
