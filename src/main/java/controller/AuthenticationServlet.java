package controller;//import javax.servlet.ServletException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class AuthenticationServlet extends HttpServlet {

    private HashMap<String,String> users = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
      this.users.put("arthur","arthurpassword");
        this.users.put("bereket","bereketpassword");
        this.users.put("ahmed","ahmedpassword");
        this.users.put("moke","mokepassword");

        System.out.print("AuthenticationServlet initialized...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        PrintWriter out = resp.getWriter();

        String uName = req.getParameter("userName");
        String pwd = req.getParameter("passWord");
        String keepLogged = req.getParameter("keepLogged");

        if(uName != null && pwd != null && !uName.isEmpty() && !pwd.isEmpty()){
            String returnedPass = this.users.get(uName);

            if(returnedPass != null && !returnedPass.isEmpty()){

                if(pwd.equals(returnedPass)){

                    HttpSession sess = req.getSession();
                    sess.setAttribute("userName",uName);


                   /* Cookie cookieU = new Cookie("UName", uName);
                    Cookie cookieP = new Cookie("UName", uName);
                    cookieU.setMaxAge(3600); //in seconds
                    cookieP.setMaxAge(3600); //in seconds
                    resp.addCookie(cookieU);
                    resp.addCookie(cookieP);*/

                    out.print("{\"auth\":\"YES\",\"message\":\"You are connected\"}");
                }
                else {
                    //out.print("{'auth':'NO','message':'Invalid credentials'}");
                    out.print("{\"auth\":\"NO\",\"message\":\"Invalid credentials\"}");
                }
            }
            else{
                //out.print("{'auth':'NO','message':'Invalid credentials'}");
                out.print("{\"auth\":\"NO\",\"message\":\"Invalid credentials\"}");
            }
        }
        else {
            out.print("{\"auth\":\"NO\",\"message\":\"Provide both User Name and Password\"}");
            //out.print("{'auth':'NO','message':'Provide both User Name and Password'}");
        }
    }



}
