package com.huawei.uee.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huawei.uee.dbconnect.DAOFactory;
import com.huawei.uee.user.User;

public class Login extends HttpServlet
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        String username = request.getParameter("username") ;
        String password = request.getParameter("password") ;
        // 收集错误信息
        List<String> info = new ArrayList<String>() ;   
        if(username==null || "".equals(username)){
            info.add("用户id不能为空！") ;
        }
        if(password==null || "".equals(password)){
            info.add("密码不能为空！") ;
        }
        // 里面没有记录任何的错误
        if(info.size()==0)
        {   
            User loginUser = new User() ;
            loginUser.setUsername(username) ;
            loginUser.setPassword(password) ;
            try{
                if(DAOFactory.getUserDAOInstance().isVaildUser(loginUser))
                {
                    List<User> users = null;
                    try
                    {
                        users = DAOFactory.getUserDAOInstance().selectUsersByUsername(loginUser.getUsername());
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    loginUser = users.get(0);
                    
                    //将用户信息存入session
                    HttpSession session = request.getSession();
                    session.setAttribute("loginUser",loginUser) ;
                    
                    //选择跳转页面，经理或者普通员工
                    if(loginUser.getUsername().equals("manager"))
                    {
//                      response.sendRedirect("manager.jsp");
                        request.getRequestDispatcher("manager.jsp").forward(request,response) ;
                    }else{
//                      response.sendRedirect("staff.jsp");
                        request.getRequestDispatcher("staff.jsp").forward(request,response) ;
                    }
                    return;
                    
                } else {
                    String path="login.jsp";
                    info.add("用户登陆失败，错误的用户名或密码！") ;
                    request.setAttribute("info",info) ;
                    request.getRequestDispatcher(path).forward(request,response) ;
//                  HttpSession session = request.getSession();
//                  session.setAttribute("info",info) ;
//                  response.sendRedirect(path);
                    request.getRequestDispatcher(path);
                    return;
                }
            }catch(Exception e){
                e.printStackTrace() ;
            }
        }

    }

}
