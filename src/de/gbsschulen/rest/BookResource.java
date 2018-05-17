package de.gbsschulen.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bookstore")
public class BookResource {

    private BookService bookService = new BookService();

    //http://localhost:8080/rest/bookstore/1

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Book getBook(@PathParam("id") int id) {
        Book book = bookService.getBook(id);
        return book;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public String delteBook(@PathParam("id") int id) {
        Book book = bookService.delteBook(id);
        if (book != null) {
            return book.getTitel() + "wurde aus DB gelöscht!";
        }
        return "nicht gelöscht";
    }

    //http://localhost:8080/rest/bookstore/book?id=1
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/book/")
    public Book gibBuch(@QueryParam("id") int id) {
        Book book = bookService.getBook(id);
        return book;
    }

    //curl -H "Content-Type: application/json" -X PUT -d '{"id":7, "autor":"Kopp", "isbn":"343242343","titel":"testtest"}' localhost:8080/rest/bookstore/createBook
    @PUT
    @Path("/createBook")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String puBook(Book book) {
        bookService.addBook(book);
        return "Hinzugefügt: " + book.getTitel();
    }
}
