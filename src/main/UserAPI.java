
public class UserAPI {

    String className = this.getClass().getSimpleName();


    @Test
    public void LIST_USERS_01() throws Exception, TestLinkAPIException {
        addLog("LIST_USERS API TESTING");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();

            System.out.println("get list user");
            JSONObject collectpost1 = APIUtil.sendPost(APIData.GET_LIST_USERS, "");
            addLog("Get LIST_USERS Succeed");


    }

    @Test
    public void LIST_USERS_01() throws Exception, TestLinkAPIException {
        addLog("LIST_USERS API TESTING");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();


            System.out.println("get list user");
            JSONObject collectpost = APIUtil.sendGet(APIData.GET_LIST_USERS);
            System.out.println("get list user: " + collectpost);
            addLog("Get LIST_USERS Succeed");


    }

    @Test
    public void FIND_USER_02() throws Exception, TestLinkAPIException {
        addLog("FIND_USER API TESTING");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();


            System.out.println("find user 1");
            JSONObject collectpost = APIUtil.FindUser(APIData.FIND_USER, 1);
            System.out.println("user 1 is : " + collectpost);
            addLog("Find USER Succeed");

    }

    @Test
    public void CREATE_USER_03() throws Exception, TestLinkAPIException {
        addLog("CREATE USER API TESTING");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();


        System.out.println("create user ");
        String requestBody = "";//string requests json
        JSONObject collectpost = APIUtil.sendPost(APIData.GET_LIST_USERS, requestBody);
        addLog("create user Succeed");

    }

    @Test
    public void DELETE_USER_04() throws Exception, TestLinkAPIException {
        addLog("DELETE USER API TESTING");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();


        System.out.println("sendDelete user 1");
        JSONObject collectpost = APIUtil.sendDelete(APIData.DELETE_USER, 1);
        System.out.println("sendDelete 1 is : " + collectpost);
        addLog("DELETE USERS Succeed");

    }

    @Test
    public void UPDATE_USER_05() throws Exception, TestLinkAPIException {
        addLog("UPDATE USER API TESTING");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();


        System.out.println("update user 1");
        String requestBody = "";//string requests json
        JSONObject collectpost = APIUtil.UpdateUser(APIData.UPDATE_USER, 1);
        addLog("Update user Succeed");

    }


    @Test
    public void NEGATIVE_CASES_06() throws Exception, TestLinkAPIException {
        addLog("NEGATIVE CASES API TESTING");
        String sMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();

        System.out.println("find user which is not in list");
        JSONObject collectpost = APIUtil.FindUser(APIData.FIND_USER, 111);
        addLog("User is not found");
        System.out.println("delete user which is not in list");
        JSONObject collectpost = APIUtil.sendDelete(APIData.DELETE_USER, 111);
        addLog("User is not found");
    }


}