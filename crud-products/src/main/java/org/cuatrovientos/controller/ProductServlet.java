package org.cuatrovientos.controller;

import java.io.IOException;
import java.util.List;

import org.cuatrovientos.model.Product;
import org.cuatrovientos.persistence.ProductRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/products/*")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;
    public void init() {
        this.productRepository = new ProductRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        if ("/new".equals(path)) {
            req.getRequestDispatcher("/WEB-INF/views/product/new.jsp").forward(req, resp);

        } else if ("/edit".equals(path)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Product product = this.productRepository.findById(id);
            req.setAttribute("product", product);
            req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req, resp);

        } else {
            List<Product> products = productRepository.findAll();
            req.setAttribute("products", products);
            req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        if ("/create".equals(path)) {
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            double price = Double.parseDouble(req.getParameter("price"));

            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);

            productRepository.create(product);
            resp.sendRedirect(req.getContextPath() + "/products");

        } else if ("/update".equals(path)) {

            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            double price = Double.parseDouble(req.getParameter("price"));

            Product product = new Product();
            product.setId(id);
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);

            productRepository.update(product);

            resp.sendRedirect(req.getContextPath() + "/products");

        } else if ("/delete".equals(path)) {
            
            int id = Integer.parseInt(req.getParameter("id"));
            Product product = productRepository.findById(id);

            productRepository.delete(product);

            resp.sendRedirect(req.getContextPath() + "/products");
        }
    }
}
