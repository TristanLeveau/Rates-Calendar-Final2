package servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import pojos.Currency;
import services.RateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/allrates")
public class AllRatesServlet extends AbstractGenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TemplateEngine templateEngine = this.createTemplateEngine(req);
        WebContext context = new WebContext(req, resp, getServletContext());
        context.setVariable("currencies", Currency.values());

        try {
            context.setVariable("rates", RateService.getInstance().listAllRates());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        templateEngine.process("allrates", context, resp.getWriter());
    }


}
