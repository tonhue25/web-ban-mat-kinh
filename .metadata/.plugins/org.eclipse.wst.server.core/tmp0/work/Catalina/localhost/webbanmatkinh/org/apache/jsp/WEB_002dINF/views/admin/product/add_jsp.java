/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.70
 * Generated at: 2021-10-31 10:53:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(10);
    _jspx_dependants.put("jar:file:/E:/webbanmatkinh/webbanmatkinh/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/webbanmatkinh/WEB-INF/lib/sitemesh-2.4.2.jar!/META-INF/sitemesh-decorator.tld", Long.valueOf(1123653092000L));
    _jspx_dependants.put("/common/taglib.jsp", Long.valueOf(1634219349198L));
    _jspx_dependants.put("jar:file:/E:/webbanmatkinh/webbanmatkinh/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/webbanmatkinh/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153359882000L));
    _jspx_dependants.put("/WEB-INF/lib/spring-security-taglibs-3.2.8.RELEASE.jar", Long.valueOf(1631692614158L));
    _jspx_dependants.put("jar:file:/E:/webbanmatkinh/webbanmatkinh/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/webbanmatkinh/WEB-INF/lib/spring-webmvc-4.3.13.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1511752906000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1630531027718L));
    _jspx_dependants.put("jar:file:/E:/webbanmatkinh/webbanmatkinh/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/webbanmatkinh/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153359882000L));
    _jspx_dependants.put("jar:file:/E:/webbanmatkinh/webbanmatkinh/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/webbanmatkinh/WEB-INF/lib/spring-security-taglibs-3.2.8.RELEASE.jar!/META-INF/security.tld", Long.valueOf(1437576592000L));
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-4.3.13.RELEASE.jar", Long.valueOf(1630531020626L));
    _jspx_dependants.put("/WEB-INF/lib/sitemesh-2.4.2.jar", Long.valueOf(1629538926692L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"mobile-menu-overlay\"></div>\r\n");
      out.write("	<div class=\"main-container\">\r\n");
      out.write("		<div class=\"pd-ltr-20 xs-pd-20-10\">\r\n");
      out.write("			<div class=\"min-height-200px\">\r\n");
      out.write("				<div class=\"page-header\">\r\n");
      out.write("					<div class=\"row\">\r\n");
      out.write("						<div class=\"col-md-6 col-sm-12\">\r\n");
      out.write("							<div class=\"title\">\r\n");
      out.write("								<h4>Form</h4>\r\n");
      out.write("							</div>\r\n");
      out.write("							<nav aria-label=\"breadcrumb\" role=\"navigation\">\r\n");
      out.write("								<ol class=\"breadcrumb\">\r\n");
      out.write("									<li class=\"breadcrumb-item\"><a href=\"index.html\">Home</a></li>\r\n");
      out.write("									<li class=\"breadcrumb-item active\" aria-current=\"page\">Form Basic</li>\r\n");
      out.write("								</ol>\r\n");
      out.write("							</nav>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"col-md-6 col-sm-12 text-right\"></div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"pd-20 card-box mb-30\">\r\n");
      out.write("					<div class=\"clearfix\">\r\n");
      out.write("						<div class=\"pull-left\">\r\n");
      out.write("							<h4 class=\"text-blue h4\">Default Basic Forms</h4>\r\n");
      out.write("							<p class=\"mb-30\">All bootstrap element classies</p>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"pull-right\">\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					\r\n");
      out.write("					<form class=\"form-horizontal\" role=\"form\" id=\"formSubmit\" enctype=\"multipart/form-data\" method=\"post\" modelAttribute=\"model\">\r\n");
      out.write("					<div class=\"form-group row\">\r\n");
      out.write("							<label class=\"col-sm-12 col-md-2 col-form-label\">Name</label>\r\n");
      out.write("							<div class=\"col-sm-12 col-md-10\">\r\n");
      out.write("								<input name=\"name\" class=\"form-control\" type=\"text\"/>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"form-group row\">\r\n");
      out.write("							<label class=\"col-sm-12 col-md-2 col-form-label\">Price</label>\r\n");
      out.write("							<div class=\"col-sm-12 col-md-10\">\r\n");
      out.write("								<input name=\"price\" class=\"form-control\" type=\"number\"/>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"form-group row\">\r\n");
      out.write("							<label class=\"col-sm-12 col-md-2 col-form-label\">Discount</label>\r\n");
      out.write("							<div class=\"col-sm-12 col-md-10\">\r\n");
      out.write("								<input name=\"sale\" class=\"form-control\" type=\"number\"/>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"form-group row\">\r\n");
      out.write("							<label for=\"categoryCode\" class=\"col-sm-12 col-md-2 col-form-label\">Category</label>\r\n");
      out.write("							<div class=\"col-sm-12 col-md-10\">\r\n");
      out.write("								\r\n");
      out.write("							  	 <select name=\"categoryCode\" id=\"categoryCode\" class=\"custom-select col-12\">\r\n");
      out.write("								<option value=\"\" label=\"-- Chọn thể loại --\"/>\r\n");
      out.write("								");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("                            	</select>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"form-group row\">\r\n");
      out.write("							<label class=\"col-sm-12 col-md-2 col-form-label\">Image</label>\r\n");
      out.write("							<div class=\"col-sm-9\">\r\n");
      out.write("									<input name=\"file\" class=\"col-xs-10 col-sm-5\" id=\"file\" type=\"file\" />\r\n");
      out.write("								</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						\r\n");
      out.write("						<div class=\"form-group row\">\r\n");
      out.write("							<label class=\"col-sm-12 col-md-2 col-form-label\">Short Description</label>\r\n");
      out.write("							<div class=\"col-sm-12 col-md-10\">\r\n");
      out.write("							<textarea name= \"shortDescription\" class=\"form-control\" id=\"shortDescription\"></textarea>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"form-group row\">\r\n");
      out.write("							<label class=\"col-sm-12 col-md-2 col-form-label\">Detail</label>\r\n");
      out.write("							<div class=\"col-sm-12 col-md-10\">\r\n");
      out.write("							<textarea name=\"detail\"  class=\"form-control\" id=\"detail\"></textarea>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"row\">\r\n");
      out.write("					<div class=\"col-md-3 col-sm-12\"></div>\r\n");
      out.write("					<div class=\"col-md-6 col-sm-12\">\r\n");
      out.write("						<div class=\"clearfix form-actions\">\r\n");
      out.write("								<div class=\"col-md-offset-3 col-md-9\">\r\n");
      out.write("									<button class=\"btn btn-info\" type=\"submit\" id=\"btnAddOrUpdateNew\">\r\n");
      out.write("										<i class=\"ace-icon fa fa-check bigger-110\"></i>Thêm sản phẩm\r\n");
      out.write("									</button>\r\n");
      out.write("									\r\n");
      out.write("									&nbsp; &nbsp; &nbsp;\r\n");
      out.write("									<button class=\"btn btn-danger\" type=\"reset\">\r\n");
      out.write("										<i class=\"ace-icon fa fa-undo bigger-110\"></i>Hủy\r\n");
      out.write("									</button>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"col-md-3 col-sm-12\"></div>\r\n");
      out.write("				</div>\r\n");
      out.write("					</form>\r\n");
      out.write("					<div class=\"collapse collapse-box\" id=\"basic-form1\" >\r\n");
      out.write("						<div class=\"code-box\">\r\n");
      out.write("							<div class=\"clearfix\">\r\n");
      out.write("								<a href=\"javascript:;\" class=\"btn btn-primary btn-sm code-copy pull-left\"  data-clipboard-target=\"#copy-pre\"><i class=\"fa fa-clipboard\"></i> Copy Code</a>\r\n");
      out.write("								<a href=\"#basic-form1\" class=\"btn btn-primary btn-sm pull-right\" rel=\"content-y\"  data-toggle=\"collapse\" role=\"button\"><i class=\"fa fa-eye-slash\"></i> Hide Code</a>\r\n");
      out.write("							</div>\r\n");
      out.write("							<pre><code class=\"xml copy-pre\" id=\"copy-pre\">\r\n");
      out.write("							</code></pre>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f0_reused = false;
    try {
      _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f0.setParent(null);
      // /WEB-INF/views/admin/product/add.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f0.setVar("newURL");
      // /WEB-INF/views/admin/product/add.jsp(4,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f0.setValue("/quan-tri/san-pham/danh-sach");
      int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
      if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      _jspx_th_c_005furl_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f0, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f1_reused = false;
    try {
      _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f1.setParent(null);
      // /WEB-INF/views/admin/product/add.jsp(5,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f1.setVar("editNewURL");
      // /WEB-INF/views/admin/product/add.jsp(5,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f1.setValue("/quan-tri/san-pham/chinh-sua");
      int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
      if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      _jspx_th_c_005furl_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f1, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f2_reused = false;
    try {
      _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f2.setParent(null);
      // /WEB-INF/views/admin/product/add.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f2.setVar("newAPI");
      // /WEB-INF/views/admin/product/add.jsp(6,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f2.setValue("/api/product");
      int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
      if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      _jspx_th_c_005furl_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f2, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/views/admin/product/add.jsp(69,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("item");
      // /WEB-INF/views/admin/product/add.jsp(69,8) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/admin/product/add.jsp(69,8) '${categories}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${categories}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                            		<option value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.key}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.value}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</option>\r\n");
            out.write("                            	");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
