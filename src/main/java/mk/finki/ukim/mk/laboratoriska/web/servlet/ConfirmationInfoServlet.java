package mk.finki.ukim.mk.laboratoriska.web.servlet;

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

@WebServlet(name = "confirmationInfoServlet",urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {

    private final BalloonService balloonService;
    private final OrderService orderService;
    private final SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfoServlet(BalloonService balloonService,
                                   OrderService orderService,
                                   SpringTemplateEngine springTemplateEngine) {
        this.balloonService = balloonService;
        this.orderService = orderService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
        context.setVariable("ipaddress",req.getRemoteAddr());
        context.setVariable("clientAgent",req.getHeader("User-Agent"));
        this.springTemplateEngine.process("confirmationInfo.html",context,resp.getWriter());
    }
}
