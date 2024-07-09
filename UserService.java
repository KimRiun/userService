import java.util.Map;

public class UserService {
    private static final UserDAO dao = new UserDAO();

    public int join(User user) {
        if(dao.insert(user)) {
            System.out.println(user.getName() + "님 가입을 환영합니다.");
            return dao.selectAll().size();
        }
        else {
            System.out.println("가입을 실패하였습니다.");
            return dao.selectAll().size();
        }
    }

    public Map<Integer, User> getUsers() {
        System.out.println("*** 전체 사용자 ***");
        System.out.println(dao.selectAll());
        return dao.selectAll();
    }

    public User login(String userId, String wp) {
        try {
            User user = dao.select(userId, wp);
            user.setIsLogin(true);
            System.out.println(user.getName() + "님 로그인 되었습니다.");
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public User modify(Integer id, User after) {
        User user = dao.update(id, after);
        System.out.println(user.getName() + "님 회원 정보가 수정되었습니다.");
        return user;
    }

    public int delete(Integer id) {
        int dbSize =  dao.delete(id);
        System.out.println("탈퇴되었습니다.");
        return dbSize;
    }
}
