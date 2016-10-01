package kr.ac.hanyang.oCamp.rest;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.core.mgmt.ManagementContextInjectable;
import org.apache.brooklyn.rest.BrooklynRestApp;
import org.apache.brooklyn.rest.apidoc.RestApiResourceScanner;
import org.apache.brooklyn.rest.util.ManagementContextProvider;
import org.apache.cxf.BusFactory;
import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.apache.cxf.transport.common.gzip.GZIPInInterceptor;
import org.apache.cxf.transport.common.gzip.GZIPOutInterceptor;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import io.swagger.config.ScannerFactory;

public class RestApiSetup {
	public static void installRest(ServletContextHandler context, Object... providers) {
        initSwagger();

        OCampRestApp app = new OCampRestApp();
        for (Object o : providers) {
            app.singleton(o);
        }

        ManagementContext managementContext = extractManagementContext(providers);
        for (Object o : app.getSingletons()) {
            injectManagementContext(managementContext, o);
        }

        CXFNonSpringJaxrsServlet servlet = new CXFNonSpringJaxrsServlet(app);
        servlet.setBus(BusFactory.newInstance().createBus());
        servlet.getBus().getInInterceptors().add(new GZIPInInterceptor());
        servlet.getBus().getInFaultInterceptors().add(new GZIPInInterceptor());
        servlet.getBus().getOutInterceptors().add(new GZIPOutInterceptor());
        final ServletHolder servletHolder = new ServletHolder(servlet);

        context.addServlet(servletHolder, "/v1/*");
    }

    private static void injectManagementContext(ManagementContext managementContext, Object o) {
        if (managementContext != null && o instanceof ManagementContextInjectable) {
            ((ManagementContextInjectable) o).setManagementContext(managementContext);
        }
    }

    private static ManagementContext extractManagementContext(Object... providers) {
        for (Object o : providers) {
            if (o instanceof ManagementContextProvider) {
                return ((ManagementContextProvider) o).getContext(ManagementContext.class);
            }
        }
        return null;
    }

    @SafeVarargs
    public static void installServletFilters(ServletContextHandler context, Class<? extends Filter>... filters) {
        installServletFilters(context, Arrays.asList(filters));
    }

    public static void installServletFilters(ServletContextHandler context, Collection<Class<? extends Filter>> filters) {
        for (Class<? extends Filter> filter : filters) {
            context.addFilter(filter, "/*", EnumSet.allOf(DispatcherType.class));
        }
    }

    public static void initSwagger() {
        ScannerFactory.setScanner(new RestApiResourceScanner());
    }
}
