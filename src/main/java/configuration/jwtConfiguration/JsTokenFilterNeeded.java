package configuration.jwtConfiguration;

import com.sun.jersey.core.util.Priority;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import response.BaseResponse;
import util.JwTokenHelper;

import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@JsonTokenNeeded
@Priority(Priorities.AUTHENTICATION)
public class JsTokenFilterNeeded implements ContainerRequestFilter {

    private static final String AUTHORIZATION_SERVICE_PATH = "authorization_service";
    private static final String PRIVATE_KEY = "privateKey";
    private JwTokenHelper jwTokenHelper = JwTokenHelper.getInstance();

    public ContainerRequest filter(ContainerRequest request) {
        return request;
    }

    private Response getUnAuthorizeResponse(String message) {
        return Response.ok(new BaseResponse(message, BaseResponse.FAILURE))
                .status(Response.Status.UNAUTHORIZED)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
