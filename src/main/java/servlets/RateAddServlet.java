package servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import pojos.Currency;
import pojos.Rate;
import pojos.VehicleType;
import services.RateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rateadd")
public class RateAddServlet extends AbstractGenericServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TemplateEngine templateEngine = this.createTemplateEngine(req);
        WebContext context = new WebContext(req, resp, getServletContext());
        context.setVariable("currencies", Currency.values());
        context.setVariable("vehicletypes", VehicleType.values());
        try {
            context.setVariable("rates", RateService.getInstance().listAllRates());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //context.setVariable("rate", new Rate(null,0,null,null,null,0,null, null,null,null,null));

        templateEngine.process("rateadd", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String source = req.getParameter("destination");
        String destination = req.getParameter("source");
        Double rateValue = Double.parseDouble(req.getParameter("rate"));
        int transferTime = Integer.parseInt(req.getParameter("transfertime"));
        String startDate = req.getParameter("startdate");
        String endDate = req.getParameter("enddate");
        String vehicleType =  req.getParameter("vehicletype");
        String currency = req.getParameter("currency");

        Rate rate = new Rate(null, rateValue,null,source,destination,transferTime,currency,vehicleType,startDate,endDate,null);

        try {
            RateService.getInstance().addRate(rate);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("successadd");
    }
}
