package servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import pojos.Rate;
import services.RateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ratedetails")
public class RateDetailsServlet extends AbstractGenericServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TemplateEngine templateEngine = this.createTemplateEngine(req);
        WebContext context = new WebContext(req, resp, getServletContext());
        HttpSession session = req.getSession();
        Integer idRate = Integer.parseInt(req.getParameter("idrate"));
        Rate rate = null;
        try {
            rate = RateService.getInstance().getRateById(idRate);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        session.setAttribute("rate", rate);
        templateEngine.process("ratedetails", context, resp.getWriter());
    }

}
