package msg.user.boundary;

import msg.permission.PermissionType;
import msg.user.MessageCatalog;
import msg.user.entity.dto.UserInputDTO;
import msg.user.entity.dto.UserLoginDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.security.Permission;

@Stateless
@Path("/users")
public class UserResource {

    @EJB
    private UserFacade userFacade;

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    @POST
    public Response createUser(@Context SecurityContext securityContext, UserInputDTO input) {
        if (securityContext.isUserInRole(PermissionType.USER_MANAGEMENT)) {
            userFacade.createUser(input);
            return Response.ok().build();
        } else
            return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAll(@Context SecurityContext securityContext) {
        if (securityContext.isUserInRole(PermissionType.USER_MANAGEMENT)) {
            return Response.ok(userFacade.getAll()).build();
        } else
            return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
    }


    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @GET
    public Response getUserById(@Context SecurityContext securityContext, @PathParam("id") long id) {
        if (securityContext.isUserInRole(PermissionType.USER_MANAGEMENT)) {
            return Response.ok(userFacade.getUserById(id)).build();
        } else
            return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
    }

}
