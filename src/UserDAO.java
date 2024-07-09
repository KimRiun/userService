import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    private static Map<Integer, User> db = new HashMap<>();
    private static int index = 0;

    public boolean insert(User user) {
        user.setId(index);
        db.put(index, user);
        index++;
        return true;
    }

    public Map<Integer, User> selectAll() {
        return db;
    }

    public User select(String userId, String wp) throws Exception {
        for(User user : db.values()) {
            if(user.getUserId().equals(userId)) {
                if(user.getWp().equals(wp)) {
                    return user;
                }
                else {
                    throw new Exception("비밀번호가 일치하지 않습니다.");
                }
            }
        }
        throw new Exception("존재하지 않는 아이디입니다.");
    }

    public User select(int id) {
        return db.get(id);
    }

    public User update(Integer id, User modifiedUser) {
        modifiedUser.setIsLogin(true);
        db.replace(id, modifiedUser);
        return select(id);
    }

    public int delete(Integer id) {
        db.remove(id);
        return db.size();
    }
}
