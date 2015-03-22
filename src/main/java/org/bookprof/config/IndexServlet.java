package org.bookprof.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

/**
 * Created by kr on 10/03/15.
 */
@WebServlet("/")
public class IndexServlet extends HttpServlet{

  Logger logger = org.slf4j.LoggerFactory.getLogger(IndexServlet.class);

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    logger.debug("IN Get");
    super.doGet(req, resp);
  }
}
