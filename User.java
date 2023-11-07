public class User {
    
    private String username;
    private String email;
    private String userType;

    
    public User() 
    {
        username = "Guest";
        email = "guest@example.com";
        userType = "Student";
    }

    
    public User(String username, String email) 
    {
        this.username = username;
        this.email = email;
        userType = "Student";
    }

    
    public User(String username, String email, String userType) 
    {
        this.username = username;
        this.email = email;
        this.userType = userType;
    }

    
    public String getUserDetails() 
    {
        return "Username: " + username + "\nEmail: " + email + "\nUser Type: " + userType;
    }

    
    public String getUserDetails(boolean includeAdditionalInfo) 
    {
        String userDetails = "Username: " + username + "\nEmail: " + email + "\nUser Type: " + userType;
        if (includeAdditionalInfo) 
        {
            userDetails += "\nyou are signed in.";
        }
        return userDetails;
    }

    public static void main(String[] args) 
    {
        
        User guestUser = new User();
        User studentUser = new User("Koushik", "Koushik@gmail.com");
        User instructorUser = new User("chris", "chris@gmail.com", "Instructor");

        System.out.println("Guest User Details:");
        System.out.println(guestUser.getUserDetails());

        System.out.println("\nStudent User Details:");
        System.out.println(studentUser.getUserDetails());

        System.out.println("\nInstructor User Details:");
        System.out.println(instructorUser.getUserDetails(true));
    }
}
