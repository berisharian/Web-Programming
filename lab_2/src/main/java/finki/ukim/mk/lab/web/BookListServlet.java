package finki.ukim.mk.lab.web;

import finki.ukim.mk.lab.model.Book;
import finki.ukim.mk.lab.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="book-list-servlet", urlPatterns = "/listBooks")
public class BookListServlet extends HttpServlet {
        private final SpringTemplateEngine springTemplateEngine;
        private final BookService bookService;

    public BookListServlet(SpringTemplateEngine springTemplateEngine, BookService bookService) {
        this.springTemplateEngine = springTemplateEngine;
        this.bookService = bookService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context=new WebContext(req, resp, req.getServletContext());
 //       context.setVariable("books", this.bookService.listBooks());
        List<Book> books=bookService.listBooks();
        context.setVariable("books", books);
        springTemplateEngine.process("listBooks.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bIsbn=req.getParameter("bookIsbn");
        Book bookByIsbn =bookService.findBookByIsbn(bIsbn);
        req.getSession().setAttribute("book", bookByIsbn);
        resp.sendRedirect("/author?isbn="+bookByIsbn.getIsbn());
        //resp.sendRedirect("/author");
    }
}
