package servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successmodify")
public class SuccessModifyServlet extends AbstractGenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TemplateEngine templateEngine = this.createTemplateEngine(req);
        WebContext context = new WebContext(req, resp, getServletContext());

        templateEngine.process("successmodify", context, resp.getWriter());


    }
}
