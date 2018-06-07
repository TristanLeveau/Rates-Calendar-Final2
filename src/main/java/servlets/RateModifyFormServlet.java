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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ratemodifyform")
public class RateModifyFormServlet extends AbstractGenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TemplateEngine templateEngine = this.createTemplateEngine(req);
        WebContext context = new WebContext(req, resp, getServletContext());
        HttpSession session = req.getSession();
        context.setVariable("currencies", Currency.values());
        context.setVariable("vehicletypes", VehicleType.values());
        if (session.getAttribute("rate")==null) {
            Integer idRate = Integer.parseInt(req.getParameter("idrate"));
            context.setVariable("idrate", idRate);
            Rate rate = null;
            try {
                rate = RateService.getInstance().getRateById(idRate);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            session.setAttribute("rate", rate);
        }else{
            Rate rate = (Rate) session.getAttribute("rate");
            Integer idRate = rate.getIdrate();
        }
        templateEngine.process("ratemodifyform", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String source = req.getParameter("destination");
        String destination = req.getParameter("source");
        Double rateValue = Double.parseDouble(req.getParameter("rate"));
        int transferTime = Integer.parseInt(req.getParameter("transfertime"));
        String startDate = req.getParameter("startdate");
        String endDate = req.getParameter("enddate");
        String vehicleType =  req.getParameter("vehicletype");
        String currency = req.getParameter("currency");
        Rate rateToModify = (Rate) session.getAttribute("rate");
        Integer idRate = rateToModify.getIdrate();
                //Integer.parseInt(req.getParameter("idrate"));

        Rate rate = new Rate(null, rateValue,null,source,destination,transferTime,currency,vehicleType,startDate,endDate,null);

        try {
            RateService.getInstance().updateRate(rate, idRate);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("successmodify");
    }
}
