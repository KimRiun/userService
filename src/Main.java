import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final UserService userService = new UserService();
    private static User loginUser;

    public static void main(String[] args) {
        int op = -1;
        while(op != 0) {
            op = selectMenu();
            switch (op) {
                case 0:
                    System.out.println("시스템을 종료합니다.");
                    break;
                case 1:
                    join();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    modifyUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                default:
                    System.out.println("메뉴를 올바르게 선택해주세요.");
                    op = -1;
            }
        }
    }

    private static int selectMenu() {
        System.out.println("1: 회원가입 / 2: 로그인 / 3: 회원정보 수정 / 4. 탈퇴 / 0: 종료");
        System.out.print("입력: ");
        return sc.nextInt();
    }

    private static void join() {
        System.out.println("가입하실 이름, 아이디, 비밀번호를 (띄어쓰기로 구분하여) 입력하세요.");
        System.out.print("입력: ");
        String name = sc.next();
        String userId = sc.next();
        String wp = sc.next();
        userService.join(new User(name, userId, wp));
    }

    private static void login() {
        System.out.println("아이디와 비밀번호를 (띄어쓰기로 구분하여) 입력하세요.");
        System.out.print("입력: ");
        String userId = sc.next();
        String wp = sc.next();
        loginUser = userService.login(userId, wp);
    }

    private static void modifyUser() {
        if(loginUser != null && loginUser.getIsLogin()) {
            System.out.println("수정할 이름, 아이디, 비밀번호를 (띄어쓰기로 구분하여) 입력하세요.");
            System.out.print("입력: ");
            String name = sc.next();
            String userId = sc.next();
            String wp = sc.next();
            loginUser = userService.modify(loginUser.getId(), new User(name, userId, wp));
        } else {
            System.out.println("로그인 상태가 아닙니다.");
        }
    }

    private static void deleteUser() {
        if(loginUser != null && loginUser.getIsLogin()) {
            userService.delete(loginUser.getId());
            loginUser = null;
        }
        else {
            System.out.println("로그인 상태가 아닙니다.");
        }
    }
}