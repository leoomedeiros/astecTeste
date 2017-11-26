/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.servlets.autenticacao;

import br.com.astec.model.entidades.Funcionario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando.tsuda
 */
@WebFilter(filterName = "AutorizacaoFilter",
	servletNames = {"SalvarProdutoServlet"},
	urlPatterns = {"/protegido/*"})
public class AutorizacaoFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // NAO FAZ NADA
  }

  @Override
  public void doFilter(ServletRequest request,
	  ServletResponse response, FilterChain chain)
	  throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    HttpSession sessao = httpRequest.getSession();
    if (sessao != null && sessao.getAttribute("usuario") != null) {
      // Usuario esta logado no sistema
      
      // Verificacao se usuario tem papel pra acessar funcionalidade
      //String paginaAcessada = httpRequest.getRequestURI();
      //String funcionalidade = paginaAcessada.replace(httpRequest.getContextPath(), "");
      
      UsuarioService service = new UsuarioService();
      Funcionario usuario = (Funcionario) sessao.getAttribute("usuario");
      if (service.usuarioAutorizado(usuario)) {
          httpResponse.sendRedirect(httpRequest.getContextPath() + "/telas/home/home.jsp");
	 
//chain.doFilter(request, response); // Deixa a requisicao pelo filtro
      } else {
	httpResponse.sendRedirect(httpRequest.getContextPath() + "/telas/Produto/MensagemErro.jsp");
      }
    } else {
      // Usuario nao esta logado
      httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
    }
  }

  @Override
  public void destroy() {
    // NAO FAZ NADA
  }

}
