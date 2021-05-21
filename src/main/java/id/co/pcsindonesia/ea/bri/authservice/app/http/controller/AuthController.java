package id.co.pcsindonesia.ea.bri.authservice.app.http.controller;

import id.co.pcsindonesia.ea.bri.authservice.app.http.request.AuthCreateNewRoleRequest;
import id.co.pcsindonesia.ea.bri.authservice.app.http.request.AuthRegisterRequest;
import id.co.pcsindonesia.ea.bri.authservice.app.http.response.AuthRegisterLoginResponse;
import id.co.pcsindonesia.ea.bri.authservice.app.http.response.GlobalResponse;
import id.co.pcsindonesia.ea.bri.authservice.app.model.Role;
import id.co.pcsindonesia.ea.bri.authservice.app.service.RoleService;
import id.co.pcsindonesia.ea.bri.authservice.app.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final RoleService roleService;

    @Operation(summary = "Register New user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Register Successfull",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthRegisterLoginResponse.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = @Content) })
    @PostMapping("/register")
    public GlobalResponse<AuthRegisterLoginResponse> register(@RequestBody AuthRegisterRequest authRegisterRequest){
        return userService.createNewUser(authRegisterRequest);
    }

    @Operation(summary = "Login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login Successfull",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthRegisterLoginResponse.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = @Content) })
    @PostMapping("/login")
    public void login(){}

    @Operation(summary = "Create new Role")
    @Parameters({
            @Parameter(in = ParameterIn.HEADER, name = "Authorization", schema = @Schema(type = "string", description = "Bearer Token"))
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Role Created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Role.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = @Content) })
    @PostMapping("/role")
    public Role createNewRole(@RequestBody AuthCreateNewRoleRequest authCreateNewRoleRequest){
        return roleService.createNewRole(authCreateNewRoleRequest);
    }
}
