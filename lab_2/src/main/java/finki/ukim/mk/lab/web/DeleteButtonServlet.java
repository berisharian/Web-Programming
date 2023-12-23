package finki.ukim.mk.lab.web;

import finki.ukim.mk.lab.model.Author;
import finki.ukim.mk.lab.model.Book;
import finki.ukim.mk.lab.repository.AuthorRepository;
import finki.ukim.mk.lab.repository.BookRepository;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name="remove-author-servlet", urlPatterns = "/remove-authors")

public class DeleteButtonServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DeleteButtonServlet(SpringTemplateEngine springTemplateEngine, AuthorRepository authorRepository,
                               BookRepository bookRepository) {
        this.springTemplateEngine = springTemplateEngine;
        this.authorRepository = authorRepository;
        this.bookRepository=bookRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context=new WebContext(req, resp, req.getServletContext());
        String isbnFromParam=req.getParameter("isbn");
        Book isbnFromParam1 = bookRepository.findByIsbn(isbnFromParam);
        isbnFromParam1.getAuthors().clear();

        springTemplateEngine.process("/bookDetails.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
    }
}
