package anekbot;

import clojure.lang.IFn;
import clojure.lang.RT;
import clojure.lang.Util;
import clojure.lang.Var;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnekCore extends HttpServlet {
    private static final Var main__var = Var.internPrivate("anekbot.core", "-main");
    private static final Var doPut__var = Var.internPrivate("anekbot.core", "-doPut");
    private static final Var doHead__var = Var.internPrivate("anekbot.core", "-doHead");
    private static final Var getServletConfig__var = Var.internPrivate("anekbot.core", "-getServletConfig");
    private static final Var toString__var = Var.internPrivate("anekbot.core", "-toString");
    private static final Var getLastModified__var = Var.internPrivate("anekbot.core", "-getLastModified");
    private static final Var doDelete__var = Var.internPrivate("anekbot.core", "-doDelete");
    private static final Var log__var = Var.internPrivate("anekbot.core", "-log");
    private static final Var destroy__var = Var.internPrivate("anekbot.core", "-destroy");
    private static final Var doPost__var = Var.internPrivate("anekbot.core", "-doPost");
    private static final Var doTrace__var = Var.internPrivate("anekbot.core", "-doTrace");
    private static final Var doGet__var = Var.internPrivate("anekbot.core", "-doGet");
    private static final Var getInitParameter__var = Var.internPrivate("anekbot.core", "-getInitParameter");
    private static final Var init__var = Var.internPrivate("anekbot.core", "-init");
    private static final Var getServletName__var = Var.internPrivate("anekbot.core", "-getServletName");
    private static final Var clone__var = Var.internPrivate("anekbot.core", "-clone");
    private static final Var doOptions__var = Var.internPrivate("anekbot.core", "-doOptions");
    private static final Var hashCode__var = Var.internPrivate("anekbot.core", "-hashCode");
    private static final Var getServletInfo__var = Var.internPrivate("anekbot.core", "-getServletInfo");
    private static final Var service__var = Var.internPrivate("anekbot.core", "-service");
    private static final Var getInitParameterNames__var = Var.internPrivate("anekbot.core", "-getInitParameterNames");
    private static final Var equals__var = Var.internPrivate("anekbot.core", "-equals");
    private static final Var getServletContext__var = Var.internPrivate("anekbot.core", "-getServletContext");
    private static final Var log_String__var = Var.internPrivate("anekbot.core", "-log-String");
    private static final Var log_String_Throwable__var = Var.internPrivate("anekbot.core", "-log-String-Throwable");
    private static final Var doGet_HttpServletRequest_HttpServletResponse__var = Var.internPrivate("anekbot.core", "-doGet-HttpServletRequest-HttpServletResponse");
    private static final Var init_void__var = Var.internPrivate("anekbot.core", "-init-void");
    private static final Var init_ServletConfig__var = Var.internPrivate("anekbot.core", "-init-ServletConfig");
    private static final Var service_HttpServletRequest_HttpServletResponse__var = Var.internPrivate("anekbot.core", "-service-HttpServletRequest-HttpServletResponse");
    private static final Var service_ServletRequest_ServletResponse__var = Var.internPrivate("anekbot.core", "-service-ServletRequest-ServletResponse");

    static {
        Util.loadWithClass("/anekbot/core", AnekCore.class);
    }

    public AnekCore() {
    }

    public void doHead(HttpServletRequest var1, HttpServletResponse var2) {
        Var var10000 = doHead__var;
        Object var3 = var10000.isBound() ? var10000.get() : null;
        if (var3 != null) {
            ((IFn)var3).invoke(this, var1, var2);
        } else {
            super.doHead(var1, var2);
        }

    }

    public void doOptions(HttpServletRequest var1, HttpServletResponse var2) {
        Var var10000 = doOptions__var;
        Object var3 = var10000.isBound() ? var10000.get() : null;
        if (var3 != null) {
            ((IFn)var3).invoke(this, var1, var2);
        } else {
            super.doOptions(var1, var2);
        }

    }

    public void init() {
        Var var10000 = init_void__var;
        Object var1 = var10000.isBound() ? var10000.get() : null;
        if (var1 == null) {
            var10000 = init__var;
            var1 = var10000.isBound() ? var10000.get() : null;
            if (var1 == null) {
                super.init();
                return;
            }
        }

        ((IFn)var1).invoke(this);
    }

    public void doPost(HttpServletRequest var1, HttpServletResponse var2) {
        Var var10000 = doPost__var;
        Object var3 = var10000.isBound() ? var10000.get() : null;
        if (var3 != null) {
            ((IFn)var3).invoke(this, var1, var2);
        } else {
            super.doPost(var1, var2);
        }

    }

    public void log(String var1) {
        Var var10000 = log_String__var;
        Object var2 = var10000.isBound() ? var10000.get() : null;
        if (var2 == null) {
            var10000 = log__var;
            var2 = var10000.isBound() ? var10000.get() : null;
            if (var2 == null) {
                super.log(var1);
                return;
            }
        }

        ((IFn)var2).invoke(this, var1);
    }

    public Object clone() {
        Var var10000 = clone__var;
        Object var1 = var10000.isBound() ? var10000.get() : null;
        return var1 != null ? ((IFn)var1).invoke(this) : super.clone();
    }

    public void service(HttpServletRequest var1, HttpServletResponse var2) {
        Var var10000 = service_HttpServletRequest_HttpServletResponse__var;
        Object var3 = var10000.isBound() ? var10000.get() : null;
        if (var3 == null) {
            var10000 = service__var;
            var3 = var10000.isBound() ? var10000.get() : null;
            if (var3 == null) {
                super.service(var1, var2);
                return;
            }
        }

        ((IFn)var3).invoke(this, var1, var2);
    }

    public String toString() {
        Var var10000 = toString__var;
        Object var1 = var10000.isBound() ? var10000.get() : null;
        return var1 != null ? (String)((IFn)var1).invoke(this) : super.toString();
    }

    public void destroy() {
        Var var10000 = destroy__var;
        Object var1 = var10000.isBound() ? var10000.get() : null;
        if (var1 != null) {
            ((IFn)var1).invoke(this);
        } else {
            super.destroy();
        }

    }

    public int hashCode() {
        Var var10000 = hashCode__var;
        Object var1 = var10000.isBound() ? var10000.get() : null;
        return var1 != null ? ((Number)((IFn)var1).invoke(this)).intValue() : super.hashCode();
    }

    public Enumeration getInitParameterNames() {
        Var var10000 = getInitParameterNames__var;
        Object var1 = var10000.isBound() ? var10000.get() : null;
        return var1 != null ? (Enumeration)((IFn)var1).invoke(this) : super.getInitParameterNames();
    }

    public String getInitParameter(String var1) {
        Var var10000 = getInitParameter__var;
        Object var2 = var10000.isBound() ? var10000.get() : null;
        return var2 != null ? (String)((IFn)var2).invoke(this, var1) : super.getInitParameter(var1);
    }

    public void doPut(HttpServletRequest var1, HttpServletResponse var2) {
        Var var10000 = doPut__var;
        Object var3 = var10000.isBound() ? var10000.get() : null;
        if (var3 != null) {
            ((IFn)var3).invoke(this, var1, var2);
        } else {
            super.doPut(var1, var2);
        }

    }

    public String getServletInfo() {
        Var var10000 = getServletInfo__var;
        Object var1 = var10000.isBound() ? var10000.get() : null;
        return var1 != null ? (String)((IFn)var1).invoke(this) : super.getServletInfo();
    }

    public void init(ServletConfig var1) {
        Var var10000 = init_ServletConfig__var;
        Object var2 = var10000.isBound() ? var10000.get() : null;
        if (var2 == null) {
            var10000 = init__var;
            var2 = var10000.isBound() ? var10000.get() : null;
            if (var2 == null) {
                super.init(var1);
                return;
            }
        }

        ((IFn)var2).invoke(this, var1);
    }

    public ServletContext getServletContext() {
        Var var10000 = getServletContext__var;
        Object var1 = var10000.isBound() ? var10000.get() : null;
        return var1 != null ? (ServletContext)((IFn)var1).invoke(this) : super.getServletContext();
    }

    public long getLastModified(HttpServletRequest var1) {
        Var var10000 = getLastModified__var;
        Object var2 = var10000.isBound() ? var10000.get() : null;
        return var2 != null ? ((Number)((IFn)var2).invoke(this, var1)).longValue() : super.getLastModified(var1);
    }

    public void service(ServletRequest var1, ServletResponse var2) {
        Var var10000 = service_ServletRequest_ServletResponse__var;
        Object var3 = var10000.isBound() ? var10000.get() : null;
        if (var3 == null) {
            var10000 = service__var;
            var3 = var10000.isBound() ? var10000.get() : null;
            if (var3 == null) {
                super.service(var1, var2);
                return;
            }
        }

        ((IFn)var3).invoke(this, var1, var2);
    }

    public void doTrace(HttpServletRequest var1, HttpServletResponse var2) {
        Var var10000 = doTrace__var;
        Object var3 = var10000.isBound() ? var10000.get() : null;
        if (var3 != null) {
            ((IFn)var3).invoke(this, var1, var2);
        } else {
            super.doTrace(var1, var2);
        }

    }

    public boolean equals(Object var1) {
        Var var10000 = equals__var;
        Object var2 = var10000.isBound() ? var10000.get() : null;
        return var2 != null ? (Boolean)((IFn)var2).invoke(this, var1) : super.equals(var1);
    }

    public void log(String var1, Throwable var2) {
        Var var10000 = log_String_Throwable__var;
        Object var3 = var10000.isBound() ? var10000.get() : null;
        if (var3 == null) {
            var10000 = log__var;
            var3 = var10000.isBound() ? var10000.get() : null;
            if (var3 == null) {
                super.log(var1, var2);
                return;
            }
        }

        ((IFn)var3).invoke(this, var1, var2);
    }

    public void doGet(HttpServletRequest param1, HttpServletResponse param2) {
        // $FF: Couldn't be decompiled
    }

    public void doDelete(HttpServletRequest var1, HttpServletResponse var2) {
        Var var10000 = doDelete__var;
        Object var3 = var10000.isBound() ? var10000.get() : null;
        if (var3 != null) {
            ((IFn)var3).invoke(this, var1, var2);
        } else {
            super.doDelete(var1, var2);
        }

    }

    public String getServletName() {
        Var var10000 = getServletName__var;
        Object var1 = var10000.isBound() ? var10000.get() : null;
        return var1 != null ? (String)((IFn)var1).invoke(this) : super.getServletName();
    }

    public ServletConfig getServletConfig() {
        Var var10000 = getServletConfig__var;
        Object var1 = var10000.isBound() ? var10000.get() : null;
        return var1 != null ? (ServletConfig)((IFn)var1).invoke(this) : super.getServletConfig();
    }

    public void doGet(HttpServletRequest param1, HttpServletResponse param2) {
        // $FF: Couldn't be decompiled
    }

    public static void main(String[] var0) {
        Var var10000 = main__var;
        Object var1 = var10000.isBound() ? var10000.get() : null;
        if (var1 != null) {
            ((IFn)var1).applyTo(RT.seq(var0));
        } else {
            throw new UnsupportedOperationException("anekbot.core/-main not defined");
        }
    }
}
