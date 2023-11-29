package finki.ukim.mk.lab.web;

import finki.ukim.mk.lab.model.Author;
import finki.ukim.mk.lab.repository.AuthorRepository;
import finki.ukim.mk.lab.service.AuthorService;
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
import java.util.Optional;

@WebServlet(name="authorServlet", urlPatterns = "/author")
public class AuthorServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final AuthorRepository authorRepository;
    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorServlet(SpringTemplateEngine springTemplateEngine, AuthorRepository authorRepository, AuthorService authorService, BookService bookService) {
        this.springTemplateEngine = springTemplateEngine;
        this.authorService = authorService;
        this.bookService=bookService;
        this.authorRepository=authorRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context=new WebContext(req, resp, req.getServletContext());
        String isbnFromParam = req.getParameter("isbn");
        List<Author> authorList= authorRepository.findAll();
        context.setVariable("authors", authorList);
        context.setVariable("isbn", isbnFromParam);
        springTemplateEngine.process("authorList.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context=new WebContext(req, resp, req.getServletContext());
        Long authorId = Long.valueOf(req.getParameter("authorId"));
        Optional<Author> byId =authorRepository.findById(authorId);
        String isbnFromParam=req.getParameter("isbn");
        bookService.addAuthorToBook(byId.get().getId(), isbnFromParam);
        resp.sendRedirect("/bookDetails");
    }
}
