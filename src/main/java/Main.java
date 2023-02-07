import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        SocialMedia socialMedia = new SocialMedia();

        Users user = new Users(
                null,
                "argen",
                "argen@argen.com",
                "123",
                new Timestamp(System.currentTimeMillis()));

//        socialMedia.registration(user);

        boolean success = false;
        Long userId = socialMedia.authorization(user.getLogin(), user.getPassword());

        if (userId > 0 ) {
            System.out.println("Вы вошли в приложение");
            success = true;
        }
        UserLogs userLog =  new UserLogs(
                userId,
                new Timestamp(System.currentTimeMillis()),
                success);

        socialMedia.saveUsersLog(userLog);

    }
}
