package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UserProfile;
import java.util.HashMap;
import java.util.Map;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountService {
    private final Map<String, UserProfile> sessionIdToProfile;
    private DBService dbService;

    public AccountService(DBService dbService) {
        this.dbService = dbService;
        sessionIdToProfile = new HashMap<>();
    }

    public void addNewUser(UserProfile userProfile) throws DBException {
        dbService.addUser(userProfile.getName(), userProfile.getPassword());
    }

    public UserProfile getUserByLogin(String login) throws DBException {
        return dbService.getUser(login);
    }

    public UserProfile getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    public void addSession(String sessionId, UserProfile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }
}
