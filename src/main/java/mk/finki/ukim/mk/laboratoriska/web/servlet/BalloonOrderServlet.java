package mk.finki.ukim.mk.laboratoriska.web.servlet;

import mk.finki.ukim.mk.laboratoriska.model.User;
import mk.finki.ukim.mk.laboratoriska.service.BalloonService;
import mk.finki.ukim.mk.laboratoriska.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "balloonOrderServlet",urlPatterns = "/BalloonOrder")
public class BalloonOrderServlet extends HttpServlet {

    private final BalloonService balloonService;
    private final OrderService orderService;
    private final SpringTemplateEngine springTemplateEngine;

    public BalloonOrderServlet(BalloonService balloonService, OrderService orderService, SpringTemplateEngine springTemplateEngine) {
        this.balloonService = balloonService;
        this.orderService = orderService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
        this.springTemplateEngine.process("deliveryInfo.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientName = req.getParameter("clientName");
        req.getSession().setAttribute("clientName",clientName);
        String clientAddress = req.getParameter("clientAddress");
        req.getSession().setAttribute("clientAddress",clientAddress);
        String color= (String) req.getSession().getAttribute("chosenColor");
        String size = (String) req.getSession().getAttribute("chosenSize");
        orderService.placeOrder(color,size, (User) req.getSession().getAttribute("user"));
        resp.sendRedirect("/ConfirmationInfo");
    }
}
