package org.workfully.servlets.api.v2.resources.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.message.DeflateEncoder;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.filter.EncodingFilter;

@ApplicationPath("/api/v2/*")
public class ProductsServlet extends ResourceConfig {

    public ProductsServlet() {
        register(EncodingFilter.class);
        register(GZipEncoder.class);
        register(DeflateEncoder.class);
        /*
         * This line of code sets a property in the server configuration to buffer the
         * response entity
         * before sending it to the client. The size of the buffer is 32 KB (32768
         * bytes).
         * This property is useful to avoid using the "chunked" transfer encoding, which
         * is the default
         * when the server doesn't know the size of the response entity. The "chunked"
         * encoding adds
         * extra overhead to the response and can cause problems with some clients. By
         * buffering the
         * response entity before sending it, the server can determine its size and use
         * the more
         * efficient "content-length" transfer encoding instead.
         */
        property(ServerProperties.OUTBOUND_CONTENT_LENGTH_BUFFER, 32768);
    }
}
