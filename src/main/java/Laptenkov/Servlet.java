package Laptenkov;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Сервлет - работает с четырьмя меодами запроса
 * GET, POST, PUT, DELETE
 * Опратвляет ответ с типом запроса.
 *
 * @author habatoo
 */
@WebServlet("/method")
public class Servlet extends HttpServlet {

    /**
     * Метод GET метод возвращает значения из сессии по имени параметра
     * при запросе GET по адресу http://localhost:8080/HW_17_1/methods
     *
     * @param request  запрос по адресу http://localhost:8080/HW_17_1/methods
     * @param response ответ при запросе по адресу http://localhost:8080/HW_17_1/methods
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        request.setAttribute("method", method);

        getServletContext()
                .getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }

    /**
     * Метод POST метод возвращает значения из сессии по имени параметра
     * при запросе POST по адресу http://localhost:8080/HW_17_1/method
     *
     * @param request  запрос по адресу http://localhost:8080/HW_17_1/method
     * @param response ответ при запросе по адресу http://localhost:8080/HW_17_1/method
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        request.setAttribute("method", method);

        getServletContext()
                .getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }

    /**
     * Метод PUT метод возвращает значения из сессии по имени параметра
     * при запросе PUT по адресу http://localhost:8080/HW_17_1/method
     *
     * @param request  запрос по адресу http://localhost:8080/HW_17_1/method
     * @param response ответ при запросе по адресу http://localhost:8080/HW_17_1/method
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        request.setAttribute("method", method);

        getServletContext()
                .getRequestDispatcher("/index.jsp")
                .forward(wrapRequest(request), response);
    }

    /**
     * Метод DELETE метод возвращает значения из сессии по имени параметра
     * при запросе DELETE по адресу http://localhost:8080/HW_17_1/method
     *
     * @param request  запрос по адресу http://localhost:8080/HW_17_1/method
     * @param response ответ при запросе по адресу http://localhost:8080/HW_17_1/method
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        request.setAttribute("method", method);

        getServletContext()
                .getRequestDispatcher("/index.jsp")
                .forward(wrapRequest(request), response);
    }

    /**
     * Метод обертка над методамаи PUT и DELETE.
     * Производит подменту ответа при вызове метода getMethod
     * @param request запрос HttpServletRequest
     * @return возвращает строку "GET"
     */
    private static HttpServletRequestWrapper wrapRequest(HttpServletRequest request) {
        return new HttpServletRequestWrapper(request) {
            @Override
            public String getMethod() {
                return "GET";
            }
        };
    }


}
